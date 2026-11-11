package com.example.tp_10___composant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.Fragment

class Exercice2Fragment : Fragment(), FragmentA.OnFragmentASendListener {

    private lateinit var fragmentA: FragmentA
    private lateinit var fragmentB: FragmentB

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercice2, container, false)

        if (savedInstanceState == null) {
            fragmentA = FragmentA()
            fragmentB = FragmentB()

            childFragmentManager.beginTransaction()
                .replace(R.id.container_fragment_a, fragmentA)
                .replace(R.id.container_fragment_b, fragmentB)
                .commit()
        } else {
            fragmentA = childFragmentManager.findFragmentById(R.id.container_fragment_a) as FragmentA
            fragmentB = childFragmentManager.findFragmentById(R.id.container_fragment_b) as FragmentB
        }

        return view
    }

    override fun onSendMessageToB(message: String) {
        fragmentB.updateMessage(message)
        Toast.makeText(context, "Transmis de FragmentA à FragmentB : $message", Toast.LENGTH_SHORT).show()
    }
}
