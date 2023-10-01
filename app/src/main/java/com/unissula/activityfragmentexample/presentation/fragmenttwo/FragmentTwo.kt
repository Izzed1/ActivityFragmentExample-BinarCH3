package com.unissula.activityfragmentexample.presentation.fragmenttwo

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible
import androidx.navigation.fragment.findNavController
import coil.load
import com.unissula.activityfragmentexample.R
import com.unissula.activityfragmentexample.databinding.FragmentTwoBinding
import com.unissula.activityfragmentexample.modul.Person

class FragmentTwo : Fragment() {

    private lateinit var binding: FragmentTwoBinding

    /*
    jika paki bundle, harus menambahkan constanta companion object di fragment penerima (tujuan)
    companion object {
        const val ARGS_PERSON = "ARGS_PERSON" // variable ARGS_PERSON nanti akan menjadi key di getParcelable
    }
    */

    private val person: Person? by lazy {
        // BUNDLE ARGUMENTS
        // arguments?.getParcelable(ARGS_PERSON)

        // SAFEARGS
         FragmentTwoArgs.fromBundle(arguments as Bundle).person
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTwoBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
        showProfileData()
    }

    private fun showProfileData() {
        if (person != null) {
            binding.llProfile.isVisible = true
            binding.ivProfileImg.load(person?.profilePicUrl) // load merupakan dari library coil, untuk ambil gambar dr internet
            binding.tvProfileDesc.text = person?.profileDesc
            binding.tvName.text = person?.name
            binding.tvJob.text = person?.job
        } else {
            binding.llProfile.isVisible = false

            Toast.makeText(requireContext(), "Profile is Null", Toast.LENGTH_SHORT).show()
            // requireContext() itu sama dengan content, bedanya dia dpt menangani null
            // kita pakai Context karena berada di fragment yg reference thd activity
        }
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentThree()
        }
    }

    private fun navigateToFragmentThree() {
        findNavController().navigate(R.id.action_fragmentTwo_to_fragmentThree)
    }
}