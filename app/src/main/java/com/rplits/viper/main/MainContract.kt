package com.rplits.viper.main

import com.rplits.viper.University

interface MainContract {
    interface View {
        fun publishData(data: List<University>)
        fun showMessage(msg: String)
    }

    interface Presenter {
        fun onViewCreated()
        fun onTap(index: Int)
        fun onLongTap(index: Int)
    }

    interface Interactor {
        fun getUniversities(): List<University>
    }

    interface Router {
        fun openUniversity(name: String)
    }

    interface Repo {
        fun getUniversities(): List<University>
    }
}