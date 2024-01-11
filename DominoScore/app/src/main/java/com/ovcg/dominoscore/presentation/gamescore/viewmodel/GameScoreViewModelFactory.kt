package com.ovcg.dominoscore.presentation.gamescore.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.ovcg.dominoscore.domain.GameScoreUseCase
import javax.inject.Inject

class GameScoreViewModelFactory @Inject constructor(
    private val useCase: GameScoreUseCase
) : ViewModelProvider.Factory {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return GameScoreViewModel(useCase) as T
    }
}
