package com.example.samplequiz2

import android.os.Bundle
import android.view.View
import android.widget.*
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.example.samplequiz2.db.Bus
import com.example.samplequiz2.db.BusViewModel

class AddBusRouteActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_add)
        val viewModel: BusViewModel= ViewModelProvider(this)[BusViewModel::class.java]
        var company=""

        val busNum = findViewById<TextView>(R.id.editTextBusNumber)
        val startTerm = findViewById<EditText>(R.id.editTextStartTerminus)
        val spinner = findViewById<Spinner>(R.id.spinnerBusCompany)
        val addButton =  findViewById<Button>(R.id.buttonAdd)
        val clearButton =  findViewById<Button>(R.id.buttonClear)

        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter.createFromResource(
            this,
            R.array.company_array,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            // Specify the layout to use when the list of choices appears
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            // Apply the adapter to the spinner
            spinner.adapter = adapter
        }

        //Handles spinner on select to show centre and address
        spinner.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                val selectedItem = parent?.getItemAtPosition(position).toString() //store selected item from spinner
                company = selectedItem
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {
                // Handle nothing selected
            }
        }

        //add button
        addButton.setOnClickListener() {
//            if (isInputValid())
            val bus = Bus(num = busNum.text.toString(), route = startTerm.text.toString(), company = company)
            viewModel.addBus(bus)
        }

        //clear button
        clearButton.setOnClickListener() {
            busNum.setText("")
            startTerm.setText("")
            spinner.setSelection(0)
        }
        fun isInputValid(): Boolean {
            return !(busNum.toString().isEmpty() || startTerm.toString().isEmpty() || company.isEmpty() || !(busNum.toString().all{char -> char.isDigit()}) || startTerm.toString().any { char -> char.isDigit() })
        }

    }



}