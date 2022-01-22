package com.geek.kotlin2_taskapp.domain

import com.geek.kotlin2_taskapp.domain.model.ShopItem
import com.geek.kotlin2_taskapp.domain.repository.ShopListRepository

class DeleteShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun deleteShopItem(shopItem: ShopItem) {
        shopListRepository.deleteShopItem(shopItem)
    }
}