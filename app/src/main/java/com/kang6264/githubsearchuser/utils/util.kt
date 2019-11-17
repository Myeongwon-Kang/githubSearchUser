package com.kang6264.githubsearchuser.utils

import java.util.*

fun getSizeString(size : Int) : String{
    if (size < 1024) {
        return String.format(Locale.getDefault(), "%d B", size)
    } else if (size < 1024 * 1024) {
        val sizeK = size / 1024f
        return String.format(Locale.getDefault(), "%.2f KB", sizeK)
    } else if (size < 1024 * 1024 * 1024) {
        val sizeM = size / (1024f * 1024f)
        return String.format(Locale.getDefault(), "%.2f MB", sizeM)
    } else if (size / 1024 < 1024 * 1024 * 1024) {
        val sizeG = size / (1024f * 1024f * 1024f)
        return String.format(Locale.getDefault(), "%.2f GB", sizeG)
    }

    return ""
}