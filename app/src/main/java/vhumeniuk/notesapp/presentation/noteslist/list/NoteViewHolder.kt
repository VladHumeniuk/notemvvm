package vhumeniuk.notesapp.presentation.noteslist.list

import android.view.View
import vhumeniuk.notesapp.databinding.ListItemNoteBinding
import vhumeniuk.notesapp.domain.Note
import vhumeniuk.notesapp.presentation.base.BaseViewHolder

class NoteViewHolder(
     itemView: View,
     private val noteSelectedListener: NotesAdapter.NoteSelectedListener
): BaseViewHolder<Note>(itemView) {

    private var binding: ListItemNoteBinding? = null

    override fun bind(entity: Note) {
        binding = ListItemNoteBinding.bind(itemView)
        binding?.note = entity
        itemView.setOnClickListener { noteSelectedListener.selected(entity) }
    }
}