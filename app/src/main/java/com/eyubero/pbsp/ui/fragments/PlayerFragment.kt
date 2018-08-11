package com.eyubero.pbsp.ui.fragments

import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.*
import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseFragment
import com.eyubero.pbsp.databinding.FragmentPlayerBinding
import com.eyubero.pbsp.ui.activities.StudyActivity

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 31/07/2018 (ノಠ益ಠ)ノ
 */
class PlayerFragment : BaseFragment(), View.OnClickListener{

    lateinit var binding: FragmentPlayerBinding
    companion object {
        fun newInstance() = PlayerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false)
        activity!!.title = this.javaClass.simpleName.substringBefore("Fragment")
        binding.btPlayer.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(view: View?) {

        Log.d("GoToStudie |>", "go to Studie")
        goToStudie()
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId


        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }
    fun goToStudie(){

        val intent = Intent(activity, StudyActivity::class.java)
        startActivity(intent)
    }
}