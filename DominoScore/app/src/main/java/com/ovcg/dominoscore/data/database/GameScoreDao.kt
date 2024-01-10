package com.ovcg.dominoscore.data.database

import androidx.room.Dao
import androidx.room.Query
import androidx.room.Transaction
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import kotlinx.coroutines.flow.Flow

@Dao
interface GameScoreDao {
    @Transaction
    @Query("SELECT * FROM Game ORDER BY Game.createdAt")
    fun getLastGames(): Flow<List<GameWithPlayers>>
}
