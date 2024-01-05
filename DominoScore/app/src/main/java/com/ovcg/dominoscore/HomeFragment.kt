package com.ovcg.dominoscore

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import com.ovcg.dominoscore.databinding.HomeFragmentBinding

class HomeFragment : Fragment() {

    private var _binding: HomeFragmentBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = HomeFragmentBinding.inflate(inflater, container, false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.buttonHomeStartScore.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_ChooseFragment)
        }

        binding.buttonHomeGameHistory.setOnClickListener {
            findNavController().navigate(R.id.action_HomeFragment_to_GameHistoryFragment)
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}