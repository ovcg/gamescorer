package com.ovcg.dominoscore.data.repository

import com.ovcg.dominoscore.data.database.GameScoreDatabase
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.single
import javax.inject.Inject

class GameScoreRepositoryImpl @Inject constructor(
    private val db: GameScoreDatabase
) : GameScoreRepository {
    override suspend fun getLastGames(): Flow<Result<List<GameWithPlayers>>> {
        return try {
            val result = db.gameDao().getLastGames()
            flow {
                emit(Result.success(result.single()))
            }.catch {
                emit(Result.failure(RuntimeException("Something went wrong")))
            }
        } catch (e: Exception) {
            flow {
                emit(Result.failure(RuntimeException("Something went wrong")))
            }
        }
    }
}