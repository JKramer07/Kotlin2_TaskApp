package com.geek.kotlin2_taskapp.presentation.main

import android.os.Bundle
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.RecyclerView
import by.kirich1409.viewbindingdelegate.viewBinding
import com.geek.kotlin2_taskapp.R
import com.geek.kotlin2_taskapp.databinding.ActivityMainBinding
import com.geek.kotlin2_taskapp.domain.model.ShopItem

class MainActivity : AppCompatActivity(R.layout.activity_main) {

    private val binding: ActivityMainBinding by viewBinding()
    private val viewModel: MainViewModel by viewModels()
//    private lateinit var shopAdapter: ShopListAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initListeners()
//        initObservers()
//        setupRecycler()
    }

//    private fun setupSwipeListener(rv: RecyclerView) {
//        val callback = object : ItemTouchHelper.SimpleCallback(
//                0,
//                ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
//        ){
//            override fun onMove(recyclerView: RecyclerView, viewHolder: RecyclerView.ViewHolder, target: RecyclerView.ViewHolder): Boolean {
//                return false
//            }
//
//            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
//                val item = shopAdapter.list[viewHolder.absoluteAdapterPosition]
//                ///
//            }
//        }
//
//        val itemTouchHelper = ItemTouchHelper(callback)
//        itemTouchHelper.attachToRecyclerView(rv)
//    }
//
//    private fun initObservers() {
//        viewModel.shopList.observe(this, { listData ->
//            shopAdapter.list = listData
//        })
//    }
//
//    private fun setupRecycler() {
//        with(binding.recycler){
//            adapter = ShopListAdapter()
//            adapter = shopAdapter
//        }
//        setupSwipeListener(binding.recycler)
//    }

    private fun initListeners() {
        binding.btnStart.setOnClickListener { addShopItemFun() }

        binding.btnGetAll.setOnClickListener { getShopList() }

        binding.btnDelete.setOnClickListener { deleteShopItemFun() }

        binding.btnEdit.setOnClickListener { editShopItemFun() }

        binding.btnGet.setOnClickListener { getShopItemFun() }
    }

    private fun addShopItemFun() {
        viewModel.addShopItem(ShopItem("Potato", 2, false, 1))
        Toast.makeText(applicationContext, "Item added", Toast.LENGTH_SHORT).show()
    }

    private fun getShopList() {
        viewModel.shopList.observe(this, Observer { list ->
            list.forEach { shopItem ->
                Toast.makeText(applicationContext, shopItem.toString(), Toast.LENGTH_SHORT).show()
            }
        })
    }

    private fun deleteShopItemFun() {
        viewModel.shopList.value?.get(0)?.let {
            viewModel.deleteShopItem(it)
            Toast.makeText(applicationContext, "Item is deleted", Toast.LENGTH_SHORT).show()
        }
    }

    private fun editShopItemFun() {
        viewModel.editShopItem(ShopItem("Tomato", 3, false, 1))
    }

    private fun getShopItemFun() {
        val item = viewModel.getShopItem(1)
        Toast.makeText(applicationContext, "Added: $item", Toast.LENGTH_SHORT).show()
    }
}