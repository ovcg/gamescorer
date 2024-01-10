package com.ovcg.dominoscore.domain

import com.ovcg.dominoscore.data.database.entity.Game
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.data.repository.GameScoreRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GameScoreUseCase @Inject constructor(
    private val repository: GameScoreRepository
) {
    suspend fun getLastGames(): Flow<Result<List<GameWithPlayers>>> {
        return repository.getLastGames()
    }

}
