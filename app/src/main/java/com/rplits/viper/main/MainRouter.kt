package com.rplits.viper.main

import android.content.Intent
import com.rplits.viper.detail.DetailActivity

class MainRouter(private val activity: MainActivity) : MainContract.Router {
    override fun openUniversity(name: String) {
        val intent = Intent(activity, DetailActivity::class.java)
        intent.putExtra("university_name", name)

        activity.startActivity(intent)
    }
}