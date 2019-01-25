package com.example.sirwollsmoth.aranah_in2000_oblig1


import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.app.AlertDialog
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Toast
import com.getbase.floatingactionbutton.FloatingActionButton
import android.content.DialogInterface
import android.graphics.drawable.Drawable
import android.widget.EditText
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.text.Editable








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


        elementList.add(Element("ARAN", "a fat bitch"))
        elementList.add(Element("BO", "XD boi"))
        elementList.add(Element("SHIT", "spends a lot of time in toilet"))


        viewManager = LinearLayoutManager(this)
        viewAdapter = ListAdapter(elementList)

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

    fun openDialog() {
        val view: View = layoutInflater.inflate(R.layout.dialog, null)
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Add new Element")

        val titleText: EditText = view.findViewById(R.id.element_title)
        val descText : EditText = view.findViewById(R.id.element_desc)


        builder.setPositiveButton("Add New") { dialog, whichButton ->
            newElementDesc=descText.text.toString()
            newElementTitle=titleText.text.toString()
            elementList.add(Element(newElementTitle, newElementDesc))
        }

        builder.setNegativeButton("Cancel") { dialog, which -> Unit }
        builder.setView(view)
        builder.show()
    }
}

