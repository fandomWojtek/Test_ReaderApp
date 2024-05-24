package com.wojtek.test_reader

interface Platform {
    val name: String
}

expect fun getPlatform(): Platform