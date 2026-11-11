package com.example.tp_10___composant

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment

class FragmentExample : Fragment() {

    interface OnFragmentInteractionListener {
        fun onFragmentMessageSent(message: String)
    }

    private var listener: OnFragmentInteractionListener? = null
    private var receivedMessage: String? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentInteractionListener) {
            listener = context
        } else if (parentFragment is OnFragmentInteractionListener) {
            listener = parentFragment as OnFragmentInteractionListener
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            receivedMessage = it.getString(ARG_MESSAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_example, container, false)

        val tvMessageFromActivity: TextView = view.findViewById(R.id.tvMessageFromActivity)
        val etMessageBack: EditText = view.findViewById(R.id.etMessageBack)
        val btnSendToActivity: Button = view.findViewById(R.id.btnSendToActivity)

        tvMessageFromActivity.text = receivedMessage ?: "Aucun message reçu"

        btnSendToActivity.setOnClickListener {
            val messageToSend = etMessageBack.text.toString().trim()
            if (messageToSend.isNotEmpty()) {
                listener?.onFragmentMessageSent(messageToSend)
            }
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }

    companion object {
        private const val ARG_MESSAGE = "arg_message"

        fun newInstance(message: String): FragmentExample {
            val fragment = FragmentExample()
            val args = Bundle().apply {
                putString(ARG_MESSAGE, message)
            }
            fragment.arguments = args
            return fragment
        }
    }
}
