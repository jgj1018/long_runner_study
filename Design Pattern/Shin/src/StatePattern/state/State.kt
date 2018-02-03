package StatePattern.state

import StatePattern.Context

interface State {
    fun doAction(context: Context)
}