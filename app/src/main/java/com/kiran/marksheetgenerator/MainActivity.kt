package com.kiran.marksheetgenerator

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.kiran.marksheetgenerator.model.Student
import java.util.ArrayList

class MainActivity : AppCompatActivity() {

    private lateinit var etStudentID: EditText
    private lateinit var etFname: EditText
    private lateinit var etAndroid: EditText
    private lateinit var etIOT: EditText
    private lateinit var etAPI: EditText
    private lateinit var btnAddStudent: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        etStudentID = findViewById(R.id.etStudentID)
        etFname = findViewById(R.id.etFname)
        etAndroid = findViewById(R.id.etAndroid)
        etIOT = findViewById(R.id.etIot)
        etAPI = findViewById(R.id.etApi)
        btnAddStudent = findViewById(R.id.btnAddStudent)


        btnAddStudent.setOnClickListener {
            addStudent()
        }
    }


    val listStudent = ArrayList<Student>()
    var counter = 0
    private fun addStudent() {
        if (counter < 3) {
            val student = Student(
                etStudentID.text.toString().toInt(),
                etFname.text.toString(),
                etAndroid.text.toString().toInt(),
                etAPI.text.toString().toInt(),
                etIOT.text.toString().toInt(),
            )
            listStudent.add(student)
            counter++
        } else {

//            parcelable
            // open another activity and send student list
//            Toast.makeText(this, "List is full", Toast.LENGTH_SHORT).show()
            val intent = Intent(this, ResultActivity::class.java)
            intent.putParcelableArrayListExtra("listStudent",listStudent)
            startActivity(intent)
        }
    }
}