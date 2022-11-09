package com.example.fcm

object homwork {
    /*
     * return false if n is greater then 10
     * return t1 and t2 equal
     */

    fun fibonnic(n : Int) : Int{
        var t1 = 0
        var t2 = 1

        for (i in 1..n){
           var s = t1 + t2
            t1 = t2
            t2 = s
        }
        return n
    }
}