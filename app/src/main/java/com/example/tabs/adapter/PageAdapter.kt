package com.example.tabs.adapter

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentStatePagerAdapter
import com.example.tabs.fragments.TabDos
import com.example.tabs.fragments.TabTres
import com.example.tabs.fragments.TabUno

class PageAdapter(fm: FragmentManager?, val numTabs: Int) : FragmentStatePagerAdapter(fm!!) {

    override fun getItem(position: Int): Fragment {
        return when (position) {
            0 -> TabUno()
            1 -> TabDos()
            2 -> TabTres()
            else -> null!!
        }
    }

    override fun getCount(): Int {
        return numTabs
    }
}