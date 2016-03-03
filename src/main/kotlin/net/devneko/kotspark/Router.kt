package net.devneko.kotspark

import spark.Request
import spark.Response
import kotlin.reflect.KFunction3

class Router
(
        val pathPrefix:String = ""
)
{

    inline fun <reified T:Any> post(path:String, func: KFunction3<T, Request, Response, String>) {
        val c:T = T::class.constructors.first().call()
        RouterHelper.sparkPost("$pathPrefix$path", c, func)
    }

    inline fun <reified T:Any> get(path:String, func: KFunction3<T, Request, Response, String>) {
        val c:T = T::class.constructors.first().call()
        RouterHelper.sparkGet("$pathPrefix$path", c, func)
    }

    inline fun <reified T:Any> put(path:String, func: KFunction3<T, Request, Response, String>) {
        val c:T = T::class.constructors.first().call()
        RouterHelper.sparkPut("$pathPrefix$path", c, func)
    }

    inline fun <reified T:Any> delete(path:String, func: KFunction3<T, Request, Response, String>) {
        val c:T = T::class.constructors.first().call()
        RouterHelper.sparkDelete("$pathPrefix$path", c, func)
    }

    inline fun <reified T:Any> head(path:String, func: KFunction3<T, Request, Response, String>) {
        val c:T = T::class.constructors.first().call()
        RouterHelper.sparkHead("$pathPrefix$path", c, func)
    }

    inline fun <reified T:Any> trace(path:String, func: KFunction3<T, Request, Response, String>) {
        val c:T = T::class.constructors.first().call()
        RouterHelper.sparkTrace("$pathPrefix$path", c, func)
    }
}


