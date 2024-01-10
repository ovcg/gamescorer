package com.ovcg.dominoscore.data.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.ovcg.dominoscore.data.database.entity.Game
import com.ovcg.dominoscore.data.database.entity.GamePlayerCrossRef
import com.ovcg.dominoscore.data.database.entity.Player

@Database(
    entities = [Game::class, Player::class, GamePlayerCrossRef::class],
    version = 1,
    exportSchema = false
)
abstract class GameScoreDatabase : RoomDatabase() {

    abstract fun gameDao(): GameScoreDao

    companion object {
        // Singleton prevents multiple instances of database opening at the
        // same time.
        @Volatile
        private var INSTANCE: GameScoreDatabase? = null

        fun getDatabase(context: Context): GameScoreDatabase {
            // if the INSTANCE is not null, then return it,
            // if it is, then create the database
            return INSTANCE ?: synchronized(this) {
                val instance = Room.databaseBuilder(
                    context.applicationContext,
                    GameScoreDatabase::class.java,
                    "game_database"
                ).build()
                INSTANCE = instance
                // return instance
                instance
            }
        }
    }

}