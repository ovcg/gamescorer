package com.ovcg.dominoscore.presentation.gamescore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.domain.GameScoreUseCase
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class GameScoreViewModel(
    private val useCase: GameScoreUseCase
) : ViewModel() {

    fun createGame(gameWithPlayers: GameWithPlayers) {
        GlobalScope.launch {
            useCase.createGame(gameWithPlayers)
        }
    }

    val games = liveData {
        emitSource(
            useCase.getLastGames().asLiveData()
        )
    }
}
