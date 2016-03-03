package net.devneko.kotspark

import com.google.gson.GsonBuilder
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import kotlin.reflect.KClass
import spark.Request

private val gson = with(GsonBuilder()) {
    // JavaScriptは64bit整数が扱えないためStringに変換する
    registerTypeAdapter(Long::class.javaObjectType, object: TypeAdapter<Long>() {
        override fun write(out: JsonWriter?, value: Long?) {
            out ?: throw IllegalStateException()
            out.value(value?.toString() ?: "")
        }

        override fun read(r: JsonReader?): Long? {
            r ?: throw IllegalStateException()
            return r.nextLong()
        }
    })
    create()
}

fun <T:Any> spark.Request.bodyAsJson(clazz: KClass<T>):T? {
    val json = body()
    return gson.fromJson(json, clazz.java)
}


