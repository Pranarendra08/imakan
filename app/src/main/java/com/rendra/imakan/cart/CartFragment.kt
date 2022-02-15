package com.rendra.imakan.cart

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.rendra.imakan.R
import com.rendra.imakan.cart.orderConfirmation.OrderConfirmationActivity
import kotlinx.android.synthetic.main.fragment_cart.*


class CartFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_cart, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        btn_beli.setOnClickListener {
            startActivity(Intent(activity, OrderConfirmationActivity::class.java))
        }
    }

}