package com.example.dukaan.ui

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.TextView
import androidx.annotation.IdRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.example.dukaan.R
import com.example.dukaan.ui.home.HomeFragment
import com.example.dukaan.ui.orders.OrdersFragment
import com.google.android.material.bottomnavigation.BottomNavigationItemView
import com.google.android.material.bottomnavigation.BottomNavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_main.view.*


class DashBoard : AppCompatActivity() {
    lateinit var mContext: Context
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        nav_view.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener)
        addFragmentToActivity(HomeFragment())
        mContext = this
        showBadge(nav_view, R.id.navigation_orders,"4")

    }


    val mOnNavigationItemSelectedListener =
            BottomNavigationView.OnNavigationItemSelectedListener { item ->
                when (item.itemId) {
                    R.id.navigation_home -> {
                        addFragmentToActivity(HomeFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_orders -> {
                        addFragmentToActivity(OrdersFragment())
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_products -> {
                        // put your code here
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_marketing -> {
                        // put your code here
                        return@OnNavigationItemSelectedListener true
                    }
                    R.id.navigation_account -> {
                        // put your code here
                        return@OnNavigationItemSelectedListener true
                    }
                }
                false
            }

    fun addFragmentToActivity(fragment: Fragment?) {
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.content_fragment, fragment!!)
        transaction.addToBackStack(null)

        transaction.commit()
    }

    fun showBadge(bottomNavigationView: BottomNavigationView, @IdRes itemId: Int, value: String?) {
        removeBadge(bottomNavigationView, itemId)
        val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
        val badge = LayoutInflater.from(mContext).inflate(R.layout.badge_layout, bottomNavigationView, false)
        val text: TextView = badge.findViewById(R.id.badge_text_view)
        text.text = value
        itemView.addView(badge)
    }

    fun removeBadge(bottomNavigationView: BottomNavigationView, @IdRes itemId: Int) {
        val itemView: BottomNavigationItemView = bottomNavigationView.findViewById(itemId)
        if (itemView.childCount == 3) {
            itemView.removeViewAt(2)
        }
    }
}