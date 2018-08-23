package com.eyubero.pbsp.ui.fragments

import android.databinding.DataBindingUtil
import android.graphics.drawable.ColorDrawable
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseFragment
import com.eyubero.pbsp.databinding.FragmentArticulateBinding

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 30/07/2018 (ノಠ益ಠ)ノ
 */

class ArticulateFragment : BaseFragment() {

    lateinit var binding: FragmentArticulateBinding

    companion object {
        fun newInstance() = ArticulateFragment()
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_articulate, container, false)
        activity!!.title = this.javaClass.simpleName.substringBefore("Fragment")
        activity!!.window.navigationBarColor = resources.getColor(R.color.blue_pbsp)
        activity!!.window.statusBarColor = resources.getColor(R.color.blue_pbsp)

        binding.toFlexibility.setOnClickListener {
            val fragmentManager = fragmentManager
            val fragmentTransaction = fragmentManager!!.beginTransaction()

            fragmentTransaction.replace(R.id.study_activity, FlexibilityFragment.newInstance(), FlexibilityFragment::class.java.simpleName)
            fragmentTransaction.commit() }
        return binding.root
    }
}

