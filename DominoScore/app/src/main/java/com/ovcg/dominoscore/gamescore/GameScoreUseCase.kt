package com.ovcg.dominoscore.gamescore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameScoreUseCase {
    suspend fun getLastPlayers(): Flow<Result<List<Player>>> {
        return flow {
            emit(Result.success(listOf()))
        }
    }

}
