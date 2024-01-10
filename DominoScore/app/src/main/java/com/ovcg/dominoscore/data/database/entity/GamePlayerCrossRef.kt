package com.ovcg.dominoscore.data.database.entity

import androidx.room.Entity

@Entity(primaryKeys = ["gameId", "playerId"])
class GamePlayerCrossRef (
    val gameId: Long,
    val playerId: Long
)
