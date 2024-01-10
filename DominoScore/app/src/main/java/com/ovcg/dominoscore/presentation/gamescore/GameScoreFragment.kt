package com.ovcg.dominoscore.presentation.gamescore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ovcg.dominoscore.R
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameScoreFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.game_score_fragment, container, false)
    }
}