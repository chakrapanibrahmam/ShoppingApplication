package com.example.fcm

object RegistrationUtil {

    /* .. User is not valid if ..
    *.. return false if user name is null
    * .. return false if password and enterAgain are not equal
    * .. return false if username charaters are below 2
    *
    */

    fun loginResgistration(
         username : String,
         password : String,
         enterAgain : String
    ): Boolean{
        if( username == null || password == null ){
            return false
        }
        if (password != enterAgain){
            return false
        }
        if (username.length < 2){
            return false
        }

        return true
    }


}