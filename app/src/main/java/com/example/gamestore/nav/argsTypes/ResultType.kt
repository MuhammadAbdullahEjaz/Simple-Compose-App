package com.example.gamestore.nav.argsTypes

import android.os.Bundle
import android.util.Log
import androidx.navigation.NavType
import com.example.gamestore.data.model.Results
import com.squareup.moshi.Moshi
import com.squareup.moshi.kotlin.reflect.KotlinJsonAdapterFactory

class ResultType: NavType<Results>(isNullableAllowed = false) {

    override fun get(bundle: Bundle, key: String): Results? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): Results {
        val moshi = Moshi.Builder().add(KotlinJsonAdapterFactory()).build()
        val jsonAdapter = moshi.adapter(Results::class.java)
        return jsonAdapter.fromJson(value)!!
    }

    override fun put(bundle: Bundle, key: String, value: Results) {
        bundle.putParcelable(key, value)
    }

}