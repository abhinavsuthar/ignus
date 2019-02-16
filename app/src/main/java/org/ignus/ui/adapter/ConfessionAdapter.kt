package org.ignus.ui.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import org.ignus.R
import org.ignus.db.models.Message
import org.ignus.utils.formatShortTime

class ConfessionAdapter : RecyclerView.Adapter<ConfessionAdapter.MyViewHolder>() {

    private var list: List<Message> = emptyList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.confession_message, parent, false)
        return MyViewHolder(view)
    }

    override fun getItemCount() = list.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bindData(list[position])
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }

    fun setData(list: List<Message>) {
        this.list = list
        notifyDataSetChanged()
    }

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {

        private val text: TextView = view.findViewById(R.id.text)
        private val time: TextView = view.findViewById(R.id.time)

        fun bindData(message: Message) {
            text.text = message.message
            time.text = message.timestamp?.formatShortTime
        }
    }
}