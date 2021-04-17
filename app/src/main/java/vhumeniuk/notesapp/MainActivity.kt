package vhumeniuk.notesapp

import android.os.Bundle
import androidx.appcompat.widget.Toolbar
import androidx.navigation.fragment.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import vhumeniuk.notesapp.presentation.base.BaseActivity

class MainActivity: BaseActivity() {

    private val navController by lazy {
        supportFragmentManager.findFragmentById(R.id.nav_host_fragment)?.findNavController()
    }
    private val appBarConfiguration: AppBarConfiguration by lazy {
        AppBarConfiguration(navController!!.graph)
    }
    private lateinit var _toolbar: Toolbar

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun onSupportNavigateUp(): Boolean {
        return NavigationUI.navigateUp(navController!!, appBarConfiguration)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(_toolbar)
        _toolbar.setupWithNavController(navController!!, appBarConfiguration)
    }
}