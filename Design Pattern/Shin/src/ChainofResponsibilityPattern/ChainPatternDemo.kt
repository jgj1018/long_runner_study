package ChainofResponsibilityPattern

fun main(args: Array<String>) {
    val loggerChain:AbstractLogger = getChainOfLogger()
    loggerChain.logMessage(LogLevel.INFO, "This is an Information")
    loggerChain.logMessage(LogLevel.DEBUG, "This is an debug level Information")
    loggerChain.logMessage(LogLevel.ERROR, "This is an error Information")
}

fun getChainOfLogger():AbstractLogger {
    val errorLogger: AbstractLogger = ErrorLogger(LogLevel.ERROR)
    val fileLogger: AbstractLogger = FileLogger(LogLevel.DEBUG)
    val consoleLogger: AbstractLogger = ConsoleLogger(LogLevel.INFO)

    errorLogger.nextLogger = fileLogger
    fileLogger.nextLogger = consoleLogger

    return errorLogger
}

/*
실행 결과
Standard Console::Logger: This is an Information
File::Logger: This is an debug level Information
Standard Console::Logger: This is an debug level Information
Error Console::Logger: This is an error Information
File::Logger: This is an error Information
Standard Console::Logger: This is an error Information
 */
// https://github.com/bitflick/TIL_draft/blob/master/201712/20171204.md