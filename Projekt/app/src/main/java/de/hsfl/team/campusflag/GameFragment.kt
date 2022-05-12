package de.hsfl.team.campusflag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController

class GameFragment : Fragment() {

    private lateinit var rootView: View

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

        rootView = inflater.inflate(R.layout.fragment_game, container, false)

        val navController = findNavController()
        val leaveBtn: Button = rootView.findViewById(R.id.leave_btn_game)

        leaveBtn.setOnClickListener {
            navController.navigate(R.id.action_game_to_start)
        }

        return rootView
    }
}