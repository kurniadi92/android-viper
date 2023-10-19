package com.rplits.viper.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.rplits.viper.R
import com.rplits.viper.University
import com.rplits.viper.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), MainContract.View {
    private lateinit var binding: ActivityMainBinding
    private lateinit var presenter: MainContract.Presenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        val repository = MainRepository(this)
        presenter = MainPresenter(
            interactor = MainInteractor(repository),
            router = MainRouter(this),
            view = this
        )
        setContentView(binding.root)
        presenter.onViewCreated()
    }

    override fun publishData(data: List<University>) {
        val adapter = MainAdapter()
        adapter.onTap = {
            presenter.onTap(it)
        }
        adapter.onLongTap = {
            presenter.onLongTap(it)
        }

        binding.recyclerview.adapter = adapter
        adapter.setList(data)
    }

    override fun showMessage(msg: String) {
        Toast.makeText(this, msg, Toast.LENGTH_SHORT).show()
    }
}
