package com.emanuel.sharedpreferences

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import com.emanuel.sharedpreferences.databinding.ActivityMainBinding
import com.emanuel.sharedpreferences.utils.Preferences
import com.emanuel.sharedpreferences.viewmodel.NamesViewModel

class MainActivity : AppCompatActivity() {

    private val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    private val viewModel: NamesViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        initNames()
        setListeners()
        setObservers()

    }

    private fun initNames() {
        Preferences(this).readNames()?.let { viewModel.setSaveName(it) }
        binding.textName.text = viewModel.listNames.value
    }

    private fun setListeners() {
        binding.run {
            buttonSave.setOnClickListener {
                val name = binding.inputEditName.text.toString()
                viewModel.saveNames(name)
                Preferences(this@MainActivity).saveNames(viewModel.listNames.value)
            }

            buttonRest.setOnClickListener {
                viewModel.clearNames()
                Preferences(this@MainActivity).saveNames(viewModel.listNames.value)
            }
        }
    }

    private fun setObservers() {
        viewModel.listNames.observe(this) { name ->
            binding.textName.text = name
        }
    }

}