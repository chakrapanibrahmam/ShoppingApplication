package com.example.fcm



import com.google.common.truth.Truth.assertThat
import org.junit.Test

class homworkTest{
    @Test
    fun `check if n is greater then 10 return false`(){
        var result = homwork.fibonnic(
            20
        )
        assertThat(result).isGreaterThan(10)
    }
}