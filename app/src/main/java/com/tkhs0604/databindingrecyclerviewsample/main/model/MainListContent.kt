package com.tkhs0604.databindingrecyclerviewsample.main.model

import com.tkhs0604.databindingrecyclerviewsample.base.recyclerview.Content
import com.tkhs0604.databindingrecyclerviewsample.common.IdGenerator

sealed class MainListContent(
    override val id: Long,
    override val type: Type
) : Content<MainListContent.Type> {

    enum class Type {
        Type1,
        Type2,
    }

    data class Cell1(val name: String) : MainListContent(
        id = generateId(Type.Type1),
        type = Type.Type1
    )

    data class Cell2(val number: Int) : MainListContent(
        id = generateId(Type.Type2),
        type = Type.Type2
    )

    companion object {
        private val idGenerator = IdGenerator()
        fun generateId(type: Type) = idGenerator.get() * Type.values().size + type.ordinal
    }

}