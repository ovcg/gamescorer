package com.ovcg.dominoscore.data.database.entity

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation

data class GameWithPlayers(
    @Embedded val game: Game,
    @Relation(
        parentColumn = "gameId",
        entityColumn = "playerId",
        associateBy = Junction(GamePlayerCrossRef::class)
    )
    val players: List<Player>,

    @Relation(
        parentColumn = "gameId",
        entityColumn = "playerId",
        associateBy = Junction(GamePlayerWinnerCrossRef::class)
    )
    val winners: List<Player>,
)
