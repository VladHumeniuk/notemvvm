package vhumeniuk.notesapp.presentation.base

import android.content.res.Resources
import android.view.View
import androidx.recyclerview.widget.RecyclerView

abstract class BaseViewHolder<E>(itemView: View): RecyclerView.ViewHolder(itemView) {

    abstract fun bind(entity: E)
}