package com.trios2024amrk.swisschalet.ui.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.trios2024amrk.swisschalet.MainActivity
import com.trios2024amrk.swisschalet.R
import com.trios2024amrk.swisschalet.TaskList
import com.trios2024amrk.swisschalet.ui.main.ui.main.ListDetailFragment

class ListDetailActivity : AppCompatActivity() {

    lateinit var list: TaskList

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.list_detail_activity)
        // 1
        list = intent.getParcelableExtra(MainActivity.INTENT_LIST_KEY)!!
        // 2
        title = list.name

        if (savedInstanceState == null) {
            supportFragmentManager.beginTransaction()
                .replace(R.id.container, ListDetailFragment.newInstance())
                .commitNow()
        }
    }

}