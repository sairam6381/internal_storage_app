package com.example.day_3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import java.io.BufferedReader
import java.io.File
import java.io.FileInputStream
import java.io.FileOutputStream
import java.io.InputStreamReader

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val etName : EditText = findViewById(R.id.etName)
        val etCGPA : EditText = findViewById(R.id.etCGPA)
        val btSave : Button = findViewById(R.id.btSave)
        val btLoad : Button = findViewById(R.id.btLoad)
        btSave.setOnClickListener{
            val name = etName.text.toString()
            val cgpa = etCGPA.text.toString()
            val file = File(getExternalFilesDir(null),"student.txt")
            val fos = FileOutputStream(file,false)
            fos.write("$name,$cgpa".toByteArray())
            fos.close()
            etName.setText("")
            etCGPA.setText("")
            Toast.makeText(this@MainActivity,"Info added",Toast.LENGTH_LONG).show()

        }
        btLoad.setOnClickListener{
            val file = File(getExternalFilesDir(null),"student.txt")
            val fis = FileInputStream(file)
            val isr = InputStreamReader(fis)
            val br =BufferedReader(isr)
            var line : String
            line = br.readLine()
            var parts=line.split(",")
            etName.setText(parts[0])
            etCGPA.setText((parts[1]))
            Toast.makeText(this@MainActivity,"Info loaded",Toast.LENGTH_LONG).show()

        }




    }
}