package com.example.tp_10___composant

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FruitAdapter(
    private val fruitList: List<Fruit>,
    private val onItemClick: (Fruit) -> Unit
) : RecyclerView.Adapter<FruitAdapter.FruitViewHolder>() {

    class FruitViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val tvFruitIcon: TextView = itemView.findViewById(R.id.tvFruitIcon)
        val tvFruitName: TextView = itemView.findViewById(R.id.tvFruitName)
        val tvFruitCategory: TextView = itemView.findViewById(R.id.tvFruitCategory)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FruitViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_fruit, parent, false)
        return FruitViewHolder(view)
    }

    override fun onBindViewHolder(holder: FruitViewHolder, position: Int) {
        val fruit = fruitList[position]
        holder.tvFruitIcon.text = fruit.emoji
        holder.tvFruitName.text = fruit.name
        holder.tvFruitCategory.text = fruit.category

        holder.itemView.setOnClickListener {
            onItemClick(fruit)
        }
    }

    override fun getItemCount(): Int = fruitList.size
}
