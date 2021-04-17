package vhumeniuk.notesapp.presentation.base

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.DaggerFragment
import javax.inject.Inject

abstract class BaseFragment: DaggerFragment() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflateView(inflater, container)
        setHasOptionsMenu(showOptionsMenu())
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initViews()
    }

    open fun inflateView(
        inflater: LayoutInflater,
        container: ViewGroup?): View? {
        return inflater.inflate(getLayoutId(), container, false)
    }

    open fun showOptionsMenu(): Boolean {
        return false
    }

    open fun initViews() {}

    @LayoutRes
    abstract fun getLayoutId(): Int
}