package com.tkhs0604.databindingrecyclerviewsample.main.model

import com.tkhs0604.databindingrecyclerviewsample.base.recyclerview.Content
import com.tkhs0604.databindingrecyclerviewsample.common.IdGenerator

sealed class MainListContent(
    override val id: Long,
    override val viewType: ViewType
) : Content<MainListContent.ViewType> {

    enum class ViewType {
        Type1,
        Type2,
    }

    data class Cell1(val name: String) : MainListContent(
        id = generateId(ViewType.Type1),
        viewType = ViewType.Type1
    )

    data class Cell2(val number: Int) : MainListContent(
        id = generateId(ViewType.Type2),
        viewType = ViewType.Type2
    )

    companion object {
        private val idGenerator = IdGenerator()
        fun generateId(viewType: ViewType) = idGenerator.get() * ViewType.values().size + viewType.ordinal
    }

}