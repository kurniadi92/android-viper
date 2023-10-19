package com.rplits.viper.main

import com.rplits.viper.University

class MainInteractor(private val repo: MainContract.Repo): MainContract.Interactor {
    override fun getUniversities(): List<University> {
        return repo.getUniversities()
    }
}