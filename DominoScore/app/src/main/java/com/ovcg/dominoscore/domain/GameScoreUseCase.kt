package com.ovcg.dominoscore.domain

import com.ovcg.dominoscore.data.database.entity.Game
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.data.repository.GameScoreRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class GameScoreUseCase @Inject constructor(
    private val repository: GameScoreRepository
) {
    suspend fun getLastGames(): Flow<Result<List<GameWithPlayers>>> {
        return repository.getLastGames()
    }

    suspend fun createGame(gameWithPlayers: GameWithPlayers) {
        withContext(Dispatchers.IO) {
            repository.insertGame(gameWithPlayers)
        }
    }

}
