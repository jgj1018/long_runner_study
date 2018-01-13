package com.example.jsonparser.service

import com.example.jsonparser.util.MainParser
import org.springframework.stereotype.Service
import java.util.ArrayList

@Service("userService")
class ParsingServiceImpl: ParsingService {

    override fun extractObjects(array: String) : LinkedHashMap<String,String>  {
        var stringval : String? = null
        var jsonmap : LinkedHashMap<String,String>? = null

        var resultmap: LinkedHashMap<String,String>?= null
        var result = ArrayList<String>()
        var state : MainParser.ParserState = MainParser.ParserState.READING_ARRAY
        var currentObject: StringBuilder? = null
        var i = 0
        var bracketBalance = 0
        var braceBalance = 0
        for ((index, value) in array.toCharArray().withIndex()) {
            when (value) {
                '{' -> {

                    currentObject = StringBuilder()
                    if (index == 0) {
                        jsonmap = LinkedHashMap<String,String>()
                        state = MainParser.ParserState.READING_OBJECT

                    }else {
                        resultmap = LinkedHashMap<String,String>()
                        state = MainParser.ParserState.READING_CONTAINOBJECT

                    }
                    braceBalance++

                }
                '}' -> {
                    if (state == MainParser.ParserState.READING_ARRAY) {
                        println("unexpected } !!!!!!!!!!!!!!!!!!!!!!!!!!!!")
                    } else {

                        var strarray: List<String>  = currentObject.toString()!!.split(":")

                        if(strarray.size > 0 &&  braceBalance == 1) {
                            jsonmap!!.put(strarray[0], strarray[1])
                        }
                        if(strarray.size > 0 &&  braceBalance > 1) {
                            resultmap!!.put(strarray[0], strarray[1])
                        }
                        state = MainParser.ParserState.READING_ARRAY
                        braceBalance--
                    }
                }
                ',' -> {
                    var strarray: List<String>  = currentObject.toString()!!.split(":")

                    if(strarray.size > 0 &&  state == MainParser.ParserState.READING_OBJECT) {
                        jsonmap!!.put(strarray[0], strarray[1])
                    }
                    if(strarray.size > 0 &&  state == MainParser.ParserState.READING_CONTAINOBJECT) {
                        resultmap!!.put(strarray[0], strarray[1])
                    }
                }
                ':' -> {

                }
                '[' -> {

                }
                ']' -> {

                }
                else -> {
                    currentObject!!.append(value)
                }
            }
            i++
        }
        return jsonmap as LinkedHashMap<String, String>
    }



}