package com.example.fcm.repository

import androidx.lifecycle.LiveData
import com.example.fcm.Resource
import com.example.fcm.data.local.ShoppingItem
import com.example.fcm.data.remote.response.ShoppingResponse

interface ShoppingRepository {
    suspend fun deleteshoping(shoppingItem: ShoppingItem)

    suspend fun insertShoppingItem(shoppingItem: ShoppingItem)

     fun observerShoppingItem() : LiveData<List<ShoppingItem>>

     fun observerTotalPrice() : LiveData<Float>

    suspend fun searchForImage(imageQuery: String) : Resource<ShoppingResponse>
}