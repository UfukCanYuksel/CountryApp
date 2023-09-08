package com.example.countrs.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.countrs.adapter.CountryAdapter
import com.example.countrs.databinding.FragmentFeedBinding
import com.example.countrs.viewmodel.FeedViewModel


class FeedFragment : Fragment() {

    private var _binding : FragmentFeedBinding? = null
    private val binding get() = _binding!!
    private lateinit var viewModel : FeedViewModel
    private val countryAdapter = CountryAdapter(arrayListOf())


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        _binding = FragmentFeedBinding.inflate(layoutInflater , container , false)
        val view = binding.root
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        viewModel = ViewModelProvider(this).get(FeedViewModel::class.java)
        viewModel.refreshData()
        binding.countryList.layoutManager = LinearLayoutManager(context)
        binding.countryList.adapter = countryAdapter

        observeLiveData()

    }

    fun observeLiveData(){
        viewModel.countries.observe(viewLifecycleOwner , Observer {
            it?.let {
                binding.countryList.visibility = View.VISIBLE
                countryAdapter.updateCountryList(it)
            }
        })

        viewModel.countryError.observe(viewLifecycleOwner , Observer {error ->
            error?.let {
                if (it){
                    binding.countryError.visibility = View.VISIBLE
                }else{
                    binding.countryError.visibility = View.GONE
                }
            }
        })


        viewModel.countryLoading.observe( viewLifecycleOwner , Observer {loading ->
            loading?.let {
                if (it){
                    binding.countryLoading.visibility = View.VISIBLE
                    binding.countryList.visibility = View.GONE
                    binding.countryError.visibility = View.GONE
                }else{
                    binding.countryLoading.visibility = View.GONE
                }
            }

        })
    }
}