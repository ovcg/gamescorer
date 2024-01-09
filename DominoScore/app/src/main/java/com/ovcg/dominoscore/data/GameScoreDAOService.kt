package com.ovcg.dominoscore.data

import com.ovcg.dominoscore.presentation.gamescore.Game

interface GameScoreDAOService {
    fun getLastGames(): List<Game>

}
