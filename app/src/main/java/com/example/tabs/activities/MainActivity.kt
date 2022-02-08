package com.example.tabs.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.viewpager.widget.ViewPager
import com.example.tabs.R
import com.example.tabs.adapter.PageAdapter
import com.google.android.material.tabs.TabLayout

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val tabLayout: TabLayout = findViewById(R.id.tabLayout)
        tabLayout.addTab(tabLayout.newTab().setText("Tab número 1"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab número 2"))
        tabLayout.addTab(tabLayout.newTab().setText("Tab número 3"))

        val vPager: ViewPager = findViewById(R.id.viewPager)
        val pAdapter = PageAdapter(supportFragmentManager, tabLayout.tabCount)

        vPager.adapter = pAdapter

        vPager.addOnPageChangeListener(TabLayout.TabLayoutOnPageChangeListener(tabLayout))

        tabLayout.addOnTabSelectedListener(object : TabLayout.OnTabSelectedListener {
            override fun onTabSelected(tab: TabLayout.Tab?) {
                val posicion = tab!!.position
                vPager.currentItem = posicion
            }

            override fun onTabUnselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "tab" + tab?.text, Toast.LENGTH_LONG).show()
            }

            override fun onTabReselected(tab: TabLayout.Tab?) {
                Toast.makeText(this@MainActivity, "tab" + tab?.text, Toast.LENGTH_LONG).show()
            }

        })
    }
}