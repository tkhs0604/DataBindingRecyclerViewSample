package com.tkhs0604.databindingrecyclerviewsample.base.recyclerview

import android.view.ViewGroup
import androidx.annotation.CallSuper
import androidx.databinding.ViewDataBinding
import androidx.lifecycle.LifecycleOwner
import androidx.lifecycle.ViewModel
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.tkhs0604.databindingrecyclerviewsample.BR

abstract class BaseListAdapter<T : Content<E>, E : Enum<E>>(
    private val parentViewModel: ViewModel,
    private val parentLifecycleOwner: LifecycleOwner,
    diffCallback: DiffUtil.ItemCallback<T>
) : ListAdapter<T, BaseListAdapter<T, E>.ViewHolder>(diffCallback) {

    init {
        @Suppress("LeakingThis")
        setHasStableIds(true)
    }

    override fun getItemId(position: Int): Long {
        return getItem(position).id
    }

    override fun getItemViewType(position: Int): Int {
        return getItem(position).type.ordinal
    }

    @CallSuper
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(getViewDataBinding(parent, viewType))
    }

    @CallSuper
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.apply {
            lifecycleOwner = parentLifecycleOwner

            setVariable(BR.viewmodel, parentViewModel)
            setVariable(BR.item, getItem(position))
            setVariable(BR.position, position)

            executePendingBindings()
        }
    }

    abstract fun getViewDataBinding(parent: ViewGroup, viewType: Int): ViewDataBinding

    inner class ViewHolder(
        val binding: ViewDataBinding
    ) : RecyclerView.ViewHolder(binding.root)

}
