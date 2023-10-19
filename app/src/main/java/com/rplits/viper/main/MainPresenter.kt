package com.rplits.viper.main

import com.rplits.viper.University

class MainPresenter constructor(
    private val interactor: MainContract.Interactor,
    private val router: MainContract.Router,
    private val view: MainContract.View
)  : MainContract.Presenter {

    private var items: MutableList<University> = mutableListOf()

    override fun onViewCreated() {
        items = interactor.getUniversities().sortedWith(compareBy { it.name }).toMutableList()
        view.publishData(items.toList())
    }

    override fun onTap(index: Int) {
        router.openUniversity(items[index].name)
    }

    override fun onLongTap(index: Int) {
        view.showMessage(items[index].name)
        items.removeAt(index)
        view.publishData(items.toList())
    }
}
