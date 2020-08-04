package com.example.pocketpaper

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.drawable.GradientDrawable
import android.graphics.drawable.LayerDrawable
import android.os.Build
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.*
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.graphics.drawable.DrawableCompat
import kotlinx.android.synthetic.main.activity_todo_item_list.*


class TodoItemList : AppCompatActivity() {

    var editMode = true
    var strTitle = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_item_list)

        strTitle = INTENT_Name

        val ivGroup: ImageView = findViewById(R.id.iv_color_todoItemList)
        val ivEdit: ImageView = findViewById(R.id.iv_edit_todoItemList)
        val ivDone: ImageView = findViewById(R.id.iv_done_todoItemList)
        val tvTitle: TextView = findViewById(R.id.tv_title_todoItemList)
        val etTitle: EditText = findViewById(R.id.et_title_todoItemList)


        val vToolbar: View = findViewById(R.id.toolbar_todo_item_list)
        val vToolbarBack: View = vToolbar.findViewById(R.id.ib_back_actionbarTodoItemList)

        val vColorGroup: View = findViewById(R.id.colorGroup_todo_item_list)
        val vColorGroupNull: View = vColorGroup.findViewById(R.id.iv_null_popupColorGroup)
        val vColorGroupRed: View = vColorGroup.findViewById(R.id.iv_red_popupColorGroup)
        val vColorGroupBlue: View = vColorGroup.findViewById(R.id.iv_blue_popupColorGroup)
        val vColorGroupGreen: View = vColorGroup.findViewById(R.id.iv_green_popupColorGroup)
        val vColorGroupYellow: View = vColorGroup.findViewById(R.id.iv_yellow_popupColorGroup)
        val vColorGroupCyan: View = vColorGroup.findViewById(R.id.iv_cyan_popupColorGroup)
        val vColorGroupMagenta: View = vColorGroup.findViewById(R.id.iv_magenta_popupColorGroup)

        val addBtn: Button = findViewById(R.id.btn_addItem_todoItemList)


        vToolbarBack.setOnClickListener {
            startActivity(Intent(this, TodoList::class.java))
        }

        ivEdit.setOnClickListener {
            ivEdit.visibility = View.GONE
            tvTitle.visibility = View.GONE
            ivDone.visibility = View.VISIBLE
            etTitle.visibility = View.VISIBLE
            addBtn.visibility = View.VISIBLE
        }

        ivDone.setOnClickListener {
            strTitle = etTitle.text.toString()

            if(strTitle.isNotEmpty())
                tvTitle.text = strTitle
            ivEdit.visibility = View.VISIBLE
            tvTitle.visibility = View.VISIBLE
            ivDone.visibility = View.GONE
            etTitle.visibility = View.GONE
            addBtn.visibility = View.GONE
        }

        ivGroup.setOnClickListener {
            vColorGroup.visibility = View.VISIBLE
            /*if(i){
                ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_red))
                i=!i
            }

            else
            {
                ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_yellow))
                i=!i
            }*/

            /*DrawableCompat.setTint(
                DrawableCompat.wrap(ivGroup.drawable),
                ContextCompat.getColor(this, R.color.colorYellow))*/
        }

        vColorGroupNull.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_null))
        }

        vColorGroupRed.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_red))
        }

        vColorGroupGreen.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_green))
        }
        vColorGroupBlue.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_blue))
        }
        vColorGroupYellow.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_yellow))
        }
        vColorGroupMagenta.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_magenta))
        }
        vColorGroupCyan.setOnClickListener {
            vColorGroup.visibility = View.GONE
            ivGroup.setImageDrawable(ContextCompat.getDrawable(this, R.drawable.ic_circle_group_cyan))
        }


        //**************************************************************************

        /*val vToolbar: View = findViewById(R.id.toolbar_todo_item_list)
        val vToolbarBack: View = vToolbar.findViewById(R.id.ib_back_actionbarTodoList)
        val vToolbarCircle: View = vToolbar.findViewById(R.id.ib_circle_actionbarTodoList)
        val vToolbarArchive: View = vToolbar.findViewById(R.id.ib_archive_actionbarTodoList)
        val vToolbarPin: View = vToolbar.findViewById(R.id.ib_pin_actionbarTodoList)
        val vToolbarReminder: View = vToolbar.findViewById(R.id.ib_reminder_actionbarTodoList)
        val vToolbarMore: View = vToolbar.findViewById(R.id.ib_more_actionbarTodoList)

        vToolbarBack.setOnClickListener {

            vToolbarCircle.visibility = if(i)View.GONE else View.VISIBLE
            vToolbarArchive.visibility = if(i)View.GONE else View.VISIBLE
            vToolbarPin.visibility = if(i)View.GONE else View.VISIBLE
            vToolbarReminder.visibility = if(i)View.GONE else View.VISIBLE
            i = !i
            val toast = Toast.makeText(this, "BACK", Toast.LENGTH_LONG)
            toast.show()
        }

        vToolbarMore.setOnClickListener {
            val popup = PopupMenu(this, vToolbarMore)
            popup.inflate(R.menu.test_menu)
            popup.show()
        }*/

        //******************************************************************************


        /*val tv: TextView = findViewById(R.id.tv_title_todoItemList)
        tv.setOnClickListener {
            Toast.makeText(this, "BACK", Toast.LENGTH_LONG)
        }*/



        /*val mActionBar: android.app.ActionBar? = actionBar
        mActionBar?.setDisplayShowHomeEnabled(false)
        mActionBar?.setDisplayShowTitleEnabled(false)

        val toolBarInflater: LayoutInflater = LayoutInflater.from(this)
        val toolBaCustomView: View = toolBarInflater.inflate(R.layout.actionbar_todo_item_list, null)
        mActionBar?.customView = toolBaCustomView
        mActionBar?.setDisplayShowCustomEnabled(true)*/

        /*this.supportActionBar?.displayOptions = ActionBar.DISPLAY_SHOW_CUSTOM
        supportActionBar?.setDisplayShowCustomEnabled(true)
        supportActionBar?.setCustomView(R.layout.actionbar_todo_item_list)*/


    }

    fun onCreateList()
    {

    }
}
