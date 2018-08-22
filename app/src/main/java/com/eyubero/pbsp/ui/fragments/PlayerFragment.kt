package com.eyubero.pbsp.ui.fragments

import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.databinding.DataBindingUtil
import android.os.Bundle
import android.view.*
import android.widget.Toast
import android.widget.Toast.LENGTH_LONG
import com.eyubero.pbsp.R
import com.eyubero.pbsp.base.BaseFragment
import com.eyubero.pbsp.databinding.FragmentPlayerBinding
import com.eyubero.pbsp.model.PlayerModel
import com.eyubero.pbsp.ui.activities.StudyActivity
import com.eyubero.pbsp.viewmodel.PlayerViewModel

/**
 * Created by Edu Yube ┌(▀Ĺ̯ ▀-͠ )┐
 * on 31/07/2018 (ノಠ益ಠ)ノ
 */
class PlayerFragment : BaseFragment(), View.OnClickListener {

    lateinit var binding: FragmentPlayerBinding

    companion object {
        fun newInstance() = PlayerFragment()
    }

    val playerModel = PlayerModel()
    lateinit var mViewModel: PlayerViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_player, container, false)
        activity!!.title = this.javaClass.simpleName.substringBefore("Fragment")
        mViewModel = ViewModelProviders.of(this).get(PlayerViewModel::class.java)
        binding.btPlayer.setOnClickListener(this)
        return binding.root
    }

    override fun onClick(view: View?) {

        if (checkValues()) {
            mViewModel.setplayer(getplayerData())
            mViewModel.savePlayer()
            goToStudie()
        } else {
            Toast.makeText(context, "Debes rellenar todos los campos", LENGTH_LONG).show()
        }
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        val id = item!!.itemId

        return if (id == R.id.action_settings) {
            true
        } else super.onOptionsItemSelected(item)
    }

    fun goToStudie() {

        val intent = Intent(activity, StudyActivity::class.java)
        startActivity(intent)
    }

    fun getplayerData(): PlayerModel {


        playerModel.setplayerName(binding.tietPlayerName.text.toString())
        playerModel.setplayerTeam(binding.tietPlayerTeam.text.toString())
        playerModel.setplayerAge(binding.tietPlayerAge.text.toString())
        playerModel.setplayerPosition(binding.tietPlayerPosition.text.toString())
        playerModel.setplayerDomination(binding.tietPlayerDomination.text.toString())
        playerModel.setplayerNationality(binding.tietPlayerNationality.text.toString())

        return playerModel
    }

    fun checkValues(): Boolean {

        return !(binding.tietPlayerName.text.toString().isEmpty() ||
                binding.tietPlayerTeam.text.toString().isEmpty() ||
                binding.tietPlayerAge.text.toString().isEmpty() ||
                binding.tietPlayerPosition.text.toString().isEmpty() ||
                binding.tietPlayerDomination.text.toString().isEmpty() ||
                binding.tietPlayerNationality.text.toString().isEmpty())
    }

}