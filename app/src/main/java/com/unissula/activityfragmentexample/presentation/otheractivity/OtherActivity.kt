package com.unissula.activityfragmentexample.presentation.otheractivity

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.unissula.activityfragmentexample.databinding.ActivityOtherBinding
import com.unissula.activityfragmentexample.modul.Person

class OtherActivity : AppCompatActivity() {

    private val binding: ActivityOtherBinding by lazy {
        ActivityOtherBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        getIntentData()
    }

    private fun getIntentData() {
        val name = intent?.getStringExtra(ARGS_NAME).orEmpty()
        val age = intent?.getIntExtra(ARGS_AGE, 0) ?: 0
        val person = intent?.getParcelableExtra<Person>(ARGS_PERSON) // Ketika data yang dikirim parcelable:

        Toast.makeText(this, "$name : $age", Toast.LENGTH_SHORT).show()
    }

    // buat constanta di activity tujuan, yang nantinya digunakan sebagai "argument" ketika kirim data
    companion object {
        const val ARGS_NAME = "ARGS_NAME"
        const val ARGS_AGE = "ARGS_AGE"
        const val ARGS_PERSON = "ARGS_PERSON" // Ketika data yang dikirim parcelable:

        // tujuan membuat method startActivity disini adalah agar data yang dikirim tidak miss
        fun starActivity(context: Context, name: String, age: Int, person: Person?= null) {
            val intent = Intent(context, OtherActivity::class.java) // ::class:java artinya kita benar-benar direct ke class java nya.
            intent.putExtra(ARGS_NAME, name)
            intent.putExtra(ARGS_AGE, age)
            intent.putExtra(ARGS_PERSON, person) // Ketika data yang dikirim parcelable:
            context.startActivity(intent)
        }

        /*
        //ketika hanya butuh intent nya: (belum tahu maksudnya):
        fun newInstence(context: Context, name: String, age: Int, person: Person?= null) : Intent {
            val intent = Intent(context, OtherActivity::class.java) // ::class:java artinya kita benar-benar direct ke class java nya.
            intent.putExtra(ARGS_NAME, name)
            intent.putExtra(ARGS_AGE, age)
            intent.putExtra(ARGS_PERSON, person) // Ketika data yang dikirim parcelable:
            return intent
        }*/
    }
}