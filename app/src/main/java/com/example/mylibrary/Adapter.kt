package com.example.mylibrary

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment

import java.util.ArrayList
import java.util.Locale

class Adapter(
    // Declare Variables

    internal var mContext: Context
) : BaseAdapter() {
    internal var inflater: LayoutInflater
    private val arraylist: ArrayList<Book>

    init {
        inflater = LayoutInflater.from(mContext)
        this.arraylist = ArrayList()
        this.arraylist.addAll(FragmentList.moviesList)
    }

    inner class ViewHolder {

        internal var image: ImageView? = null
    }

    override fun getCount(): Int {
        return FragmentList.moviesList.size
    }

    override fun getItem(position: Int):Book {
        return FragmentList.moviesList[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getView(position: Int, view: View?, parent: ViewGroup): View {
        var view = view
        val holder: ViewHolder
        if (view == null) {
            holder = ViewHolder()
            view = inflater.inflate(R.layout.book, null)
            holder.image = view!!.findViewById(R.id.image) as ImageView
            view.tag = holder
        } else {
            holder = view.tag as ViewHolder
        }
        // Set the results into TextViews
        holder.image!!.setImageResource(FragmentList.moviesList[position].getImage())

        return view
    }



}
