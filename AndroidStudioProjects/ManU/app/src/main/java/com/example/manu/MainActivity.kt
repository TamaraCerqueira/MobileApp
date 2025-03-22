package com.example.manu

import android.graphics.drawable.Drawable
import android.os.Bundle
import android.widget.*
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val sizeSpinner: Spinner = findViewById(R.id.sizeSpinner)
        val typeRadioGroup: RadioGroup = findViewById(R.id.typeRadioGroup)
        val quantitySeekBar: SeekBar = findViewById(R.id.quantitySeekBar)
        val quantityValue: TextView = findViewById(R.id.quantityValue)
        val purchaseButton: Button = findViewById(R.id.purchaseButton)


        val sizes = arrayOf("Small", "Medium", "Large", "Extra Large")
        val adapter = ArrayAdapter(this, android.R.layout.simple_spinner_item, sizes)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        sizeSpinner.adapter = adapter

        

        quantitySeekBar.setOnSeekBarChangeListener(object : SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                quantityValue.text = progress.toString()
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {}

            override fun onStopTrackingTouch(seekBar: SeekBar?) {}
        })


        purchaseButton.setOnClickListener {
            val size = sizeSpinner.selectedItem as String
            val type = when (typeRadioGroup.checkedRadioButtonId) {
                R.id.homeRadioButton -> "Home"
                else -> "Away"
            }
            val quantity = quantitySeekBar.progress


            val message = "Thank you for your purchase!\nSize: $size\nType: $type\nQuantity: $quantity"
            Toast.makeText(this, message, Toast.LENGTH_LONG).show()
        }
    }
}