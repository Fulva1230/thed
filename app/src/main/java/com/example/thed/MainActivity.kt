package com.example.thed

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.thed.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var mainBinding: ActivityMainBinding
    var count = 0
    val itemAdapter = ItemAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        mainBinding = ActivityMainBinding.inflate(layoutInflater)
        mainBinding.recyclerView.adapter = itemAdapter
        mainBinding.button.setOnClickListener {
            ++count
            itemAdapter.stringList.add(0, "bee $count")
            itemAdapter.notifyItemInserted(0)
            mainBinding.recyclerView.scrollToPosition(0)
        }
        setContentView(mainBinding.root)
    }
}
