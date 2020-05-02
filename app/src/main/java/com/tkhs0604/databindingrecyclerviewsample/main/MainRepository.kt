package com.tkhs0604.databindingrecyclerviewsample.main

import com.tkhs0604.databindingrecyclerviewsample.main.model.MainListContent
import kotlin.random.Random

class MainRepository {

    fun loadItems(): List<MainListContent> {
        return items
    }

    private val items: List<MainListContent>
        get() = samples.take(Random.nextInt(samples.size))

    companion object {
        private val samples = listOf(
            MainListContent.Cell1("Taro"),
            MainListContent.Cell2(10000),
            MainListContent.Cell1("Jiro"),
            MainListContent.Cell2(20000),
            MainListContent.Cell1("Saburo"),
            MainListContent.Cell2(30000)
        )
    }

}