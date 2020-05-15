package com.eburg_soft.lifehackstudiotestapp.presentation

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.eburg_soft.lifehackstudiotestapp.R.layout

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout.activity_main)

        if (savedInstanceState==null){
            supportFragmentManager
                .beginTransaction()
                .add()
        }
    }
}
