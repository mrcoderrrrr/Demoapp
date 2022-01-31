package com.example.demoapps.adapter

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.demoapps.R
import com.example.demoapps.entity.UserEntity
import com.squareup.picasso.Picasso

class RecyclerViewAdapter(private val userEntity: List<UserEntity>) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): RecyclerViewAdapter.ViewHolder {
        val v=LayoutInflater.from(parent.context).inflate(R.layout.activity_userlist_cardview,parent,false)
        return ViewHolder(v)
    }

    override fun onBindViewHolder(holder: RecyclerViewAdapter.ViewHolder, position: Int) {
        holder.username.setText(userEntity.get(position).fname+" "+userEntity.get(position).lname)
        Log.d("UserName",userEntity.get(position).fname+" "+userEntity.get(position).lname)
        holder.gender.setText(userEntity.get(position).gender)
        Picasso.get()
            .load(userEntity.get(position).imagepath)
            .centerCrop()
            .resize(70,70)
            .into(holder.Profile)

    }

    override fun getItemCount(): Int {
return userEntity.size
    }

    inner class ViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
         var Profile:ImageView
         var username:TextView
         var gender:TextView

        init {
            Profile=itemView.findViewById(R.id.ci_profile)
            username=itemView.findViewById(R.id.tv_username)
            gender=itemView.findViewById(R.id.tv_gender)
        }
    }
}
