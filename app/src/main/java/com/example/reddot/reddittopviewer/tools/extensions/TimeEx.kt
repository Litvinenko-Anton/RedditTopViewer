package com.example.reddot.reddittopviewer.tools.extensions

import android.annotation.SuppressLint
import java.util.*

private const val NOW = "Just now"
private const val MINUTES = "m. ago"
private const val HOURS = "h. ago"
private const val DAYS = "d. ago"
private const val UNKNOWN = "Unknown time"

@SuppressLint("DefaultLocale")
fun Long.getTimeAgo(): String {
    if (this == null) return UNKNOWN
    var different = Date().time - this * 1000L //different milliseconds
    val secondsInMilli: Long = 1000
    val minutesInMilli = secondsInMilli * 60
    val hoursInMilli = minutesInMilli * 60
    val daysInMilli = hoursInMilli * 24

    val elapsedDays = different / daysInMilli       // DAYS
    different %= daysInMilli
    val elapsedHours = different / hoursInMilli     // HOURS
    different %= hoursInMilli
    val elapsedMinutes = different / minutesInMilli // MINUTES

    return if (elapsedDays > 0) {
        elapsedDays.toString() + " " + DAYS       // return if DAYS
    } else if (elapsedHours > 0) {
        elapsedHours.toString() + " " + HOURS     // return if HOURS
    } else if (elapsedMinutes > 0) {
        elapsedMinutes.toString() + " " + MINUTES // return if MINUTES
    } else {
        NOW                                       // return if NOW
    }
}