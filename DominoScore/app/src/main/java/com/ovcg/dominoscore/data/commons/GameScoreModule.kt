package com.ovcg.dominoscore.data.commons

import com.ovcg.dominoscore.data.database.GameScoreDatabase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module
@InstallIn(FragmentComponent::class)
object GameScoreModule {

    @Provides
    fun gameScoreDatabase() = GameScoreDatabase.getDatabase(GameScoreApplication().applicationContext)
}