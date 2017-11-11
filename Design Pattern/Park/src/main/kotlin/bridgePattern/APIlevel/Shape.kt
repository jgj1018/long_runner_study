package bridgePattern.APIlevel

abstract class Shape(protected val drawAPI: DrawAPI) {
    abstract fun draw()


}