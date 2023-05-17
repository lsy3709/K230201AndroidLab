package com.example.test12

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBarDrawerToggle
import com.example.test12.databinding.FragmentTotalBinding
import com.example.test12.databinding.FragmentTwoBinding


class TotalFragment : Fragment() {
    lateinit var binding: FragmentTotalBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentTotalBinding.inflate(inflater, container, false)
        return binding.root



        //임시 데이터 만들기.
        val datas = mutableListOf<String>()
        for(i in 1..20) {
            datas.add("Item $i")
        }


    }
}