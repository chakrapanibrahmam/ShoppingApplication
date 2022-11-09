package com.example.fcm.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.example.fcm.Resource
import com.example.fcm.data.local.ShoppingItem
import com.example.fcm.data.remote.response.ShoppingResponse

class FakeShoppingRepository : ShoppingRepository {
    private val shoppingItems = mutableListOf<ShoppingItem>()
    private val observeShopingList = MutableLiveData<List<ShoppingItem>>(shoppingItems)
    private val observerTotalPrice = MutableLiveData<Float>()

    private var shouldReturnNetworkError = false

    fun setNetworkError(value: Boolean){
        shouldReturnNetworkError = value
    }

    private fun refreshLiveData() {
        observeShopingList.postValue(shoppingItems)
        observerTotalPrice.postValue(getTotalPrice())
    }

    private fun getTotalPrice(): Float {
        return shoppingItems.sumByDouble { it.price.toDouble() }.toFloat()
    }

    override suspend fun deleteshoping(shoppingItem: ShoppingItem) {
        shoppingItems.add(shoppingItem)
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
        shoppingItems.remove(shoppingItem)
    }

    override fun observerShoppingItem(): LiveData<List<ShoppingItem>> {
        return observeShopingList
    }

    override fun observerTotalPrice(): LiveData<Float> {
        return observerTotalPrice
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ShoppingResponse> {
        return if(shouldReturnNetworkError) {
            Resource.error("Error", null)
        } else {
            Resource.success(ShoppingResponse( 0, 0, arrayListOf()))
        }
    }

}