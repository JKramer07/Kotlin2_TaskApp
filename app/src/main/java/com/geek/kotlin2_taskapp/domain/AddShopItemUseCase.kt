package com.geek.kotlin2_taskapp.domain

import com.geek.kotlin2_taskapp.domain.model.ShopItem
import com.geek.kotlin2_taskapp.domain.repository.ShopListRepository

class AddShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun addShopItem(shopItem: ShopItem) {
        shopListRepository.addShopItem(shopItem)
    }
}