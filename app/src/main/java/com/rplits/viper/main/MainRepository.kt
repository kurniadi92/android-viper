package com.rplits.viper.main

import android.content.Context
import com.google.gson.Gson
import com.rplits.viper.R
import com.rplits.viper.University
import com.rplits.viper.UniversityList

class MainRepository(private val context: Context): MainContract.Repo {
    override fun getUniversities(): List<University> {
        val objectArrayString: String = context.resources.openRawResource(R.raw.university_list).bufferedReader().use { it.readText() }
        return Gson().fromJson(objectArrayString, UniversityList::class.java).list
    }
}