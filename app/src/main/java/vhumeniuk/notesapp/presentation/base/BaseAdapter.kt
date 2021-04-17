package vhumeniuk.notesapp.presentation.base

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter

abstract class BaseAdapter<E>(comparator: DiffUtil.ItemCallback<E>): ListAdapter<E, BaseViewHolder<E>>(comparator) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<E> {
        val itemView = LayoutInflater.from(parent.context).inflate(getItemLayout(viewType), parent, false)
        return createViewHolder(itemView, viewType)
    }

    override fun onBindViewHolder(holder: BaseViewHolder<E>, position: Int) {
        holder.bind(getItem(position))
    }

    @LayoutRes
    protected abstract fun getItemLayout(type: Int): Int
    protected abstract fun createViewHolder(itemView: View, type: Int): BaseViewHolder<E>
}