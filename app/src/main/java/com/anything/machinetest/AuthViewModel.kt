package com.anything.machinetest

import android.view.View
import androidx.lifecycle.ViewModel

class AuthViewModel:ViewModel() {

    var email:String?=null
    var pass:String?=null

    var authListner:AuthListner?=null

    fun onLoginButtonClik(view:View){
        authListner?.onStrated()

        if (email.isNullOrEmpty()){
           authListner?.onFailed("Enter valid email address")

        }else if (pass.isNullOrEmpty()){
            authListner?.onFailed("Enter Valid password")
        }else{

            authListner?.onSucess("Enter Valid password")

        }



    }

}