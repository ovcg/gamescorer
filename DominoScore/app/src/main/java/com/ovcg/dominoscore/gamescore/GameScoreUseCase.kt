package com.ovcg.dominoscore.gamescore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameScoreUseCase(private val repository: GameScoreRepository) {
    suspend fun getLastGames(): Flow<Result<List<Game>>> {
        return repository.getLastGames()
    }

}
