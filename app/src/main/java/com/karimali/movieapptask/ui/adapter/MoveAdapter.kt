package com.karimali.movieapptask.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.karimali.movieapptask.data.model.MoveModel
import com.karimali.movieapptask.databinding.MoveItemLayoutBinding

class MoveAdapter(
    private val playerList:ArrayList<MoveModel>,
    private val eventClicks:EventClicks
    ):RecyclerView.Adapter<MoveAdapter.MoveViewHolder>(){

    class MoveViewHolder(val binding:MoveItemLayoutBinding):RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MoveViewHolder {
        return MoveViewHolder(
            MoveItemLayoutBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: MoveViewHolder, position: Int) {
        val moveItem = playerList[position]
        holder.binding.move = moveItem
        holder.itemView.setOnClickListener {
            eventClicks.onItemClick(moveItem)
        }
    }

    override fun getItemCount(): Int = playerList.size

    fun updateList(list: ArrayList<MoveModel>) {
        playerList.clear()
        playerList.addAll(list)
        notifyDataSetChanged()
    }

    interface EventClicks{
        fun onItemClick(model: MoveModel)
    }
}