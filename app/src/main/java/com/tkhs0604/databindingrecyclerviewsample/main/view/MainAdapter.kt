package com.tkhs0604.databindingrecyclerviewsample.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.tkhs0604.databindingrecyclerviewsample.base.recyclerview.BaseListAdapter
import com.tkhs0604.databindingrecyclerviewsample.databinding.ItemType1Binding
import com.tkhs0604.databindingrecyclerviewsample.databinding.ItemType2Binding
import com.tkhs0604.databindingrecyclerviewsample.main.model.MainListContent

class MainAdapter(
    parentViewModel: ViewModel,
    parentLifecycleOwner: LifecycleOwner
) : BaseListAdapter<MainListContent, MainListContent.ViewType>(
    parentViewModel,
    parentLifecycleOwner,
    DiffCallback()
) {

    override fun getViewDataBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val inflater = LayoutInflater.from(parent.context)

        return when (MainListContent.ViewType.values()[viewType]) {
            MainListContent.ViewType.Type1 -> ItemType1Binding.inflate(inflater, parent, false)
            MainListContent.ViewType.Type2 -> ItemType2Binding.inflate(inflater, parent, false)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<MainListContent>() {
        override fun areItemsTheSame(
            oldItem: MainListContent,
            newItem: MainListContent
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MainListContent,
            newItem: MainListContent
        ) = oldItem == newItem
    }

}