package com.rendra.imakan.home

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import androidx.fragment.app.Fragment
import com.rendra.imakan.R
import com.rendra.imakan.cart.CartFragment
import com.rendra.imakan.chat.ChatFragment
import com.rendra.imakan.explore.ExploreFragment
import kotlinx.android.synthetic.main.activity_home_page.*

class HomePageActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_page)

        val fragmentHome = HomeFragment()
        val fragmentExplore = ExploreFragment()
        val fragmentCart = CartFragment()
        val fragmentChat = ChatFragment()

        setFragment(fragmentHome)

        iv_home.setOnClickListener {
            setFragment(fragmentHome)

            changeIcon(iv_home, R.drawable.home_active)
            changeIcon(iv_explore, R.drawable.explore)
            changeIcon(iv_chat, R.drawable.chat)
            changeIcon(iv_profile, R.drawable.profile)
        }

        iv_explore.setOnClickListener {
            setFragment(fragmentExplore)

            changeIcon(iv_home, R.drawable.home)
            changeIcon(iv_explore, R.drawable.explore_active)
            changeIcon(iv_chat, R.drawable.chat)
            changeIcon(iv_profile, R.drawable.profile)
        }

        iv_cart.setOnClickListener {
            setFragment(fragmentCart)

            changeIcon(iv_home, R.drawable.home)
            changeIcon(iv_explore, R.drawable.explore)
            changeIcon(iv_chat, R.drawable.chat)
            changeIcon(iv_profile, R.drawable.profile)
        }

        iv_chat.setOnClickListener {
            setFragment(fragmentChat)

            changeIcon(iv_home, R.drawable.home)
            changeIcon(iv_explore, R.drawable.explore)
            changeIcon(iv_chat, R.drawable.chat_active)
            changeIcon(iv_profile, R.drawable.profile)
        }

    }

    private fun setFragment(fragment: Fragment) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.layout_home, fragment)
        fragmentTransaction.commit()
    }

    private fun changeIcon(imageView: ImageView, int: Int) {
        imageView.setImageResource(int)
    }
}