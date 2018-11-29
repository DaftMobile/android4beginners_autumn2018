package com.daftmobile.android4beginners4


data class Luminosity(val lux: Float) {
    val fractionOfIndoorLight = lux/1200f
}