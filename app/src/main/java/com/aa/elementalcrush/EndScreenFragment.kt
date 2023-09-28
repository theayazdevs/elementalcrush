package com.aa.elementalcrush

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.aa.elementalcrush.databinding.FragmentEndScreenBinding

class EndScreenFragment : Fragment() {
    //declaring class properties
    private lateinit var binding : FragmentEndScreenBinding
    private lateinit var navController: NavController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        //starts the background music at the end screen and keeps repeating it
        val endAudio: MediaPlayer = MediaPlayer.create(requireActivity(), R.raw.end)
        endAudio.isLooping = true
        //start the media specified
        endAudio.start()
        //if homw button is pressed, takes the user to the home screen
        binding.endBtn.setOnClickListener {
            navController.navigate(R.id.action_endScreenFragment_to_mainScreenFragment)
            endAudio.stop()
        }
        //if discover more button is pressed then takes the user to the discover page
        binding.endBtnTwo.setOnClickListener {
            navController.navigate(R.id.action_endScreenFragment_to_discoveryScreenFragment)
            endAudio.stop()
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_end_screen, container, false)
        binding = FragmentEndScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

}