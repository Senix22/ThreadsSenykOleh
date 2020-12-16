package com.senix22.threads

import java.util.concurrent.Callable
import java.util.concurrent.Executors
import java.util.concurrent.TimeUnit
import java.util.concurrent.atomic.AtomicInteger
import java.util.concurrent.locks.ReentrantLock
import java.util.stream.IntStream


fun main() {
    threads()
}

fun threads() {
    val count = AtomicInteger(0)
    fun counter() {
        while (true) {
            Thread.sleep(10)
            count.getAndIncrement()
        }
    }

    Thread {
        counter()
    }.start()
    Thread {
        counter()
    }.start()
    Thread {
        counter()
    }.start()
    Thread {
        counter()
    }.start()
    Thread {
        while (true) {
            Thread.sleep(1000)
            println(" THREAD $count")
        }
    }.start()
}
