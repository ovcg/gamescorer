package com.ovcg.dominoscore.presentation.gamescore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.ovcg.dominoscore.R

/**
 * A simple [Fragment] subclass.
 * Use the [GameHistoryFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class GameHistoryFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_history_fragment, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            GameHistoryFragment()
    }
}