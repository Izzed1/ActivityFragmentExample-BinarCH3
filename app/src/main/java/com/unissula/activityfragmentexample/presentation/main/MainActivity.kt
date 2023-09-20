package com.unissula.activityfragmentexample.presentation.main

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import com.unissula.activityfragmentexample.databinding.ActivityMain2Binding
import com.unissula.activityfragmentexample.presentation.fragmentone.FragmentOne
import com.unissula.activityfragmentexample.presentation.fragmentthree.FragmentThree
import com.unissula.activityfragmentexample.presentation.fragmenttwo.FragmentTwo

class MainActivity : AppCompatActivity() {

    private val fragmentOne : FragmentOne by lazy { FragmentOne() }
    private val fragmentTwo : FragmentTwo by lazy { FragmentTwo() }
    private val fragmentThree : FragmentThree by lazy { FragmentThree() }

    private val binding : ActivityMain2Binding by lazy {
        ActivityMain2Binding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)
        setClickButtonNavigate()
        replaceFragment(fragmentOne)
    }

    fun setClickButtonNavigate() {
        binding.btnFragment1.setOnClickListener {
            replaceFragment(fragmentOne)
        }
        binding.btnFragment2.setOnClickListener {
            replaceFragment(fragmentTwo)
        }
        binding.btnFragment3.setOnClickListener {
            replaceFragment(fragmentThree)
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(binding.flContainer.id, fragment) // replace mengganti semua state yang ada di container
            .commit()
    }
}