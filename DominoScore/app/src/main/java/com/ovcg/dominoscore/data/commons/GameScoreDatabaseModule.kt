package com.ovcg.dominoscore.data.commons

import android.content.Context
import androidx.room.Room
import com.ovcg.dominoscore.data.database.GameScoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@InstallIn(SingletonComponent::class)
@Module
class GameScoreDatabaseModule {

    @Provides
    fun provideGameDao(db: GameScoreDatabase) = db.gameDao()

    @Provides
    @Singleton
    fun provideAppDatabase(@ApplicationContext appContext: Context): GameScoreDatabase {
        return Room.databaseBuilder(
            appContext,
            GameScoreDatabase::class.java,
            "games_table"
        ).build()
    }
}