package de.hsfl.team.campusflag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import de.hsfl.team.campusflag.databinding.FragmentStartBinding

class StartFragment : Fragment() {

    //globale initialisierung

    private var _binding: FragmentStartBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentStartBinding.inflate(inflater, container, false)

        // Host Button
        binding.hostBtnStart.setOnClickListener {
            findNavController().navigate((R.id.action_start_to_create))
        }

        // Join Button
        binding.joinBtnStart.setOnClickListener {
            findNavController().navigate((R.id.action_start_to_join))
        }

        return binding.root
    }
}