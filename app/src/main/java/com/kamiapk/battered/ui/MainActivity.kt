package com.kamiapk.battered.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.databinding.adapters.NumberPickerBindingAdapter.setValue
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.kamiapk.battered.R
import com.kamiapk.battered.viewmodel.MainViewModel
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private val viewModel by lazy { ViewModelProviders.of(this).get(MainViewModel::class.java) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding : com.kamiapk.battered.databinding.ActivityMainBinding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.lifecycleOwner = this
        binding.viewmodel = viewModel

        //countの値に応じてUIが変わる。
        //これをViewModelのなかに突っ込めないか…?
        viewModel.count.observe(this, Observer {
            when (viewModel.count.value){
                    in 0..5 -> imageView.setImageResource(R.drawable.a)
                    in 6..11 -> imageView.setImageResource(R.drawable.b)
                    in 12..17 -> imageView.setImageResource(R.drawable.c)
                    else -> imageView.setImageResource(R.drawable.d)
            }
        })

    }

}
