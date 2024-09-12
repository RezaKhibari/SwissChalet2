package com.trios2024amrk.swisschalet

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.EditText
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.ViewModelProvider
import androidx.preference.PreferenceManager
import com.trios2024amrk.swisschalet.databinding.ActivityMainBinding
import com.trios2024amrk.swisschalet.ui.main.ListDetailActivity
import com.trios2024amrk.swisschalet.ui.main.MainFragment
import com.trios2024amrk.swisschalet.ui.main.MainViewModel
import com.trios2024amrk.swisschalet.ui.main.MainViewModelFactory

class MainActivity : AppCompatActivity(), MainFragment.MainFragmentInteractionListener {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        viewModel = ViewModelProvider(this,
            MainViewModelFactory(PreferenceManager.getDefaultSharedPreferences(this))
        )
            .get(MainViewModel::class.java)
        if (savedInstanceState == null) {
            val mainFragment = MainFragment.newInstance(this)
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, mainFragment)
                .commitNow()
        }

        binding.fabButton.setOnClickListener {
            showCreateListDialog()
        }
    }
    private fun showCreateListDialog() {

        val dialogTitle = getString(R.string.name_of_list)
        val positiveButtonTitle = getString(R.string.create_list)


        val builder = AlertDialog.Builder(this)
        val listTitleEditText = EditText(this)
        listTitleEditText.inputType = InputType.TYPE_CLASS_TEXT

        builder.setTitle(dialogTitle)
        builder.setView(listTitleEditText)


        builder.setPositiveButton(positiveButtonTitle) { dialog, _ ->
            dialog.dismiss()

            val taskList = TaskList(listTitleEditText.text.toString())
            viewModel.saveList(taskList)
            showListDetail(taskList)
        }

        builder.create().show()
    }

    private fun showListDetail(list: TaskList) {
        // 1
        val listDetailIntent = Intent(this, ListDetailActivity::class.java)
        // 2
        listDetailIntent.putExtra(INTENT_LIST_KEY, list)
        // 3
        startActivity(listDetailIntent)
    }

    companion object {
        const val INTENT_LIST_KEY = "list"
    }
    override fun listItemTapped(list: TaskList) {
        showListDetail(list)
    }

}