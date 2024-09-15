package com.trios2024amrk.swisschalet.ui.main.ui.main

import androidx.lifecycle.ViewModel
import com.trios2024amrk.swisschalet.TaskList

class ListDetailViewModel() : ViewModel() {

    lateinit var onTaskAdded: (() -> Unit)

    lateinit var list: TaskList

    fun addTask(task: String) {
        list.tasks.add(task)
        onTaskAdded.invoke()
    }


}
