package com.ovcg.dominoscore.gamescore

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow

class GameScoreRepository(
    private val daoService: GameScoreDAOService
) {
    suspend fun getLastGames(): Flow<Result<List<Game>>> {
        return flow {
            emit(Result.success(daoService.getLastGames()))
        }
    }
}
