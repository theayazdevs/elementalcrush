package com.aa.elementalcrush

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.aa.elementalcrush.databinding.FragmentHelpScreenBinding


class HelpScreenFragment : Fragment() {
    //declaring class properties
    private lateinit var binding : FragmentHelpScreenBinding
    private lateinit var navController: NavController

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_help_screen, container, false)
        binding = FragmentHelpScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        //when lets play button is pressed takes the user to the play screen
        binding.helpPlayBtn.setOnClickListener {
            navController.navigate(R.id.action_helpScreenFragment_to_playScreenFragment)
        }
    }

}