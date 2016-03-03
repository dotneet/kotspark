package net.devneko.kotspark

import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import com.google.gson.TypeAdapter
import com.google.gson.stream.JsonReader
import com.google.gson.stream.JsonWriter
import spark.Response

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

fun Response.ok(bean:Any? = null):String {
    type("application/json")
    status(200)
    bean ?: return "{\"status\":200}"
    return gson.toJson(bean)
}

fun Response.error(bean:Any? = null):String {
    type("application/json")
    status(400)
    bean ?: return "{}"
    if ( bean is String ) {
        return with(JsonObject()) {
            addProperty("message", bean)
            gson.toJson(this)
        }
    }
    return gson.toJson(bean)
}

fun Response.fatal(bean:Any? = null):String {
    type("application/json")
    status(500)
    bean ?: return "{}"
    if ( bean is String ) {
        return with(JsonObject()) {
            addProperty("message", bean)
            gson.toJson(this)
        }
    }
    return gson.toJson(bean)
}
