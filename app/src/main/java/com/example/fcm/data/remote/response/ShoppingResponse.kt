package com.example.fcm.data.remote.response

data class ShoppingResponse(
    var total : Int,
    var totalHits : Int,
    var hits : ArrayList<HitsResponse>
)
