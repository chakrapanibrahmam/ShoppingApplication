package com.example.fcm.repository

import androidx.lifecycle.LiveData
import com.example.fcm.Resource
import com.example.fcm.api.ShoppingAPI
import com.example.fcm.data.local.ShoppingDao
import com.example.fcm.data.local.ShoppingItem
import com.example.fcm.data.remote.response.ShoppingResponse
import javax.inject.Inject

class DefaultRepository @Inject constructor(
    private val dao: ShoppingDao,
    private val shoppingAPI: ShoppingAPI

) : ShoppingRepository {
    override suspend fun deleteshoping(shoppingItem: ShoppingItem) {
       dao.deleterShoppingItem(shoppingItem)
    }

    override suspend fun insertShoppingItem(shoppingItem: ShoppingItem) {
       dao.insertShoppingItem(shoppingItem)
    }

    override fun observerShoppingItem(): LiveData<List<ShoppingItem>> {
      return dao.observerShoppingItem()
    }

    override fun observerTotalPrice(): LiveData<Float> {
       return dao.observerTotalPrice()
    }

    override suspend fun searchForImage(imageQuery: String): Resource<ShoppingResponse> {
        return try {
            val response = shoppingAPI.searchForImage(imageQuery)
            if (response.isSuccessful){
                response.body()?.let {
                    return@let Resource.success(it)
                }?:Resource.error("An unknow user",null)

            }else{
                Resource.error("An unknow user",null)
            }
        }catch (e : Exception){
            Resource.error("couldn't not find",null)
        }
    }
}