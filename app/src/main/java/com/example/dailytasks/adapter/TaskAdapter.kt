package com.example.dailytasks.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.dailytasks.R
import com.example.dailytasks.model.TaskModel
import com.example.dailytasks.screens.StartFragment.StartFragment
import kotlinx.android.synthetic.main.item_layout.view.*

class TaskAdapter:RecyclerView.Adapter<TaskAdapter.TaskViewHolder>() {
    class TaskViewHolder(view: View):RecyclerView.ViewHolder(view) {

    }

    override fun getItemCount(): Int = listTask.size

    var listTask = emptyList<TaskModel>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TaskViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout,parent,false)
        return TaskViewHolder(view)
    }

    override fun onBindViewHolder(holder: TaskViewHolder, position: Int) {
        holder.itemView.item_title.text = listTask[position].title

        @SuppressLint("NotifyDataSetChanged")
            fun setList(list: List<TaskModel>){
            listTask = list
            notifyDataSetChanged()
        }
    }

    override fun onViewAttachedToWindow(holder: TaskViewHolder) {
        super.onViewAttachedToWindow(holder)
        holder.itemView.setOnClickListener {
            StartFragment.clickTask(listTask[holder.adapterPosition])
        }
    }

    override fun onViewDetachedFromWindow(holder: TaskViewHolder) {
        super.onViewDetachedFromWindow(holder)
    holder.itemView.setOnClickListener (null)
    }

}