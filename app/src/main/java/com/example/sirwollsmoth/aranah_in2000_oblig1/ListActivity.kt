package com.example.sirwollsmoth.aranah_in2000_oblig1


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.getbase.floatingactionbutton.FloatingActionButton
import android.widget.EditText



class ListActivity : AppCompatActivity() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var viewAdapter: ListAdapter
    private lateinit var viewManager: RecyclerView.LayoutManager
    private lateinit var newElementTitle: String
    private lateinit var newElementDesc: String
    private val elementList = ArrayList<Element>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)


        elementList.add(Element("Mario", "a fat plumber that eats to much mushrooms and hallucinates", "https://steemitimages.com/DQmfYjF8Azi8Dcn9s5t6QMdukEL45zMoDee5uMCkuNCPSzD/tree-2597733_960_720.jpg" ))
        elementList.add(Element("Sonic", "blue hedgehog on steroids, also known as \'sanic\'", "https://d2pptc4exyus09.cloudfront.net/puzzle/137/421/original.jpg"))
        //elementList.add(Element("Link", "No, Zelda is the princess", "test"))


        viewManager = LinearLayoutManager(this)
        viewAdapter = ListAdapter(elementList, this)

        val floatingActionButton = findViewById<View>(R.id.floating_action_button) as FloatingActionButton


        floatingActionButton.setOnClickListener({ _ -> openDialog()})


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

    private fun openDialog() {
        val view: View = layoutInflater.inflate(R.layout.dialog, null)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add new Element")

        val titleText: EditText = view.findViewById(R.id.element_title)
        val descText : EditText = view.findViewById(R.id.element_desc)
        val urlText: EditText = view.findViewById(R.id.element_pic)


        builder.setPositiveButton("Add New") { _, _ ->
            val newElementDesc=descText.text.toString()
            val newElementTitle=titleText.text.toString()
            val newElementURL = urlText.text.toString()

            if(newElementDesc.isNullOrEmpty() || newElementTitle.isNullOrEmpty() || newElementURL.isNullOrEmpty()){
                Toast.makeText(this, "One or more field is empty", Toast.LENGTH_SHORT).show()
            } else {
                elementList.add(Element(newElementTitle, newElementDesc,newElementURL))
            }
        }

        builder.setNegativeButton("Cancel") { _, _ -> Unit }
        builder.setView(view)
        builder.show()
    }
}

