package com.ovcg.dominoscore.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Player(
    @PrimaryKey(autoGenerate = true) val playerId: Long,
    val name: String
)
