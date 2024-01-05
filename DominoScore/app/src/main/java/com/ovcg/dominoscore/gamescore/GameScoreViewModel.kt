package com.ovcg.dominoscore.gamescore

import androidx.lifecycle.ViewModel
import androidx.lifecycle.asLiveData
import androidx.lifecycle.liveData

class GameScoreViewModel(private val useCase: GameScoreUseCase) : ViewModel() {

    val players = liveData {
        emitSource(
            useCase.getLastPlayers().asLiveData()
        )
    }
}
