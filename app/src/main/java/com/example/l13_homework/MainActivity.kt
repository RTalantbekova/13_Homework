package com.example.l13_homework

import android.app.DatePickerDialog
import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.ContextThemeWrapper
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        onClick()
    }

    private fun createDatePicker(){
        val dialog = DatePickerDialog(this)
        dialog.setOnDateSetListener { view, year, month, dayOfmonth ->
            birthday.setText("$dayOfmonth/$month/$year")
        }
        dialog.show()
    }

    private fun saveData(){
        val preferences = getSharedPreferences("Preference", Context.MODE_PRIVATE)
        preferences.edit().putString("surname", surname.text.toString()).apply()
        preferences.edit().putString("firstname", firstname.text.toString()).apply()
    }
    private fun onClick(){
        btnSave.setOnClickListener {
            createDialog()
        }
        birthday.setOnClickListener { createDatePicker() }
    }

    private fun customDialog(){
        CustomDialog(this).show()
    }

    private fun createDialog(){
        val dialog = AlertDialog.Builder(ContextThemeWrapper(this, R.style.Dialog))
        dialog.setTitle("Do you want save?")
        dialog.setPositiveButton("Yes"){dialog, which ->
            customDialog()
            saveData()
        }
        dialog.setNegativeButton("No"){dialog, which ->}
        dialog.setCancelable(false)
        dialog.show()

    }
}