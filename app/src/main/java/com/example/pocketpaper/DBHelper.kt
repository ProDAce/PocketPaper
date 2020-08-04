package com.example.pocketpaper

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.pocketpaper.Attributes.TodoItemAttributes
import com.example.pocketpaper.Attributes.TodoListAttributes
import java.util.ArrayList

class DBHelper(private val context: Context): SQLiteOpenHelper(context, DB_NAME, null, DB_VERSION) {
    override fun onCreate(db: SQLiteDatabase) {

        val createTodoList = "CREATE TABLE $TABLE_TODO ("+
                "$COL_ID integer PRIMARY KEY AUTOINCREMENT, "+
                "$COL_LIST_NAME varchar" +
                "$COL_GROUP integer "+
                "$COL_MODIFIED_ON datetime DEFAULT CURRENT_TIMESTAMP "+
                "$COL_CREATED_AT datetime  DEFAULT CURRENT_TIMESTAMP);"

        val createTodoItem = "CREATE TABLE $TABLE_TODO_ITEM ("+
                "$COL_ID integer PRIMARY KEY AUTOINCREMENT, "+
                "$COL_ITEM_NAME varchar" +
                "$COL_TODO_ID integer "+
                "$COL_GROUP integer "+
                "$COL_MODIFIED_ON datetime DEFAULT CURRENT_TIMESTAMP"+
                "$COL_CREATED_AT datetime  DEFAULT CURRENT_TIMESTAMP);"

        val createNotes = "CREATE TABLE $TABLE_NOTES ("+
                "$COL_ID integer PRIMARY KEY AUTOINCREMENT, "+
                "$COL_NOTES_TITLE varchar "+
                "$COL_NOTES_CONTENT varchar "+
                "$COL_GROUP integer "+
                "$COL_MODIFIED_ON datetime DEFAULT CURRENT_TIMESTAMP"+
                "$COL_CREATED_AT datetime  DEFAULT CURRENT_TIMESTAMP);"

        db.execSQL(createTodoList)
        db.execSQL(createTodoItem)
        db.execSQL(createNotes)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        TODO("Not yet implemented")
    }

    fun addTodoList(todo: TodoListAttributes)   {
        val db = writableDatabase
        val cv = ContentValues()
        cv.put(COL_LIST_NAME, todo.title)
        db.insert(TABLE_TODO, null, cv)
    }

    fun deleteToDoList(id: Long)    {
        val db = writableDatabase
        db.delete(TABLE_TODO_ITEM, "$COL_TODO_ID=?", arrayOf(id.toString()))
        db.delete(TABLE_TODO, "$COL_ID=?", arrayOf(id.toString()))
    }

    fun getTodoList(filter: Int): MutableList<TodoListAttributes>  {
        val result: MutableList<TodoListAttributes> = ArrayList()
        val db = readableDatabase
        val queryResult = when(filter)    {
            1->{ //Created
                db.rawQuery("SELECT * FROM $TABLE_TODO", null)
            }
            2->{ //Alphabetically
                db.rawQuery("SELECT * FROM $TABLE_TODO ORDER BY $COL_LIST_NAME", null)
            }
            3->{ //Colour Groups
                db.rawQuery("SELECT * FROM $TABLE_TODO ORDER BY $COL_GROUP", null)
            }
            else->{
                db.rawQuery("SELECT * FROM $TABLE_TODO ORDER BY $COL_GROUP", null)
            }

        }
        if(queryResult.moveToFirst()){
            do {
                val todo = TodoListAttributes()
                todo.id = queryResult.getLong(queryResult.getColumnIndex(COL_ID))
                todo.title = queryResult.getString(queryResult.getColumnIndex(COL_LIST_NAME))
                result.add(todo)
            } while (queryResult.moveToNext())
        }
        queryResult.close()
        return result
    }
}