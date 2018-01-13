package stream

import internal.TypeAdapter


class KVAdapter<K, V>:TypeAdapter, HashMap<K, V>(){
}