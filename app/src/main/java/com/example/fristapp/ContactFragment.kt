package com.example.fristapp

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment


class ContactFragment : Fragment() {

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
        saveInstanceState: Bundle?): View? {

        return inflater.inflate(R.layout.fragment_contact, container, false)
    }


}

