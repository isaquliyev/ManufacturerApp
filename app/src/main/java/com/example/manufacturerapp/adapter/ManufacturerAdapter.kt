package com.example.manufacturerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.manufacturerapp.R
import com.example.manufacturerapp.model.Result

class ManufacturerAdapter(var list: List<Result>)
    : RecyclerView.Adapter<ManufacturerAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var country = itemView.findViewById<TextView>(R.id.countryId)
        var mfrName = itemView.findViewById<TextView>(R.id.mfrNameId)
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
    }


}
