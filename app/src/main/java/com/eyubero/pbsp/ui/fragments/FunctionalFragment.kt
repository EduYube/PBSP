package com.eyubero.pbsp.ui.fragments

import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseFragment
import com.eyubero.pbsp.databinding.FragmentFunctionalBinding

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 30/07/2018 (ノಠ益ಠ)ノ
 */

class FunctionalFragment : BaseFragment(){

    lateinit var binding: FragmentFunctionalBinding

    companion object {

        fun newInstance() = FunctionalFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_functional,container,false)
        activity!!.title = this.javaClass.simpleName.substringBefore("Fragment")
        activity!!.window.navigationBarColor = resources.getColor(R.color.yellow_pbsp)
        activity!!.window.statusBarColor = resources.getColor(R.color.yellow_pbsp)

        binding.toStrongButton.setOnClickListener {
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()

            fragmentTransaction.replace(R.id.study_activity, StrongFragment.newInstance(), StrongFragment::class.java.simpleName)
            fragmentTransaction.commit() }
        return binding.root
    }
}
