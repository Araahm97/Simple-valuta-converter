package com.example.sirwollsmoth.aranah_in2000_oblig1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Converter : AppCompatActivity() {


    var cmToInches = true
    val cmTitle = "CM TO INCHES"


    //Get moduels by ID
    private lateinit var editText: EditText
    private lateinit var textViewTitle: TextView
    private lateinit var textView: TextView
    private lateinit var convertButton: Button
    private lateinit var nextButton: Button
    private lateinit var prevButton: Button
    private lateinit var swapButton: Button
    private lateinit var output: String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        //Get moduels by ID
        editText = findViewById(R.id.editText)
        textViewTitle = findViewById(R.id.title)
        textView = findViewById(R.id.textView)
        convertButton = findViewById(R.id.convert_button)
        nextButton = findViewById(R.id.next_button)
        prevButton = findViewById(R.id.prev_button)
        swapButton = findViewById(R.id.swap_button)

        textViewTitle.text =  cmTitle

    }

    fun swapCurrency(v: View) {
        //Hide the keyboard
       editText.onEditorAction(EditorInfo.IME_ACTION_DONE)
        editText.text.clear()
        textView.text= ""

        if(cmToInches){
            editText.hint = "Value In Inches"
            textViewTitle.text =  "INCHES TO CM"

        } else {
            editText.hint = "Value In cm"
            textViewTitle.text = cmTitle

        }

        cmToInches = !cmToInches
    }

    fun convert(v: View) {
        //Hide the keyboard
        editText.onEditorAction(EditorInfo.IME_ACTION_DONE)
        val input = editText.text.toString()
        if(!input.isBlank()) {

            val inputInt  = input.toInt()

            if (inputInt > 999999) {
                Toast.makeText(this, "Write a value between 0 - 999 999", Toast.LENGTH_SHORT).show()
            } else {

                if(textViewTitle.text.toString() == cmTitle) {
                    val valueInInch: Double = Math.round((inputInt * 0.39370079) * 100.0) / 100.0
                    output = valueInInch.toString() + " INCHES"

                } else {
                    val valueInCm: Double = Math.round((inputInt * 2.54) * 100.0) / 100.0
                    output= valueInCm.toString() + " CM"
                }

                textView.text = output
            }

        } else {
            Toast.makeText(this, "Write a value", Toast.LENGTH_SHORT).show()
        }
    }

    fun nextAct(v: View) {
        val list = Intent(this, ListActivity::class.java)
        startActivity(list)
    }

    fun prevAct(v: View) {
        val changePage = Intent(this, PictureActivity::class.java)
        startActivity(changePage)
    }
}
