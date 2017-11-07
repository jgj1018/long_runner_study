package Bridge

abstract class Shape protected constructor(protected var drawAPI: DrawAPI) {
    abstract fun draw()
}