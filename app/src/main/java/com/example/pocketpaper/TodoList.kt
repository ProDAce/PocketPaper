package com.example.pocketpaper

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatDelegate

class TodoList : AppCompatActivity() {

    var normalMode = true;


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_list)

        val vToolbar: View = findViewById(R.id.toolbar_todo__list)
        val vToolbarAdd: View = vToolbar.findViewById(R.id.ib_add_actionbarTodoList)
        val vToolbarAddMax: View = vToolbar.findViewById(R.id.iv_add_actionbarTodoList)

        vToolbarAdd.setOnClickListener {
            val intent = Intent(this, TodoItemList::class.java)
            intent.putExtra(INTENT_ID, -1)
            intent.putExtra(INTENT_Name, "")
            startActivity(intent)
        }
        vToolbarAddMax.setOnClickListener {
            if (normalMode){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES)
                normalMode = !normalMode
                
            }
                
            else    {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO)
                normalMode = !normalMode
            }

            startActivity(Intent(applicationContext, TodoList::class.java))
            finish()
        }
    }
}
