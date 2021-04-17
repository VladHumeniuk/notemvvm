package vhumeniuk.notesapp.presentation.noteslist.list

import android.view.View
import androidx.recyclerview.widget.DiffUtil
import vhumeniuk.notesapp.R
import vhumeniuk.notesapp.domain.Note
import vhumeniuk.notesapp.presentation.base.BaseAdapter
import vhumeniuk.notesapp.presentation.base.BaseViewHolder

class NotesAdapter: BaseAdapter<Note>(NoteComparator()) {

    override fun getItemLayout(type: Int): Int {
        return R.layout.list_item_note
    }

    override fun createViewHolder(itemView: View, type: Int): BaseViewHolder<Note> {
        return NoteViewHolder(itemView)
    }

    class NoteComparator: DiffUtil.ItemCallback<Note>() {

        override fun areItemsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: Note, newItem: Note): Boolean {
            return oldItem.text == newItem.text
        }
    }
}