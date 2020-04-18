package com.tkhs0604.databindingrecyclerviewsample.common

class IdGenerator(private var lastId: Long = 0) {

    private val ids = hashMapOf<String, Long>()

    operator fun get(key: String): Long {
        ids[key]?.let { return it }
        return lastId++.also { ids[key] = it }
    }

    fun get() = lastId++

}
