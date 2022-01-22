package com.geek.kotlin2_taskapp.domain

import com.geek.kotlin2_taskapp.domain.model.ShopItem
import com.geek.kotlin2_taskapp.domain.repository.ShopListRepository

class GetShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopItem(shopItemId: Int) : ShopItem {
        return shopListRepository.getShopItem(shopItemId)
    }
}