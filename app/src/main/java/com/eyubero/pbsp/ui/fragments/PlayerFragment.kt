package com.eyubero.pbsp.ui.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseFragment
import com.eyubero.pbsp.databinding.FragmentPlayerBinding

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 31/07/2018 (ノಠ益ಠ)ノ
 */
class PlayerFragment : BaseFragment(), View.OnClickListener{

    lateinit var binding: FragmentPlayerBinding
    companion object {
        fun newInstance() = PlayerFragment()
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View {
        binding = DataBindingUtil.inflate(inflater!!, R.layout.fragment_player, container, false)
        binding.btPlayer.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(view: View?) {

        Log.d("GoToStudie |>", "go to Studie")
        goToStudie(view)
    }

    fun goToStudie(view: View?){

        val fragmentManager = fragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.app_activity,ArticulateFragment.newInstance(),ArticulateFragment::class.java.simpleName)
        fragmentTransaction.commit()
    }
}