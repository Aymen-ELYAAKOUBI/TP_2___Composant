package com.example.tp_10___composant

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment

class FragmentA : Fragment() {

    interface OnFragmentASendListener {
        fun onSendMessageToB(message: String)
    }

    private var listener: OnFragmentASendListener? = null

    override fun onAttach(context: Context) {
        super.onAttach(context)
        if (context is OnFragmentASendListener) {
            listener = context
        } else if (parentFragment is OnFragmentASendListener) {
            listener = parentFragment as OnFragmentASendListener
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_a, container, false)

        val etMessage: EditText = view.findViewById(R.id.etMessageFragmentA)
        val btnSend: Button = view.findViewById(R.id.btnSendToFragmentB)

        btnSend.setOnClickListener {
            val msg = etMessage.text.toString().trim()
            if (msg.isNotEmpty()) {
                listener?.onSendMessageToB(msg)
            }
        }

        return view
    }

    override fun onDetach() {
        super.onDetach()
        listener = null
    }
}
