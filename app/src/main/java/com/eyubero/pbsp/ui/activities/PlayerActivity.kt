package com.eyubero.pbsp.ui.activities

import android.content.Intent
import android.content.Intent.*
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.support.design.widget.NavigationView
import android.support.v7.widget.Toolbar
import android.view.MenuItem
import android.widget.Toast

import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseActivity
import com.eyubero.pbsp.databinding.ActivityPlayerBinding
import com.eyubero.pbsp.ui.fragments.GraphFragment
import com.eyubero.pbsp.ui.fragments.dataplayer.ArticulateFragment
import com.eyubero.pbsp.ui.fragments.PlayerFragment
import com.eyubero.pbsp.ui.fragments.ReportFragment

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 30/07/2018 (ノಠ益ಠ)ノ
 */

class PlayerActivity : BaseActivity(), NavigationView.OnNavigationItemSelectedListener {

    lateinit var binding: ActivityPlayerBinding
    var closeCount = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = DataBindingUtil.setContentView(this, R.layout.activity_player)

        goToPlayerFragment()
    }

    private fun goToPlayerFragment() {


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.app_activity,PlayerFragment.newInstance(),PlayerFragment::class.java.simpleName)
        fragmentTransaction.commit()
    }

    override fun onBackPressed() {
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

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        val id = item.itemId


        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()

        when (id) {
            R.id.data_introduce -> {

                fragmentTransaction.replace(
                        R.id.app_activity,
                        ArticulateFragment.newInstance(),
                        ArticulateFragment::class.java.toString()
                ).commit()
            }
            R.id.report -> {

                fragmentTransaction.replace(
                        R.id.app_activity,
                        ReportFragment.newInstance(),
                        ReportFragment::class.java.toString()
                ).commit()
            }
            R.id.graph -> {

                fragmentTransaction.replace(
                        R.id.app_activity,
                        GraphFragment.newInstance(),
                        GraphFragment::class.java.toString()
                ).commit()
            }
            R.id.change_player -> {

                fragmentTransaction.replace(
                        R.id.app_activity,
                        PlayerFragment.newInstance(),
                        PlayerFragment::class.java.toString()
                ).commit()
            }
        }

        return true
    }
}
