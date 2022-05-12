package de.hsfl.team.campusflag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.hsfl.team.campusflag.databinding.FragmentCreateBinding

class CreateFragment : Fragment() {

    val mainViewModel: ViewModel by activityViewModels()

    private var _binding: FragmentCreateBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentCreateBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = mainViewModel

        binding.creategameBtnCreate.setOnClickListener {
            mainViewModel.createGame()
            findNavController().navigate(R.id.action_create_lobbyy)
        }

        binding.setflagpositionBtnCreate.setOnClickListener {
            findNavController().navigate(R.id.action_create_to_start)
        }

        binding.setflagpositionBtnCreate.setOnClickListener {
            Toast.makeText(
                binding.root.context,
                "Setting the Flag at position.. ",
                Toast.LENGTH_SHORT
            ).show()
        }

        return binding.root
    }
}