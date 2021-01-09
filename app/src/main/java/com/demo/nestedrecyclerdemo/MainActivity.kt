package com.demo.nestedrecyclerdemo

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MotionEvent
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.transition.Hold
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.item_rv1_main.view.*
import kotlinx.android.synthetic.main.item_rv_main.view.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // RecyclerView
        val rvMainAdapter = RvMainAdapter()
        rv_main.layoutManager = LinearLayoutManager(rv_main.context)
        rv_main.adapter = rvMainAdapter
        rvMainAdapter.updateList(getRandomString())
    }

    private fun getRandomString(): List<String> {
        val listString: MutableList<String> = arrayListOf()
        for (i in 0..5) {
            listString.add("item$i")
        }
        return listString
    }
}

class RvMainAdapter : RecyclerView.Adapter<RvMainAdapter.Holder>() {

    var stringList: List<String> = arrayListOf()

    fun updateList(stringList: List<String>) {
        this.stringList = stringList
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_rv_main, parent, false
        )
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.tv_index.text = stringList[position]
        val rv1MainAdapter = Rv1MainAdapter()
        holder.itemView.rv_1.layoutManager = LinearLayoutManager(holder.itemView.rv_1.context)
        holder.itemView.rv_2.layoutManager = LinearLayoutManager(holder.itemView.rv_2.context)
        holder.itemView.rv_3.layoutManager = LinearLayoutManager(holder.itemView.rv_3.context)
        holder.itemView.rv_4.layoutManager = LinearLayoutManager(holder.itemView.rv_4.context)
        holder.itemView.rv_1.adapter = rv1MainAdapter
        holder.itemView.rv_2.adapter = rv1MainAdapter
        holder.itemView.rv_3.adapter = rv1MainAdapter
        holder.itemView.rv_4.adapter = rv1MainAdapter
        // 当内部的RecyclerView不滑动时的解决方案
        holder.itemView.rv_1.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val action = e.action
                when (action) {
                    MotionEvent.ACTION_MOVE -> rv.parent.requestDisallowInterceptTouchEvent(true)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }

        })
        holder.itemView.rv_2.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val action = e.action
                when (action) {
                    MotionEvent.ACTION_MOVE -> rv.parent.requestDisallowInterceptTouchEvent(true)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }

        })
        holder.itemView.rv_3.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val action = e.action
                when (action) {
                    MotionEvent.ACTION_MOVE -> rv.parent.requestDisallowInterceptTouchEvent(true)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }

        })
        holder.itemView.rv_4.addOnItemTouchListener(object : RecyclerView.OnItemTouchListener {
            override fun onInterceptTouchEvent(rv: RecyclerView, e: MotionEvent): Boolean {
                val action = e.action
                when (action) {
                    MotionEvent.ACTION_MOVE -> rv.parent.requestDisallowInterceptTouchEvent(true)
                }
                return false
            }

            override fun onTouchEvent(rv: RecyclerView, e: MotionEvent) {
                TODO("Not yet implemented")
            }

            override fun onRequestDisallowInterceptTouchEvent(disallowIntercept: Boolean) {
                TODO("Not yet implemented")
            }

        })
        rv1MainAdapter.updateList(getRandomString())
    }

    override fun getItemCount(): Int {
        return stringList.size
    }

    private fun getRandomString(): List<String> {
        val listString: MutableList<String> = arrayListOf()
        for (i in 0..5) {
            listString.add("item$i")
        }
        return listString
    }

}

class Rv1MainAdapter : RecyclerView.Adapter<Rv1MainAdapter.Holder>() {

    var stringList: List<String> = arrayListOf()

    fun updateList(stringList: List<String>) {
        this.stringList = stringList
    }

    class Holder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val view = LayoutInflater.from(parent.context).inflate(
            R.layout.item_rv1_main, parent, false
        )
        return Holder(view)
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        holder.itemView.tv_name.text = stringList[position]
    }

    override fun getItemCount(): Int {
        return stringList.size
    }
}