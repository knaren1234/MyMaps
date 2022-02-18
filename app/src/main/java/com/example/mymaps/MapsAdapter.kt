package com.example.mymaps

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

private const val TAG = "MapsAdapter"
class MapsAdapter(val context: Context, val userMaps: List<UserMap>, val onClickListener: OnClickListener) : RecyclerView.Adapter<MapsAdapter.ViewHolder>() {

    interface OnClickListener {
        fun onItemClick(position: Int)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MapsAdapter.ViewHolder {
        val view = LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: MapsAdapter.ViewHolder, position: Int) {
        val userMap = userMaps[position]
        holder.bind(userMap)
        holder.addClicker(position)
    }

    override fun getItemCount() = userMaps.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewTitle = itemView.findViewById<TextView>(android.R.id.text1)

        fun bind(userMap: UserMap) {
            textViewTitle.text = userMap.title
        }

        fun addClicker(position: Int) {
            itemView.setOnClickListener {
                onClickListener.onItemClick(position)
            }
        }
    }
}
