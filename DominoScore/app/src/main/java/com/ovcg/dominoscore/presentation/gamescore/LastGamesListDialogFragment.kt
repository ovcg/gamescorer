package com.ovcg.dominoscore.presentation.gamescore

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.ovcg.dominoscore.data.database.GameScoreUtil
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.databinding.LastGamesListDialogFragmentBinding
import com.ovcg.dominoscore.presentation.gamescore.viewmodel.GameScoreViewModel
import com.ovcg.dominoscore.presentation.gamescore.viewmodel.GameScoreViewModelFactory
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class LastGamesListDialogFragment : DialogFragment() {

    private var _binding: LastGamesListDialogFragmentBinding? = null
    private val binding get() = _binding!!
    private lateinit var myLastGamesAdapter: MyLastGamesAdapter
    private lateinit var viewModel: GameScoreViewModel

    @Inject
    lateinit var viewModelFactory: GameScoreViewModelFactory

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = LastGamesListDialogFragmentBinding.inflate(inflater, container, false)
        setupViewModel()
        setupObserver()
        val gameWithPlayers = GameWithPlayers(GameScoreUtil.createGame(), GameScoreUtil.createPlayers(), listOf())
        viewModel.createGame(gameWithPlayers)
        return binding.root
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setStyle(STYLE_NO_FRAME, android.R.style.Theme_Translucent_NoTitleBar_Fullscreen)
    }

    private fun setupObserver() {
        viewModel.games.observe(viewLifecycleOwner) {
            if (it.getOrNull() != null) {
                setupGames(it.getOrNull()!!)
            }
        }
    }

    private fun setupGames(games: List<GameWithPlayers>) {
        myLastGamesAdapter = MyLastGamesAdapter(games)
        binding.rvLastGames.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = myLastGamesAdapter
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun setupViewModel() {
        viewModel = ViewModelProvider(this, viewModelFactory)[GameScoreViewModel::class.java]
    }

}