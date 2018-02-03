package StatePattern

import StatePattern.state.StartState
import StatePattern.state.StopState

fun main(args: Array<String>) {
    val context = Context()

    val startState = StartState()
    startState.doAction(context)
    println(context.state.toString())

    val stopState = StopState()
    stopState.doAction(context)
    println(context.state.toString())
}