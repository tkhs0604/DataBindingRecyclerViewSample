package com.tkhs0604.databindingrecyclerviewsample.main

import com.tkhs0604.databindingrecyclerviewsample.main.model.MainListContent
import kotlin.random.Random

class MainRepository {

    fun loadContents(): List<MainListContent> {
        return contents
    }

    private val contents: List<MainListContent>
        get() = samples.take(Random.nextInt(samples.size))

    companion object {
        private val samples = listOf(
            MainListContent.Content1("Taro"),
            MainListContent.Content2(10000),
            MainListContent.Content1("Jiro"),
            MainListContent.Content2(20000),
            MainListContent.Content1("Saburo"),
            MainListContent.Content2(30000)
        )
    }

}