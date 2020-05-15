package com.eburg_soft.lifehackstudiotestapp.presentation.company_page

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.eburg_soft.lifehackstudiotestapp.R

/**
 * A simple [Fragment] subclass.
 */
class CompanyFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_company, container, false)
    }
}