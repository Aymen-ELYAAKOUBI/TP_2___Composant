package com.example.tp_10___composant

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentB : Fragment() {

    private lateinit var tvReceivedMessage: TextView

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_b, container, false)
        tvReceivedMessage = view.findViewById(R.id.tvReceivedMessageB)
        return view
    }

    fun updateMessage(message: String) {
        tvReceivedMessage.text = message
    }
}
