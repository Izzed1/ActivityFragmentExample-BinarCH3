package com.unissula.activityfragmentexample.presentation.fragmentone

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.unissula.activityfragmentexample.databinding.FragmentOneBinding
import com.unissula.activityfragmentexample.modul.Person
import com.unissula.activityfragmentexample.presentation.fragmenttwo.FragmentTwo

class FragmentOne : Fragment() {

    // karena fragment sifatnya meng-inflating on top of inflater, jadi kita harus menginflate dia ke inflate view.
    // bindingnya kita pakai lateinit var, tidak bisa lazy
    private lateinit var binding: FragmentOneBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // variabel binding initiate disini:
        binding = FragmentOneBinding.inflate(inflater,container,false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        setClickListener()
    }

    private fun setClickListener() {
        binding.btnNavigate.setOnClickListener {
            navigateToFragmentTwo()
        }
        binding.btnSendDataNavigate.setOnClickListener {
            navigateToFragmentTwo(getPerson())
        }
    }

    private fun getPerson(): Person? {
        return Person(
            name = "Tony Stark",
            job = "The Mechanic",
            profileDesc = "Genius, Billionaire, Playboy, Philantrophist",
            profilePicUrl = "https://static.wikia.nocookie.net/marvelcentral/images/9/97/Tony-Stark.jpg/revision/latest?cb=20130429010603"
        )
    }

    private fun navigateToFragmentTwo(person: Person? = null) {
        // CARA PAKAI BUNDLE
//        findNavController().navigate(R.id.action_fragmentOne_to_fragmentTwo,Bundle().apply {
//            putParcelable(FragmentTwo.ARGS_PERSON,person)
//        })

        // CARA PAKAI SAFEARGS
        // lebih baik menggunakan cara ini karena tidak perlu membuat key dari masing-masing value
        val action = FragmentOneDirections.actionFragmentOneToFragmentTwo(person) // actionFragmentOneToFragmentTwo = adalah id action yang ada di file navigation
        findNavController().navigate(action) // findNavController() adalah mencari class yang bakal menghandle navigation dari page A ke page B
    }
}