package com.geek.kotlin2_taskapp.domain

import com.geek.kotlin2_taskapp.domain.model.ShopItem
import com.geek.kotlin2_taskapp.domain.repository.ShopListRepository

class EditShopItemUseCase(private val shopListRepository: ShopListRepository) {

    fun editShopItem(shopItem: ShopItem) {
        shopListRepository.editShopItem(shopItem)
    }
}