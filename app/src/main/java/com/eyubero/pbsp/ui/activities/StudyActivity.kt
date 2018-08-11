package com.eyubero.pbsp.ui.activities

import android.content.Intent
import android.content.Intent.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v4.view.GravityCompat
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.ActionBarDrawerToggle
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseActivity
import com.eyubero.pbsp.databinding.ActivityStudyBinding
import com.eyubero.pbsp.ui.fragments.*

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 30/07/2018 (ノಠ益ಠ)ノ
 */

class StudyActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityStudyBinding
    lateinit var toolbar: Toolbar
    lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_study)
        toolbar = findViewById(R.id.toolbar)
        setSupportActionBar(toolbar)
        toggle = ActionBarDrawerToggle(this, binding.drawerLayout, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close)
        binding.drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        val navigationView = findViewById<NavigationView>(R.id.nav_view)
        navigationView.setNavigationItemSelectedListener(this)

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.study_activity,ArticulateFragment.newInstance(),ArticulateFragment::class.java.simpleName)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
        if (binding.drawerLayout.isDrawerOpen(GravityCompat.START)) {
            binding.drawerLayout.closeDrawer(GravityCompat.START)
        } else {
            super.onBackPressed()
        }
    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId

        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        when (id) {
            R.id.nav_articulate -> {

                fragmentTransaction.replace(R.id.study_activity, ArticulateFragment.newInstance(), ArticulateFragment::class.java.simpleName)
                fragmentTransaction.commit()
            }
            R.id.nav_flexibility -> {

                fragmentTransaction.replace(R.id.study_activity, FlexibilityFragment.newInstance(), FlexibilityFragment::class.java.simpleName)
                fragmentTransaction.commit()
            }
            R.id.nav_functional -> {

                fragmentTransaction.replace(R.id.study_activity, FunctionalFragment.newInstance(), FunctionalFragment::class.java.simpleName)
                fragmentTransaction.commit()
            }
            R.id.nav_strong -> {

                fragmentTransaction.replace(R.id.study_activity, StrongFragment.newInstance(), StrongFragment::class.java.simpleName)
                fragmentTransaction.commit()
            }
            R.id.nav_report -> {

                fragmentTransaction.replace(R.id.study_activity, FunctionalFragment.newInstance(), FunctionalFragment::class.java.simpleName)
                fragmentTransaction.commit()
            }
            R.id.nav_change_player -> {

                    fragmentTransaction.replace(R.id.activity_player, PlayerFragment.newInstance(), PlayerFragment::class.java.simpleName)
                    fragmentTransaction.commit()
            }
        }

        binding.drawerLayout.closeDrawer(GravityCompat.START)
        return true
    }
}
