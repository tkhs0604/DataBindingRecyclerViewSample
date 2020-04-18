package com.tkhs0604.databindingrecyclerviewsample.main

import com.tkhs0604.databindingrecyclerviewsample.main.model.MainCell

class MainRepository {

    fun loadItems(): List<MainCell> {
        return listOf(
            MainCell.Cell1("Taro"),
            MainCell.Cell2(10000),
            MainCell.Cell1("Jiro"),
            MainCell.Cell2(20000),
            MainCell.Cell1("Saburo"),
            MainCell.Cell2(30000)
        )
    }

}