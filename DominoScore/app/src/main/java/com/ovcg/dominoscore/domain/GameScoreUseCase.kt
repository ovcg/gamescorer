package com.ovcg.dominoscore.domain

import com.ovcg.dominoscore.presentation.gamescore.Game
import com.ovcg.dominoscore.data.GameScoreRepository
import kotlinx.coroutines.flow.Flow

class GameScoreUseCase(private val repository: GameScoreRepository) {
    suspend fun getLastGames(): Flow<Result<List<Game>>> {
        return repository.getLastGames()
    }

}
