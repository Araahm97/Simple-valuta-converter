package com.example.sirwollsmoth.aranah_in2000_oblig1

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.inputmethod.EditorInfo
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class Converter : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_converter)

        var flagForValue= "toInches"
        val cmTitle= "CM TO INCHES"
        val inchesTitle= "INCHES TO CM"


        //Get moduels by ID
        val editText: EditText = findViewById(R.id.editText)
        val textViewTitle: TextView = findViewById(R.id.title)
        val textView: TextView = findViewById(R.id.textView)
        val convertButton: Button = findViewById(R.id.convert_button)
        val nextButton: Button = findViewById(R.id.next_button)
        val prevButton: Button = findViewById(R.id.prev_button)
        val swapButton: Button = findViewById(R.id.swap_button)
        textViewTitle.text = cmTitle


        swapButton.setOnClickListener {
            //Hide the keyboard
            editText.onEditorAction(EditorInfo.IME_ACTION_DONE)
            editText.text.clear()
            textView.text= ""

            if(flagForValue.equals("toInches")){
                flagForValue = "toCm"
                editText.hint = "Value In Inches"
                textViewTitle.text =  cmTitle

            } else {
                flagForValue = "toInches"
                editText.hint = "Value In cm"
                textViewTitle.text = inchesTitle

            }
        }

        //Add functionality to the converter button
        convertButton.setOnClickListener {

            //Hide the keyboard
            editText.onEditorAction(EditorInfo.IME_ACTION_DONE)

            //Get value from editText
            val input = editText.text.toString()

            //Check if input is not empty
            if(input != "") {

                //Convert to int
                val inputInt = input.toInt()

                //Check if input is correct
                if (inputInt > 999999 || inputInt < 0) {

                    //Display toast
                    Toast.makeText(this, "Write a value between 0 - 999 999", Toast.LENGTH_SHORT).show()

                } else {

                    //Add "CM" behind the number in editText
                    /*val feedbackText: String = input + " CM"
                    editText.setText(feedbackText)*/

                    var output: String = ""
                    //Do the math and give output
                    if(flagForValue.equals("toInches")) {
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


        //Add functionality to the next button
        nextButton.setOnClickListener {
            val changePage = Intent(this, ListActivity::class.java)
            startActivity(changePage)
        }

        //Add functionality to the prev button
        prevButton.setOnClickListener {
            val changePage = Intent(this, PictureActivity::class.java)
            startActivity(changePage)
        }
    }
}
