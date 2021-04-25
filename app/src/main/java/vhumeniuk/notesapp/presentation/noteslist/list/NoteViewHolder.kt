package vhumeniuk.notesapp.presentation.noteslist.list

import android.view.View
import android.widget.TextView
import vhumeniuk.notesapp.R
import vhumeniuk.notesapp.domain.Note
import vhumeniuk.notesapp.presentation.base.BaseViewHolder
import java.text.DateFormat

class NoteViewHolder(
     itemView: View,
     private val noteSelectedListener: NotesAdapter.NoteSelectedListener
): BaseViewHolder<Note>(itemView) {

    private val dateFormat = DateFormat.getTimeInstance(DateFormat.SHORT)

    override fun bind(entity: Note) {
        itemView.findViewById<TextView>(R.id.note_title).text = "[${dateFormat.format(entity.lastEdit)}] ${entity.text}"
        itemView.setOnClickListener { noteSelectedListener.selected(entity) }
    }
}