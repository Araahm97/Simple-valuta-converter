package com.example.sirwollsmoth.aranah_in2000_oblig1

import android.support.v7.widget.CardView
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import kotlinx.android.synthetic.main.element.view.*


class ListAdapter (private val myDataset: ArrayList<Element>) : RecyclerView.Adapter<ListAdapter.ViewHolder>() {

    class ViewHolder(val cardView: CardView) : RecyclerView.ViewHolder(cardView)


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListAdapter.ViewHolder {
        // create a new view
        val cardView = LayoutInflater.from(parent.context).inflate(R.layout.element, parent, false) as CardView
        // set the view's size, margins, paddings and layout parameters

        return ViewHolder(cardView)
    }


    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        holder.cardView.card_view.title.text = myDataset[position].title
        holder.cardView.card_view.desc.text = myDataset[position].desc

    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = myDataset.size


}

