package com.example.tp_10___composant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment

class Exercice1Fragment : Fragment(), FragmentExample.OnFragmentInteractionListener {

    private lateinit var etMessageToFragment: EditText
    private lateinit var tvReceivedFromFragment: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_exercice1, container, false)

        etMessageToFragment = view.findViewById(R.id.etMessageToFragment)
        tvReceivedFromFragment = view.findViewById(R.id.tvReceivedFromFragment)
        val btnSendToFragment: Button = view.findViewById(R.id.btnSendToFragment)

        btnSendToFragment.setOnClickListener {
            val message = etMessageToFragment.text.toString().trim()
            if (message.isNotEmpty()) {
                val fragmentExample = FragmentExample.newInstance(message)
                childFragmentManager.beginTransaction()
                    .replace(R.id.fragment_container_ex1, fragmentExample)
                    .commit()
            } else {
                Toast.makeText(context, "Veuillez saisir un message", Toast.LENGTH_SHORT).show()
            }
        }

        // Add initial fragment on first load
        if (savedInstanceState == null) {
            val initialMessage = etMessageToFragment.text.toString()
            val fragmentExample = FragmentExample.newInstance(initialMessage)
            childFragmentManager.beginTransaction()
                .replace(R.id.fragment_container_ex1, fragmentExample)
                .commit()
        }

        return view
    }

    override fun onFragmentMessageSent(message: String) {
        tvReceivedFromFragment.text = "Message reçu du Fragment : \"$message\""
        Toast.makeText(context, "Message reçu du Fragment : $message", Toast.LENGTH_SHORT).show()
    }
}
