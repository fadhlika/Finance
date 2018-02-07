package com.fadhlika.finance.View

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import com.fadhlika.finance.R
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        bottom_nav_view.setOnNavigationItemSelectedListener {
            var fragment : Fragment? = null
            when(it.itemId){
                R.id.home_menu -> fragment = HomeFragment.newInstance("", "")
                R.id.history_menu -> fragment = HistoryFragment.newInstance("", "")
                R.id.new_menu -> fragment = NewFragment.newInstance("", "")
            }

            supportFragmentManager.beginTransaction().replace(R.id.frame, fragment).commit()
            true
        }

        bottom_nav_view.selectedItemId = R.id.home_menu
    }
}
