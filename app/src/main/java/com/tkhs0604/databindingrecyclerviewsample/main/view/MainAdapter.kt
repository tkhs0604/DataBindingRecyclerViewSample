package com.tkhs0604.databindingrecyclerviewsample.main.view

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import com.tkhs0604.databindingrecyclerviewsample.base.recyclerview.BaseListAdapter
import com.tkhs0604.databindingrecyclerviewsample.databinding.*
import com.tkhs0604.databindingrecyclerviewsample.main.model.MainCell

class MainAdapter(
    parentViewModel: ViewModel,
    parentLifecycleOwner: LifecycleOwner
) : BaseListAdapter<MainCell, MainCell.Type>(
    parentViewModel,
    parentLifecycleOwner,
    DiffCallback()
) {

    override fun getViewDataBinding(parent: ViewGroup, viewType: Int): ViewDataBinding {
        val inflater = LayoutInflater.from(parent.context)

        return when (MainCell.Type.values()[viewType]) {
            MainCell.Type.Type1 -> Cell1Binding.inflate(inflater, parent, false)
            MainCell.Type.Type2 -> Cell2Binding.inflate(inflater, parent, false)
        }
    }

    private class DiffCallback : DiffUtil.ItemCallback<MainCell>() {
        override fun areItemsTheSame(
            oldItem: MainCell,
            newItem: MainCell
        ) = oldItem.id == newItem.id

        override fun areContentsTheSame(
            oldItem: MainCell,
            newItem: MainCell
        ) = oldItem == newItem
    }

}