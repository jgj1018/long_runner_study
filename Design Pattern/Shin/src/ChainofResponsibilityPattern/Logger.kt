package ChainofResponsibilityPattern

enum class LogLevel() {
    // enum 클래스의 비교는 ordinal 값을 비교함
    INFO,
    DEBUG,
    ERROR
}

abstract class AbstractLogger {
    // open을 안하면 protected에서 오버라이드가 안됨
    protected open var level:LogLevel? = null

    // next element in chain or responsibility
    var nextLogger:AbstractLogger? = null

    fun logMessage(level:LogLevel, message:String) {
        // this.level을 Nullable로 지정했기 때문에 !!를 붙여줌
        if (this.level!! <= level) {
            write(message)
        }

        if (nextLogger != null) {
            // smartCast가 안되서 명시적으로 캐스팅
            (nextLogger as AbstractLogger).logMessage(level, message)
        }
    }

    abstract protected fun write(message: String)
}

class ConsoleLogger(override var level: LogLevel?):AbstractLogger() {
    override fun write(message: String) {
        println("Standard Console::Logger: $message")
    }
}

class ErrorLogger(override var level: LogLevel?):AbstractLogger() {
    override fun write(message: String) {
        println("Error Console::Logger: $message")
    }
}

class FileLogger(override var level: LogLevel?):AbstractLogger() {
    override fun write(message: String) {
        println("File::Logger: $message")
    }
}