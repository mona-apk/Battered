package com.kamiapk.battered.viewmodel

import android.util.Log
import android.widget.ImageView
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.kamiapk.battered.R
import com.kamiapk.battered.ui.MainActivity
import kotlinx.android.synthetic.main.activity_main.*


class MainViewModel : ViewModel() {

    //表示させる数字
    private val _count : MutableLiveData<Int> = MutableLiveData(0)
    val count : LiveData<Int> = _count

    //private val input …のようにprivateにしていたため永遠に双方向性databindingができなくて詰んでいた。
    val input : MutableLiveData<String> = MutableLiveData()

    //数字が一つずつ増えていく
    fun onClick_TAP(){
        _count.value = (_count.value ?: 0) + 1
    }

    //editTextの初期化
    fun onClick_Change(){

        //editTextにいれられた数字でカウントの数字を書き換える
        if (input.value != ""){
            _count.value = input.value?.toInt()
        }

        //Changeボタンが押されたらeditTextを空にする。
        input.value = ""
    }

}