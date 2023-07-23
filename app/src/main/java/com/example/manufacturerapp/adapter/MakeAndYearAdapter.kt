package com.example.manufacturerapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.manufacturerapp.R
import com.example.manufacturerapp.model.Result

class MakeAndYearAdapter(var list: List<Result>)
    : RecyclerView.Adapter<MakeAndYearAdapter.ViewHolder>()
{

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var makeName = itemView.findViewById<TextView>(R.id.makeNameId)
        var modelName = itemView.findViewById<TextView>(R.id.modelNameID)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder(
            LayoutInflater.from(parent.context).inflate(R.layout.recycler_row_year_and_name, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.makeName.setText(list.get(position).Make_Name)
        holder.modelName.setText(list.get(position).Model_Name)
    }


}