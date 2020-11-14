package com.example.smartplazatest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.example.smartplazatest.ui.HomeFragment
import com.example.smartplazatest.ui.WalletFragment
import com.ismaeldivita.chipnavigation.ChipNavigationBar

class MainActivity : AppCompatActivity() {

    private lateinit var bottomNavigationView : ChipNavigationBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        actionBar?.hide()
        bottomNavigationView = findViewById(R.id.chipNav)
        if(savedInstanceState == null) {
            handleFrame(HomeFragment())
        }
        bottomNavigationView.setItemSelected(R.id.home,true)
        bottomNavigationView.setOnItemSelectedListener {id ->
            when(id) {
                R.id.home -> handleFrame(HomeFragment())
                R.id.wallet -> handleFrame(WalletFragment())
            }
        }
    }

    private fun handleFrame(fragment: Fragment):Boolean {
        val fragmentTransaction = supportFragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frame_to_fragments,fragment).commit()
        return true
    }

}