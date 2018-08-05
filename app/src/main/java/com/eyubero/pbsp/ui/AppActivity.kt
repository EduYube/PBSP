package com.eyubero.pbsp.ui

import android.arch.lifecycle.ViewModelProvider
import android.content.Intent
import android.content.Intent.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast

import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseActivity
import com.eyubero.pbsp.databinding.ActivityAppBinding
import com.eyubero.pbsp.ui.fragments.PlayerFragment

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 30/07/2018 (ノಠ益ಠ)ノ
 */

class AppActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityAppBinding
    lateinit var toolbar: Toolbar
    lateinit var toggle: ActionBarDrawerToggle
    var closeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_app)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.app_activity,PlayerFragment.newInstance(),PlayerFragment::class.java.simpleName)
        fragmentTransaction.commit()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            if (closeCount == 0) {
                Toast.makeText(this, getString(R.string.back_pressed_text), Toast.LENGTH_LONG).show()
                closeCount++
            } else {
                closeCount = 0
                intent = Intent(ACTION_MAIN)
                intent.addCategory(CATEGORY_HOME)
                intent.flags = FLAG_ACTIVITY_NEW_TASK
                startActivity(intent)
                finish()
            }
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        when (id) {
            R.id.data_introduce -> {

            }
            R.id.report -> {

            }
            R.id.graph -> {

            }
            R.id.add_images -> {

            }
            R.id.change_player -> {

                fragmentTransaction.replace(
                        R.id.app_activity,
                        PlayerFragment.newInstance(),
                        PlayerFragment::class.java.toString()
                ).commit()
            }
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
