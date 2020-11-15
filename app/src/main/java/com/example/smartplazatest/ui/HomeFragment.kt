package com.example.smartplazatest.ui

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.smartplazatest.R
import com.example.smartplazatest.adapter.CategoryAdapter
import com.example.smartplazatest.networking.Product
import com.example.smartplazatest.networking.SuperCategory

import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var products: List<Product>
    private lateinit var searchBar: EditText
    private lateinit var categoryItem:MutableList<SuperCategory>
    private lateinit var mAdapter: CategoryAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    private fun filterList(filterItem:String){
        var tempList: MutableList<SuperCategory> = ArrayList()
        for(d in categoryItem){
            if(filterItem in d.name.toString()) {
                tempList.add(d)
            }
        }
        mAdapter.updateList(tempList)
    }
    override fun onResume() {
         categoryItem = mutableListOf(
                SuperCategory(19,"Бакалея"),
                SuperCategory(20,"Бытовая химия"),
                SuperCategory(21,"Детям"),
                SuperCategory(25,"Зоотовары"),
                SuperCategory(26,"Колбасы"),
                SuperCategory(29,"Кулинария"),
                SuperCategory(28,"Консервы"),
                SuperCategory(35,"Овощи и фрукты")
        )
        super.onResume()

        searchBar = requireActivity().findViewById(R.id.filter_category)

        searchBar.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {

            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {

            }

            override fun afterTextChanged(s: Editable?) {
                //filterList(s.toString())
            }

        })



        category_list.layoutManager = LinearLayoutManager(requireContext())
        category_list.adapter = CategoryAdapter(context!!,categoryItem)
    }
}