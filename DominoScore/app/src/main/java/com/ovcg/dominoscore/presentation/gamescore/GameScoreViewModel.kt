package com.ovcg.dominoscore.presentation.gamescore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData
import com.ovcg.dominoscore.domain.GameScoreUseCase

class GameScoreViewModel(private val useCase: GameScoreUseCase) : ViewModel() {

    val games = liveData {
        emitSource(
            useCase.getLastGames().asLiveData()
        )
    }
}
