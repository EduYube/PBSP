package com.eyubero.pbsp.base

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.eyubero.pbsp.R

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 30/07/2018 (ノಠ益ಠ)ノ
 */

abstract class BaseActivity : AppCompatActivity(){

    var closeCount = 0

    override fun onBackPressed() {
        if (closeCount == 0) {
            Toast.makeText(this, getString(R.string.back_pressed_text), Toast.LENGTH_LONG).show()
            closeCount++
        } else {
            closeCount = 0
            intent = Intent(Intent.ACTION_MAIN)
            intent.addCategory(Intent.CATEGORY_HOME)
            intent.flags = Intent.FLAG_ACTIVITY_NEW_TASK
            startActivity(intent)
            finish()
        }
    }
}
