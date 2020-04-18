package com.tkhs0604.databindingrecyclerviewsample.base.recyclerview

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView

@Suppress("UNCHECKED_CAST")
@BindingAdapter("items")
fun <T : Cell<E>, E : Enum<E>> RecyclerView.setItems(items: List<T>) {
    (this.adapter as? BaseListAdapter<T, E>)?.submitList(items)
}
