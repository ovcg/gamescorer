package com.ovcg.dominoscore.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.ovcg.dominoscore.data.database.entity.Game
import com.ovcg.dominoscore.data.database.entity.GamePlayerCrossRef
import com.ovcg.dominoscore.data.database.entity.GamePlayerWinnerCrossRef
import com.ovcg.dominoscore.data.database.entity.Player

@Database(
    entities = [Game::class, Player::class, GamePlayerCrossRef::class, GamePlayerWinnerCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class GameScoreDatabase : RoomDatabase() {

    abstract fun gameDao(): GameScoreDao
}