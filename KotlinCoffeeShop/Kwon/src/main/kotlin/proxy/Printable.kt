package proxy

interface Printable {
    public abstract fun setPrinterName(name :String)
    public abstract fun getPrinterName(): String
    public abstract fun print(string :String)
}