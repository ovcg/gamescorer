package com.ovcg.dominoscore.data.commons

import android.content.Context
import androidx.room.Room
import com.ovcg.dominoscore.data.database.GameScoreDao
import com.ovcg.dominoscore.data.database.GameScoreDatabase
import com.ovcg.dominoscore.data.repository.GameScoreRepository
import com.ovcg.dominoscore.data.repository.GameScoreRepositoryImpl
import com.ovcg.dominoscore.domain.GameScoreUseCase
import com.ovcg.dominoscore.presentation.gamescore.viewmodel.GameScoreViewModelFactory
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module
@InstallIn(FragmentComponent::class)
object GameScoreModule {

    @Provides
    fun provideViewModelFactory(useCase: GameScoreUseCase) = GameScoreViewModelFactory(useCase)

    @Provides
    fun useCase(repository: GameScoreRepository): GameScoreUseCase = GameScoreUseCase(repository)

    @Provides
    fun repository(gameScoreDao: GameScoreDao): GameScoreRepository = GameScoreRepositoryImpl(gameScoreDao)
}