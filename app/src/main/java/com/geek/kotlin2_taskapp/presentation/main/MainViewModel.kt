package com.geek.kotlin2_taskapp.presentation.main

import android.widget.Toast
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.geek.kotlin2_taskapp.data.ShopListRepositoryImpl
import com.geek.kotlin2_taskapp.domain.*
import com.geek.kotlin2_taskapp.domain.model.ShopItem

class MainViewModel: ViewModel() {

    private val repository = ShopListRepositoryImpl

    private val addShopItemUseCase = AddShopItemUseCase(repository)
    private val getShopListUseCase = GetShopListUseCase(repository)
    private val deleteShopItemUseCase = DeleteShopItemUseCase(repository)
    private val editShopItemUseCase = EditShopItemUseCase(repository)
    private val getShopItemUseCase = GetShopItemUseCase(repository)

    val shopList = getShopListUseCase.getShopList()

    fun addShopItem(shopItem: ShopItem) {
        addShopItemUseCase.addShopItem(shopItem)
    }

//    fun changeEnabledState(shopItem: ShopItem) {
//        val newItem = shopItem.copy(enabled = !shopItem.enabled)
//        editShopItemUseCase.editShopItem(newItem)
//    }

    fun deleteShopItem(shopItem: ShopItem) {
        deleteShopItemUseCase.deleteShopItem(shopItem)
    }

    fun getShopItem(shopItemId: Int): ShopItem {
        return getShopItemUseCase.getShopItem(shopItemId)
    }

    fun editShopItem(shopItem: ShopItem) {
        val newItem = shopItem.copy(enabled = !shopItem.enabled)
        editShopItemUseCase.editShopItem(newItem)
    }
}