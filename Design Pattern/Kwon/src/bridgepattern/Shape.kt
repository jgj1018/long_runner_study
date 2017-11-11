package bridgepattern

public abstract class Shape() {
    lateinit  var drawAPI : DrawAPI

    constructor(drawAPI : DrawAPI) : this() {
        this.drawAPI = drawAPI
    }

    public abstract fun draw()

}