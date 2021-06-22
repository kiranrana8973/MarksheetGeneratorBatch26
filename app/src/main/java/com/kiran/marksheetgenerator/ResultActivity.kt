package com.kiran.marksheetgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.kiran.marksheetgenerator.model.Student

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //Receiving array list

        val listStudent = intent.getStringArrayListExtra("listStudent") as ArrayList<Student>
        var totalAndroidMarks = 0
        var totalApiMarks = 0
        for (student in listStudent) {
            totalAndroidMarks += student.android!!.toInt()
            totalApiMarks += student.api!!.toInt()
        }

        Toast.makeText(this, "Android : $totalAndroidMarks", Toast.LENGTH_SHORT).show()



    }
}