package com.example.fcm

import com.google.common.truth.Truth.assertThat
import org.junit.Test


class  RegistrationUtilTest{

    @Test
    fun `return false if username null`(){
        var result = RegistrationUtil.loginResgistration(
            "",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `return false password and enterAgain not equal`(){
        var result = RegistrationUtil.loginResgistration(
            "Brahmam",
            "123",
            "1234"
        )
        assertThat(result).isFalse()
    }

    @Test
    fun `return false if username less than 2 char`(){
        var result = RegistrationUtil.loginResgistration(
            "d",
            "123",
            "123"
        )
        assertThat(result).isFalse()
    }





}