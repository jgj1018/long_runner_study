package json

class JsonRootObject() {
    var jsonSet = mutableSetOf<Json>()

    fun addJson(json: Json) {
        jsonSet.add(json)
    }
}