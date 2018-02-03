package ObserverDelegation

import kotlin.properties.Delegates

class User {
    var name: String by Delegates.observable("<No name>") {
        property, oldValue, newValue ->
        println("$oldValue -> $newValue")
    }
}