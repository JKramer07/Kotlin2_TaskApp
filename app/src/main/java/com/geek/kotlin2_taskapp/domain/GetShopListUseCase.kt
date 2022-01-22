package com.geek.kotlin2_taskapp.domain

import com.geek.kotlin2_taskapp.domain.repository.ShopListRepository

class GetShopListUseCase(private val shopListRepository: ShopListRepository) {

    fun getShopList() = shopListRepository.getShopList()
}