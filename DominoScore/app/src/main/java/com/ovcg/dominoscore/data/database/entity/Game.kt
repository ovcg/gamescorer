package com.ovcg.dominoscore.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
class Game(
    @PrimaryKey val gameId: String = UUID.randomUUID().toString(),
    val title: String,
    val createdAt: String
)