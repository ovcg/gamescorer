package com.ovcg.dominoscore.data.repository

import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import kotlinx.coroutines.flow.Flow

interface GameScoreRepository {
    suspend fun getLastGames(): Flow<Result<List<GameWithPlayers>>>
}