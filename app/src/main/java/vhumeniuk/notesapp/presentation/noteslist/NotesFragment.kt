package vhumeniuk.notesapp.presentation.noteslist

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import vhumeniuk.notesapp.R
import vhumeniuk.notesapp.databinding.FragmentNotesBinding
import vhumeniuk.notesapp.presentation.base.BaseFragment
import vhumeniuk.notesapp.presentation.noteslist.list.NotesAdapter
import vhumeniuk.notesapp.viewmodel.NotesListViewModel

class NotesFragment: BaseFragment() {

    private val notesViewModel: NotesListViewModel by viewModels { viewModelFactory }
    private var binding: FragmentNotesBinding? = null

    private val notesAdapter = NotesAdapter()
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
    }
}