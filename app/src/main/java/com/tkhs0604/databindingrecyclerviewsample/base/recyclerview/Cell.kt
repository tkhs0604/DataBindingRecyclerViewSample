package com.tkhs0604.databindingrecyclerviewsample.base.recyclerview

interface Cell<E : Enum<E>> {
    val id: Long
    val type: E
}