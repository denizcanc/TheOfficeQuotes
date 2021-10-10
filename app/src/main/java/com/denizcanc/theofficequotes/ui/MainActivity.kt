package com.denizcanc.theofficequotes.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.core.view.isVisible
import androidx.lifecycle.Observer
import com.denizcanc.theofficequotes.databinding.ActivityMainBinding
import com.denizcanc.theofficequotes.model.Quote
import com.denizcanc.theofficequotes.state.DataState
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    private val viewModel: MainViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)
        binding.buttonQuery.setOnClickListener {
            viewModel.setStateEvent(MainStateEvent.GetQuoteEvent)
        }
        subscribe()
        viewModel.setStateEvent(MainStateEvent.GetQuoteEvent)
    }

    private fun subscribe(){
        viewModel.dataState.observe(this, Observer { dataState ->
            when(dataState){
                is DataState.Success<Quote> -> {
                    displayProgressBar(false)
                    displayQuote(dataState.data)
                }
                is DataState.Error -> {
                    displayProgressBar(false)
                    displayError(dataState.exception.message)
                }
                is DataState.Loading -> {
                    displayProgressBar(true)
                }
            }
        })
    }

    private fun displayQuote(quote: Quote){
        binding.tvQuote.text = quote.text
        binding.tvAuthor.text = quote.author
    }

    private fun displayError(message: String?){
        binding.tvQuote.text = message ?: "Unknown error."
        binding.tvAuthor.text = ""
    }

    private fun displayProgressBar(isDisplayed: Boolean){
        binding.progressBar.isVisible = isDisplayed
    }
}