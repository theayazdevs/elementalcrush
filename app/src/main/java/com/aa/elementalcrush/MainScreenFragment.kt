package com.aa.elementalcrush

import android.media.MediaPlayer
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.NavController
import androidx.navigation.fragment.findNavController
import com.aa.elementalcrush.databinding.FragmentMainScreenBinding


class MainScreenFragment : Fragment() {
    //declaring class properties
    private lateinit var binding : FragmentMainScreenBinding
    private lateinit var navController: NavController
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        navController = findNavController()
        //if help button is pressed, takes the user to the help page
        binding.helpBtn.setOnClickListener {
            navController.navigate(R.id.action_mainScreenFragment_to_helpScreenFragment)
        }
        //if discover button is pressed, takes the user to the discovery page
        binding.discoverBtn.setOnClickListener {
            navController.navigate(R.id.action_mainScreenFragment_to_discoveryScreenFragment)
        }
        //if the play button is pressed, takes the user to the play screen
        binding.playBtn.setOnClickListener {
            navController.navigate(R.id.action_mainScreenFragment_to_playScreenFragment)
        }
        //looping background music at the main screen
        val mainScreenAudio: MediaPlayer = MediaPlayer.create(requireActivity(), R.raw.island_music_x)
        mainScreenAudio.isLooping = true
        mainScreenAudio.start()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_main_screen, container, false)
        binding = FragmentMainScreenBinding.inflate(inflater, container, false)
        return binding.root
    }
}