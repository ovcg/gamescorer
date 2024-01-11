package com.ovcg.dominoscore.data.database.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.UUID

@Entity
class Player(
    @PrimaryKey val playerId: String = UUID.randomUUID().toString(),
    val name: String
)
