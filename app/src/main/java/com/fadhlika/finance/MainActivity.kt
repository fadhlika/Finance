package com.fadhlika.finance

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.design.widget.BottomNavigationView
import android.support.v4.app.Fragment

class MainActivity : AppCompatActivity() {

    private var bottomNavView : BottomNavigationView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottomNavView = findViewById(R.id.bottom_nav_view)
        bottomNavView?.setOnNavigationItemSelectedListener {
            var fragment : Fragment? = null
            when(it.itemId){
                R.id.home_menu -> fragment = HomeFragment.newInstance("", "")
                R.id.history_menu -> fragment = HistoryFragment.newInstance("", "")
                R.id.manage_menu -> fragment = ManageFragment.newInstance("", "")
            }

            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        }
    }
}
