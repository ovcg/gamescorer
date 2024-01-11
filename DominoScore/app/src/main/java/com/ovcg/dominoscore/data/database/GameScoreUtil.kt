package com.ovcg.dominoscore.data.database

import com.ovcg.dominoscore.data.database.entity.Game
import com.ovcg.dominoscore.data.database.entity.Player

object GameScoreUtil {
    fun createPlayers(): List<Player> {
        return listOf(
            Player(name = "Player1"),
            Player(name = "Player2"),
            Player(name = "Player3"),
            Player(name = "Player4")
        )
    }

    fun createGame(): Game {
        return Game(title = "Game 1", createdAt = "11/01/2024")
    }
}
