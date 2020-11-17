package com.example.samplebottomsheetdialog

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.plug_in_font_style_read_page.*

public class SampleBottomSheetDialog : BaseReaderPageBottomSheetDialog() {
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.plug_in_font_style_read_page, null)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        recycler_view.adapter = MyAdapter(context!!)
        recycler_view.layoutManager = LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false)

    }

    class MyAdapter(val context: Context): RecyclerView.Adapter<MyVH>() {

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyVH {
            return MyVH(LayoutInflater.from(context).inflate(android.R.layout.simple_list_item_1, parent, false))
        }

        override fun getItemCount(): Int {
            return 100
        }

        override fun onBindViewHolder(holder: MyVH, position: Int) {
            holder.text1.text = "列表数据：$position"
        }

    }

    class MyVH(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var text1 = itemView.findViewById(android.R.id.text1) as TextView
    }
}