package com.example.manufacturerapp.adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.constraintlayout.widget.ConstraintLayout
import androidx.recyclerview.widget.RecyclerView
import com.example.manufacturerapp.R
import com.example.manufacturerapp.model.Result

class SearchListAdapter(var list: List<Result>, val listener : OnItemClickListener)
    : RecyclerView.Adapter<SearchListAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var country = itemView.findViewById<TextView>(R.id.countryId)
        var mfrName = itemView.findViewById<TextView>(R.id.mfrNameId)
        var seeDetailsButton = itemView.findViewById<ConstraintLayout>(R.id.constraintRow)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.country.setText(list.get(position).Country)
        holder.mfrName.setText(list.get(position).Mfr_Name)
        holder.seeDetailsButton.setOnClickListener {
            listener.onItemClick(list.get(position))
        }
    }


}

interface OnItemClickListener {
    fun onItemClick(item : Result)
}