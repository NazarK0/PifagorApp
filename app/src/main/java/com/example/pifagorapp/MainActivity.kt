package com.example.pifagorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.pifagorapp.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            binding.apply {
                val a = edtA.text.toString().toDouble()
                val b = edtB.text.toString().toDouble()

                val c = calcC(a, b)

                tvResult.text = getString(R.string.result_info, c)
            }


        }
    }

    private fun isFieldEmpty(): Boolean {
        binding.apply {
            val isANullOrEmpty = edtA.text.isNullOrEmpty()
            val isBNullOrEmpty = edtB.text.isNullOrEmpty()

            if (isANullOrEmpty) edtA.error = getString(R.string.input_empty_error)
            if (isBNullOrEmpty) edtB.error = getString(R.string.input_empty_error)

            return isANullOrEmpty || isBNullOrEmpty
        }

    }

    private fun calcC(a: Double, b: Double): Double {
        return sqrt(a.pow(2) + b.pow(2))
    }
}