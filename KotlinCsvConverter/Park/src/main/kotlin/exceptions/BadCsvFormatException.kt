package exceptions

class BadCsvFormatException :Exception() {
    override val message: String?
        get() = "BAD CSV FORMAT"

    override fun printStackTrace() {
        super.printStackTrace()
        System.exit(1)
    }
}