package com.example.pocketpaper

import android.content.Context

class Preference(context: Context) {
    val PREFERENCE_NAME = "preference"
    val COUNT_PREF = "Count"

    //val LIGHT_NIGHT_MODE

    val preference = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE)

    fun getCount(): Int   {
        return preference.getInt(COUNT_PREF, 99)
    }

    fun setNum(n: Int)  {
        val editor = preference.edit()
        editor.putInt(COUNT_PREF, n)
        editor.apply()
    }

}