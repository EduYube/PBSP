package com.eyubero.pbsp.ui.activities

import android.content.Intent
import android.databinding.DataBindingUtil
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.widget.Toast
import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseActivity
import com.eyubero.pbsp.databinding.ActivityPlayerBinding
import com.eyubero.pbsp.ui.fragments.PlayerFragment

class PlayerActivity : BaseActivity() {

    lateinit var binding: ActivityPlayerBinding
    lateinit var toolbar: Toolbar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_player)
        toolbar = findViewById(R.id.toolbar_player)
        setSupportActionBar(toolbar)

        val fragmentManager = supportFragmentManager
        val fragmentTransition = fragmentManager.beginTransaction()
        fragmentTransition.replace(R.id.activity_player,PlayerFragment.newInstance(), PlayerFragment::class.java.simpleName)
        fragmentTransition.commit()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.main,menu)
        return super.onCreateOptionsMenu(menu)
    }
}
