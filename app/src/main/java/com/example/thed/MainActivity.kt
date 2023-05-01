package com.example.thed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    var count = 0
    val rollAdapter = RollAdapter()
    var diceNum = 5

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.recyclerView.adapter = rollAdapter
        mainBinding.button.setOnClickListener {
            rollAdapter.rollList.add(0, listOf(1, 2, 3, 4, 5))
            rollAdapter.notifyItemInserted(0)
            mainBinding.recyclerView.scrollToPosition(0)
        }
        setContentView(mainBinding.root)
    }
}
