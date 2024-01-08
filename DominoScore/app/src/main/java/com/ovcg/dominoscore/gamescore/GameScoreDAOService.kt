package com.ovcg.dominoscore.gamescore

interface GameScoreDAOService {
    fun getLastGames(): List<Game>

}
