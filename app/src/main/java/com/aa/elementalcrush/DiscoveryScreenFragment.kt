package com.aa.elementalcrush

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.aa.elementalcrush.databinding.FragmentDiscoveryScreenBinding


class DiscoveryScreenFragment : Fragment() {
    //declaring the class properties
    private lateinit var binding: FragmentDiscoveryScreenBinding
    private lateinit var myViewModel: MyViewModel
    private lateinit var discoveryAdapter: DiscoveryAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //return inflater.inflate(R.layout.fragment_discovery_screen, container, false)
        binding = FragmentDiscoveryScreenBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //use of view model provider to to bind myViewModel to View Model, hence to get and set its data
        myViewModel = ViewModelProvider(requireActivity()).get(MyViewModel::class.java)
        var myModel = myViewModel.myLiveModel.value
        //recycler view uses the layout manager which is necessary for it to function
        binding.myRecyclerView.layoutManager=LinearLayoutManager(requireActivity(),LinearLayoutManager.VERTICAL,false)
        if(myModel!=null)
        {
            //associating discovery model with the discovery adapter and then associate discovery adapter with the recycler view
            val discovery = myModel.discovery
            discoveryAdapter = DiscoveryAdapter(discovery)
            binding.myRecyclerView.adapter=discoveryAdapter
        }

    }

}