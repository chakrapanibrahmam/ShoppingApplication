package com.example.fcm.data.local

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "shopping_items")
data class ShoppingItem(
    var name : String,
    var item : String,
    var price : Int,
    var amount : Int,
    @PrimaryKey(autoGenerate = true)
    var Id : Int
)
