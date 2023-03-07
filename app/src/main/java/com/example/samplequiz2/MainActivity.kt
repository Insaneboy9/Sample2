package com.example.samplequiz2

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.samplequiz2.databinding.ActivityMainBinding
import com.example.samplequiz2.db.BusAdapter
import com.example.samplequiz2.db.BusViewModel

class MainActivity : AppCompatActivity() {


    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val viewModel: BusViewModel= ViewModelProvider(this)[BusViewModel::class.java]

        val listAdapter = BusAdapter(listOf())
        binding.recyclerViewBusRoute.adapter = listAdapter

        // initialise the data
        viewModel.allData.observe(this) {
            listAdapter.items = it
            listAdapter.notifyDataSetChanged()
        }

        // Print whole list
        binding.recyclerViewBusRoute.layoutManager =
            LinearLayoutManager(this@MainActivity)

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        when (item.itemId) {
            R.id.action_menu -> {
                val intent = Intent(this, AddBusRouteActivity::class.java)
                startActivity(intent)
            }
            else -> {
                return super.onOptionsItemSelected(item)
            }
        }
        return true
    }

}