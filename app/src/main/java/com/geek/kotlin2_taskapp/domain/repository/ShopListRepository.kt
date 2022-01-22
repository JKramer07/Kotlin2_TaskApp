package com.geek.kotlin2_taskapp.domain.repository

import androidx.lifecycle.LiveData
import com.geek.kotlin2_taskapp.domain.model.ShopItem

interface ShopListRepository {

    fun addShopItem(shopItem: ShopItem)

    fun deleteShopItem(shopItem: ShopItem)

    fun getShopList(): LiveData<List<ShopItem>>

    fun editShopItem(shopItem: ShopItem)

    fun getShopItem(shopItemId: Int) : ShopItem
}