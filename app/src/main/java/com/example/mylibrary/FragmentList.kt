package com.example.mylibrary


import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Button
import android.widget.ImageButton
import android.widget.ListView
import androidx.core.content.ContextCompat
import androidx.core.content.ContextCompat.startActivity
import kotlinx.android.synthetic.main.fragment_fragment_list.*
import java.util.ArrayList

/**
 * A simple [Fragment] subclass.
 */
class FragmentList : Fragment() {

        private var adapter: Adapter? = null
        override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

            val rootView = inflater.inflate(R.layout.fragment_fragment_list, container, false)

            var array = arrayOf( Book(R.drawable.mes),
                Book(R.drawable.chemin),
                Book(R.drawable.think))



            val liste = rootView.findViewById(R.id.books) as ListView
            moviesList = ArrayList()

            for (i in array!!.indices) {
                val movieNames = array!![i]
                // Binds all strings into an array
                moviesList.add(movieNames)
            }

            adapter = Adapter(activity!!)
            liste.adapter = adapter
            liste.onItemClickListener = object : AdapterView.OnItemClickListener {

                override fun onItemClick(
                    parent: AdapterView<*>, view: View,
                    position: Int, id: Long
                ) {

                    // value of item that is clicked
                    val bundle = Bundle()
                    bundle.putInt("amount", position)

                    val fragment = FragmentDetail()
                    val fragmentManager = activity!!.supportFragmentManager

                    val fragmentTransaction = fragmentManager.beginTransaction()
                    fragmentTransaction.replace(R.id.contaner, fragment)
                    fragment.arguments=bundle
                    fragmentTransaction.addToBackStack(null)
                    fragmentTransaction.commit()


                }
            }

            return rootView
        }
    companion object {
        var moviesList = ArrayList<Book>()
    }

  }

