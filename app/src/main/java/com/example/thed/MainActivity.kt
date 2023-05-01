package com.example.thed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thed.databinding.ActivityMainBinding
import kotlinx.coroutines.yield
import kotlin.math.max
import kotlin.math.min
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    var count = 0
    val rollAdapter = RollAdapter()
    var diceNum = 1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.recyclerView.adapter = rollAdapter
        mainBinding.roll.setOnClickListener {
            rollAdapter.rollList.add(0, sequence {
                for (i in 0 until diceNum) {
                    yield(Random.Default.nextInt(1, 7))
                }
            }.toList())
            rollAdapter.notifyItemInserted(0)
            mainBinding.recyclerView.scrollToPosition(0)
        }
        mainBinding.plusButton.setOnClickListener {
            diceNum = min(diceNum + 1, 10)
            mainBinding.diceNum.text = "$diceNum"
        }
        mainBinding.minusButton.setOnClickListener {
            diceNum = max(diceNum - 1, 1)
            mainBinding.diceNum.text = "$diceNum"
        }
        setContentView(mainBinding.root)
    }
}
