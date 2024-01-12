package com.ovcg.dominoscore.presentation.gamescore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.ovcg.dominoscore.R
import com.ovcg.dominoscore.databinding.GameScoreFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class GameScoreFragment : Fragment() {

    private var _binding: GameScoreFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = GameScoreFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }
}