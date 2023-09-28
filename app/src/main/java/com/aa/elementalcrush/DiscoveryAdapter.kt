package com.aa.elementalcrush

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.aa.elementalcrush.databinding.DiscoveryItemViewBinding
//adapter class to display data in a list view
class DiscoveryAdapter (val discovery : ArrayList<DiscoveryItem>) : RecyclerView.Adapter<DiscoveryAdapter.ViewHolder>() {
    //representing the custom view specified in discovery_item_view.xml
    inner class ViewHolder(var itemBinding : DiscoveryItemViewBinding) : RecyclerView.ViewHolder(itemBinding.root){

    }
    //inflates the view for each discovery item
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DiscoveryAdapter.ViewHolder {
        val itemBinding = DiscoveryItemViewBinding.inflate(LayoutInflater.from(parent.context),parent,false)
        return ViewHolder(itemBinding)
    }
    //takes the discovery item at current position and updates view displaying all elements and information about them
    override fun onBindViewHolder(holder: DiscoveryAdapter.ViewHolder, position: Int) {
        val discoveryItem = discovery[position]
        holder.itemBinding.nameTextView.text= "Element Name: " +  discoveryItem.elementName
        holder.itemBinding.atomicNumberTextView.text= "Atomic Number: " + discoveryItem.eAtomicNumber.toString()
        holder.itemBinding.propertyTextView.text="Properties: " + discoveryItem.eProperty
        holder.itemBinding.descriptionTextView.text= "Description: " + discoveryItem.eDescription
        holder.itemBinding.usageTextView.text="It's Use: " + discoveryItem.eUse
        holder.itemBinding.imageView.setImageResource(discoveryItem.image)
    }
    //lets the adapter know how many survey items to iterate through
    override fun getItemCount(): Int {
        return discovery.size
    }
}
