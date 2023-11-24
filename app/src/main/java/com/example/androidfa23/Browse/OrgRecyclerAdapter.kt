package com.example.androidfa23.Browse

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.androidfa23.Data.Organization
import com.example.androidfa23.R

class OrgRecyclerAdapter(private var dataset: List<Organization>): RecyclerView.Adapter<OrgRecyclerAdapter.ViewHolder>() {
    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val orgName: TextView
        val card: CardView
        init{
            orgName = view.findViewById(R.id.orgName)
            card = view.findViewById(R.id.card)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.org_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int = dataset.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val org = dataset[position]
        holder.orgName.text = org.name
        holder.card.setOnClickListener{
            val intent = Intent(holder.itemView.context, IndividualPersonActivity::class.java)
            holder.itemView.context.startActivity(intent)
        }
    }
}