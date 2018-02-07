package com.fadhlika.finance

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.fadhlika.finance.Model.Expense
import java.text.SimpleDateFormat

/**
 * Created by fadh on 07/02/2018.
 */
class HistoryAdapter(var expenses: List<Expense>) : RecyclerView.Adapter<HistoryAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent?.context).inflate(R.layout.history_item, parent, false)

        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return expenses.size
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        val exp = expenses[position]
        holder?.dateTextView?.text = SimpleDateFormat("dd MMM").format(exp.createdDate)
        holder?.descriptionTextview?.text = exp.description
        holder?.amountTextview?.text = exp.amount.toString()
    }

    inner class ViewHolder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
        val dateTextView: TextView = itemView?.findViewById(R.id.date_textview) as TextView
        val descriptionTextview: TextView = itemView?.findViewById(R.id.description_textview) as TextView
        val amountTextview: TextView = itemView?.findViewById(R.id.amount_textview) as TextView
    }
}

