package com.rendra.imakan.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.rendra.imakan.R
import com.rendra.imakan.home.explore.ExploreFragment
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val fragmentHome = HomeFragment()
        val fragmentExplore = ExploreFragment()

        setFragment(fragmentHome)

        iv_home.setOnClickListener {
            setFragment(fragmentHome)
        }

        iv_explore.setOnClickListener {
            setFragment(fragmentExplore)
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_home, fragment)
        fragmentTransaction.commit()
    }

}