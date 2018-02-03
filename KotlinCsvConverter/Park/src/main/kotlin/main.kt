fun main(args: Array<String>) {
    val csvParser = CsvParser("sample.csv")
    val targe = csvParser.parseFromCsv(TargetObject::class.java)
    print(targe)
//    println(csvParser.objectToCsvString(targe))

    val target = csvParser.parseFromCsv(TargetObject::class.java)

    println("D")

}