package com.example.tipcalculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.RadioButton
import com.example.tipcalculator.databinding.ActivityMainBinding
import java.text.NumberFormat
import kotlin.math.roundToLong

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.button.setOnClickListener {
            calculateTip()
        }






    }

    private fun calculateTip() {

        val costOfServiceText = binding.EditTextt.text.toString()
        if(costOfServiceText==""){
            return
        }
        val realCostOfService = costOfServiceText.toDouble()

        val idOfOption = binding.Options.checkedRadioButtonId

        val percentace = when(idOfOption){
            binding.button1.id-> 0.2
            binding.button2.id-> 0.1
            else -> 0.05


        }

        var tip = realCostOfService * percentace
        val roundTip = binding.checkswitch.isChecked

        if(roundTip){
            tip = kotlin.math.ceil(tip)
        }

        NumberFormat.getCurrencyInstance()
        val formattedTip = NumberFormat.getCurrencyInstance().format(tip)
        binding.tipText.text = formattedTip
    }


}