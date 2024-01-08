package com.ovcg.dominoscore.gamescore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData

class GameScoreViewModel(private val useCase: GameScoreUseCase) : ViewModel() {

    val games = liveData {
        emitSource(
            useCase.getLastGames().asLiveData()
        )
    }
}
