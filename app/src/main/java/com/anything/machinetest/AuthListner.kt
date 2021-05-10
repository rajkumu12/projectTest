package com.anything.machinetest

interface AuthListner {
    fun onStrated()
    fun onSucess(message: String)
    fun onFailed(message:String)

}