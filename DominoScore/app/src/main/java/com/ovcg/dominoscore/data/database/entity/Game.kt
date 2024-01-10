package com.ovcg.dominoscore.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class Game(
    @PrimaryKey(autoGenerate = true) val gameId: Long,
    val title: String,
    val createdAt: String
)