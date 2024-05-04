package com.example.database.adapter

import android.R
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.example.database.databinding.ItemRvBinding
import com.example.database.model.User

class RvAdapter(var userList: ArrayList<User>, var rvAction: RvAction) : RecyclerView.Adapter<RvAdapter.Vh>() {

    inner class Vh(private val itemUserBinding: ItemRvBinding) :
        RecyclerView.ViewHolder(itemUserBinding.root) {
        fun onBind(user: User) {
            itemUserBinding.txtName.text = user.name
            itemUserBinding.txtNumber.text = user.number
            itemUserBinding.menuPop.setOnClickListener {
                rvAction.moreClick(user, itemUserBinding.menuPop)
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Vh {
        return Vh(ItemRvBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int {
        return userList.size
    }

    override fun onBindViewHolder(holder: Vh, position: Int) {
        holder.onBind(userList[position])
    }

    interface RvAction {
        fun moreClick(user: User, imageView: ImageView)
    }
}