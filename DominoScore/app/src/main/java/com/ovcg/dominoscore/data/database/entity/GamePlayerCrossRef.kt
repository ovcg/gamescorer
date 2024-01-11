package com.ovcg.dominoscore.data.database.entity

import androidx.room.Entity

@Entity(primaryKeys = ["gameId", "playerId"])
class GamePlayerCrossRef (
    val gameId: String,
    val playerId: String
)

@Entity(primaryKeys = ["gameId", "playerId"])
class GamePlayerWinnerCrossRef (
    val gameId: String,
    val playerId: String
)
