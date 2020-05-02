package com.tkhs0604.databindingrecyclerviewsample.base.recyclerview

interface Content<E : Enum<E>> {
    val id: Long
    val viewType: E
}