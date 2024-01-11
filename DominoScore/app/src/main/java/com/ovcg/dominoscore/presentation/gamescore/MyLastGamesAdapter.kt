package com.ovcg.dominoscore.presentation.gamescore

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ovcg.dominoscore.data.database.entity.GameWithPlayers
import com.ovcg.dominoscore.databinding.GameItemBinding

class MyLastGamesAdapter(
    private val games: List<GameWithPlayers>
) : RecyclerView.Adapter<MyLastGamesAdapter.GameViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): GameViewHolder {
        return GameViewHolder(
            GameItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = games.size

    override fun onBindViewHolder(holder: GameViewHolder, position: Int) {
        val game = games[position]
        holder.gameName.text = game.game.title
    }


    inner class GameViewHolder(binding: GameItemBinding) : RecyclerView.ViewHolder(binding.root) {
        val gameName: TextView = binding.tvGameName
    }
}