package com.example.fcm.data.local

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.room.Database
import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.fcm.getOrAwaitValue
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.test.runBlockingTest
import kotlinx.coroutines.test.runTest
import org.junit.After
import org.junit.Rule

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
class ShoppingItemDaoTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var shoppingDatabase: ShoppingDatabase
    private lateinit var dao: ShoppingDao

    @Before
    fun setup(){
        shoppingDatabase = Room.inMemoryDatabaseBuilder(
            ApplicationProvider.getApplicationContext(),
            shoppingDatabase::class.java,
        ).allowMainThreadQueries().build()
        dao = shoppingDatabase.shoppingDao()
    }

    @Test
    fun insertShoppingItem() = runBlockingTest  {
        val shoppingItem = ShoppingItem("Brahmam","bag",30,30,1)
        dao.insertShoppingItem(shoppingItem)

        val allShoppingItem = dao.observerShoppingItem().getOrAwaitValue()
        assertThat(allShoppingItem).contains(allShoppingItem)
    }

    @Test
    fun deleteShoppingItem() = runBlockingTest()  {
        val shoppingItem = ShoppingItem("Brahmam","bag",30,30,1)
        dao.insertShoppingItem(shoppingItem)
        dao.deleterShoppingItem(shoppingItem)

        val allShoppingItem = dao .observerShoppingItem().getOrAwaitValue()
        assertThat(allShoppingItem).contains(shoppingItem)
    }

    @Test
    fun observeTotalPriceSum() = runBlockingTest {
        val shoppingItem1 = ShoppingItem("Brahmam","bag",30,30,1)
        val shoppingItem2 = ShoppingItem("Brahmam","bag",30,30,2)
        val shoppingItem3 = ShoppingItem("Brahmam","bag",30,30,3)
        dao.insertShoppingItem(shoppingItem1)
        dao.insertShoppingItem(shoppingItem2)
        dao.insertShoppingItem(shoppingItem3)

        val totalPriceSum = dao.observerTotalPrice().getOrAwaitValue()

        assertThat(totalPriceSum).isEqualTo(2 * 10f + 4 * 5.5f)
    }

    @After
    fun teardown(){
        shoppingDatabase.close()
    }
}