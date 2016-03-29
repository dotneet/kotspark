package net.devneko.kotspark

import spark.Request
import spark.Response
import spark.Spark
import kotlin.reflect.KFunction3

object RouterHelper {

    fun <T> sparkPost(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.post(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }

    fun <T> sparkGet(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.get(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }

    fun <T> sparkPut(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.put(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }

    fun <T> sparkDelete(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.delete(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }

    fun <T> sparkHead(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.head(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }

    fun <T> sparkOptions(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.options(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }

    fun <T> sparkTrace(path:String, controller:T, memberFunc: KFunction3<T, Request, Response, String>) {
        Spark.trace(path, fun(req: spark.Request, res: spark.Response): String {
            return memberFunc.call(controller, req, res)
        })
    }


}