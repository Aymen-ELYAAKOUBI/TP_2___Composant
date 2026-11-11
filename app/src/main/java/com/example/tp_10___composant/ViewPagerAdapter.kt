package com.example.tp_10___composant

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ViewPagerAdapter(activity: FragmentActivity) : FragmentStateAdapter(activity) {

    override fun getItemCount(): Int = 4

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> Exercice1Fragment()
            1 -> Exercice2Fragment()
            2 -> Exercice3Fragment()
            3 -> ItemListFragment()
            else -> Exercice1Fragment()
        }
    }
}
