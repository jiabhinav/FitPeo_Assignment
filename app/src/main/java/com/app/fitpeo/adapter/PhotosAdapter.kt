package com.app.fitpeo.adapter


import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.app.fitpeo.databinding.ListPhotosBinding

import com.app.fitpeo.model.ModelPhoto
import com.app.fitpeo.utils.loadImage


class PhotosAdapter(
    val context: Context,val list:ArrayList<ModelPhoto>) :
    RecyclerView.Adapter<PhotosAdapter.ItemView>() {
    lateinit var onClickItem: OnClickItem

    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ItemView {
        val v = ListPhotosBinding.inflate(
            LayoutInflater.from(viewGroup.context),
            viewGroup,
            false
        )
        return ItemView(v)
    }

    override fun onBindViewHolder(holder: ItemView, position: Int) {

        holder.binding.image.loadImage(list[position].url)
    }


    override fun getItemCount(): Int {
       return list.size
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }

    class ItemView(itemView: ListPhotosBinding) :
        RecyclerView.ViewHolder(itemView.root) {
        var binding = itemView
    }

    fun setOnClickListener(onClickItem: OnClickItem) {
        this.onClickItem = onClickItem
    }

    interface OnClickItem {
        fun clickItem(id: Int)
    }


}