package com.ovcg.dominoscore.data.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Transaction
import com.ovcg.dominoscore.data.database.entity.Game
import com.ovcg.dominoscore.data.database.entity.GamePlayerCrossRef
import com.ovcg.dominoscore.data.database.entity.GamePlayerWinnerCrossRef
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.data.database.entity.Player

@Dao
interface GameScoreDao {
    @Transaction
    @Query("SELECT * FROM Game ORDER BY Game.createdAt")
    fun getLastGames(): List<GameWithPlayers>

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGame(vararg games: Game)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(vararg player: Player)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameCrossPlayers(vararg gamePlayerCrossRef: GamePlayerCrossRef)

    @Transaction
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertGameCrossWinnersPlayers(vararg gamePlayerCrossRef: GamePlayerWinnerCrossRef)
}
