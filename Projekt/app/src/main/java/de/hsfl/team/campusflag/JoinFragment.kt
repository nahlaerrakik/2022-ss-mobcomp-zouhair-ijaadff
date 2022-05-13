package de.hsfl.team.campusflag

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.navigation.fragment.findNavController
import de.hsfl.team.campusflag.databinding.FragmentJoinBinding


class JoinFragment : Fragment() {

    private val mainViewModel: ViewModel by activityViewModels()

    private var _binding: FragmentJoinBinding? = null
    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        _binding = FragmentJoinBinding.inflate(inflater, container, false)

        binding.lifecycleOwner = viewLifecycleOwner
        binding.viewModel = mainViewModel

        binding.joinGameBtnJoin.setOnClickListener {
            mainViewModel.joinGame { isError ->
                if (!isError){
                    findNavController().navigate(R.id.action_join_to_lobbyy)
                }
            }
        }

        binding.cancelBtnJoin.setOnClickListener {
            findNavController().navigate(R.id.action_join_to_start)
        }

        return binding.root
    }
}