package com.example.mvvmproject.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.mvvmproject.R
import kotlinx.android.synthetic.main.activity_main.*
import org.koin.android.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private val mainViewModel: MainViewModel by viewModel()

    private val mainAdapter: MainAdapter =
        MainAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUi()
        subscribeToDo()
    }

    override fun onResume() {
        super.onResume()
        if (mainAdapter.itemCount == 0) {
            getToDoById()
        }
    }

    private fun subscribeToDo() = mainViewModel.todo.observe(this, Observer {
        when (val response = it) {
            is MainViewModel.ToDoStatus.Sucess -> mainAdapter.addOneItem(response.todo)
            is MainViewModel.ToDoStatus.Failure -> Toast.makeText(
                this,
                "Nel perro",
                Toast.LENGTH_LONG
            ).show()
        }
    })

    private fun setupUi() {
        mainRecycler.adapter = mainAdapter
        addElement.setOnClickListener {
            getToDoById()
        }
    }

    private fun getToDoById() {
        mainViewModel.getToDoById(
            mainAdapter.itemCount + 1
        )
    }
}
