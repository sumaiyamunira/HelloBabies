package com.sumaiyamunira.hellobabies.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import com.sumaiyamunira.hellobabies.AlphabetDTO
import com.sumaiyamunira.hellobabies.R

class AlphabetListAdapter(private val context: Context, private val items: List<AlphabetDTO>) : BaseAdapter() {

    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view = convertView ?: LayoutInflater.from(context).inflate(R.layout.alphabet_grid_item, parent, false)
        val item = items[position]

     //   val cardview = view.findViewById<TextView>(R.id.alphabet_card)

        val imageButton = view.findViewById<ImageView>(R.id.imageButton)
        imageButton.setImageResource(item.imageResource)

        return view
    }

    override fun getItem(position: Int): Any {
        return items[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getCount(): Int {
        return items.size
    }
}
