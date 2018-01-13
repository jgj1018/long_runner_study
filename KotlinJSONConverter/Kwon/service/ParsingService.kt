package com.example.jsonparser.service

interface ParsingService {
    fun extractObjects(array: String) : LinkedHashMap<String,String>
}