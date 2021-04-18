package vhumeniuk.notesapp.presentation.noteslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vhumeniuk.notesapp.R
import vhumeniuk.notesapp.databinding.FragmentNotesBinding
import vhumeniuk.notesapp.domain.Note
import vhumeniuk.notesapp.presentation.base.BaseFragment
import vhumeniuk.notesapp.presentation.noteslist.list.NotesAdapter
import vhumeniuk.notesapp.viewmodel.NotesListViewModel
import java.util.*

class NotesFragment: BaseFragment() {

    private val notesViewModel: NotesListViewModel by viewModels { viewModelFactory }
    private var binding: FragmentNotesBinding? = null

    private val notesAdapter = NotesAdapter(
        object : NotesAdapter.NoteSelectedListener {
            override fun selected(note: Note) {
                navigateToNote(note.id)
            }
        })
    private lateinit var notesLayoutManager: RecyclerView.LayoutManager

    override fun getLayoutId(): Int {
        return R.layout.fragment_notes
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentNotesBinding.inflate(inflater, container, false)
        return binding!!.root
    }

    override fun initViews() {
        notesLayoutManager = LinearLayoutManager(requireContext())
        binding?.notesList?. apply {
            layoutManager = notesLayoutManager
            adapter = notesAdapter
        }
        notesViewModel.notes.observe(this, Observer { notes ->
            notesAdapter.submitList(notes)
        })
        binding?.addNoteButton?.setOnClickListener { _ -> navigateToNote(UUID.randomUUID().toString()) }
    }

    private fun navigateToNote(id: String) {
        val action = NotesFragmentDirections.actionNotesFragmentToAddNoteFragment(id)
        findNavController().navigate(action)
    }
}