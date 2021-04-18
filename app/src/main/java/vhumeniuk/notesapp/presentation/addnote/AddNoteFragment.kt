package vhumeniuk.notesapp.presentation.addnote

import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import vhumeniuk.notesapp.R
import vhumeniuk.notesapp.databinding.FragmentAddNoteBinding
import vhumeniuk.notesapp.presentation.base.BaseFragment
import vhumeniuk.notesapp.viewmodel.AddNoteViewModel

class AddNoteFragment: BaseFragment() {

    private val addNoteViewModel: AddNoteViewModel by viewModels { viewModelFactory }
    private var binding: FragmentAddNoteBinding? = null
    private val args: AddNoteFragmentArgs by navArgs()

    override fun getLayoutId(): Int {
        return R.layout.fragment_add_note
    }

    override fun inflateView(inflater: LayoutInflater, container: ViewGroup?): View? {
        binding = FragmentAddNoteBinding.inflate(inflater, container, false)
        return binding?.root
    }

    override fun initViews() {
        super.initViews()
        binding?.noteText?.addTextChangedListener(textWatcher)
        addNoteViewModel.loadNote(args.noteId)
        addNoteViewModel.note.observe(this, Observer { note -> binding?.noteText?.setText(note.text) })
    }

    private val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) {
          p0?.let { addNoteViewModel.saveNote(it.toString()) }
        }
        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
        override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {}
    }
}