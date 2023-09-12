package com.example.countrs.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.example.countrs.databinding.ItemCountryBinding
import com.example.countrs.model.Country
import com.example.countrs.util.downloadFromUrl
import com.example.countrs.util.placeHolderProgressBar
import com.example.countrs.view.FeedFragmentDirections

class CountryAdapter(val countryList : ArrayList<Country>) : RecyclerView.Adapter<CountryAdapter.CountryViewHolder>() {
    class CountryViewHolder(var binding: ItemCountryBinding) : RecyclerView.ViewHolder(binding.root){

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CountryViewHolder {
        val binding = ItemCountryBinding.inflate(LayoutInflater.from(parent.context), parent ,false)
        return CountryViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return  countryList.size
    }

    override fun onBindViewHolder(holder: CountryViewHolder, position: Int) {
        holder.binding.name.text = countryList[position].countryName
        holder.binding.region.text = countryList[position].countryRegion

        holder.itemView.setOnClickListener {
            val  action = FeedFragmentDirections.actionFeedFragmentToCountryFragment()
            Navigation.findNavController(it).navigate(action)
        }

        countryList[position].imageUrl?.let {
            holder.binding.imageView.downloadFromUrl(
                it,
                placeHolderProgressBar(holder.itemView.context)
            )
        }

    }

    //swiperefreshlayout kullandığım da data yenilenir ise
    // yeni gelen data setini kullanmak için
    fun updateCountryList(newCountryList : List<Country>){ // datayı aldım
        // countryList i boşaltıp
        countryList.clear()
        // yeni data setini countryList'e aktardım
        countryList.addAll(newCountryList)
        //Adapter'i yenilemek için
        notifyDataSetChanged()
    }
}