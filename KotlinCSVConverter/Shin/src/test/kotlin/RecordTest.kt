import csvobjects.Record
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

class RecordTest {
    @Test
    fun testParseRecordToField() {
        val record = Record("\"\"\",\",\"asd\"")
        record.parseRecordToField()

        val record2 = Record("2018/01/14,スペーシ,,3000,스터디비")
        record2.parseRecordToField()
    }
}