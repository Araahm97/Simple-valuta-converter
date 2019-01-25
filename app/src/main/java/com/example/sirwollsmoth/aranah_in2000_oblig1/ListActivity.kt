package com.example.sirwollsmoth.aranah_in2000_oblig1


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView

class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    lateinit var viewAdapter: ListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager




    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)

        val elementList = ArrayList<Element>()


        elementList.add(Element("ARAN", "a fat bitch"))
        elementList.add(Element("BO", "XD boi"))
        elementList.add(Element("SHIT", "spends a lot of time in toilet"))

        viewManager = LinearLayoutManager(this)
        viewAdapter = ListAdapter(elementList)



        recyclerView = findViewById<RecyclerView>(R.id.my_recycler_view).apply {
            // use this setting to improve performance if you know that changes
            // in content do not change the layout size of the RecyclerView
            setHasFixedSize(true)

            // use a linear layout manager
            layoutManager = viewManager

            // specify an viewAdapter (see also next example)
            adapter = viewAdapter

        }

    }

}

