package csvobjects

import java.io.File

/**
 * 하나의 파일
 */
class CSVObject(val rawString: String, private val listOfRecord:MutableList<Record>) {
    fun numberOfRecords() = listOfRecord.size
    fun numberOfAllFields(): Int {
        return listOfRecord.map {
            it -> it.numberOfFields()
        }.sum()
    }
}