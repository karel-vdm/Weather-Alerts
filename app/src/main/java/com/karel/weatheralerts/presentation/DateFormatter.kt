package com.karel.weatheralerts.presentation

import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.Locale

object ISO8601DateFormatter {
    fun formatDate(apiDateFormat: String?): String {
        if (apiDateFormat.isNullOrEmpty()) {
            return "N/A"
        }
        val apiDataFormatPattern = "yyyy-MM-dd'T'HH"
        try {
            val date = SimpleDateFormat(apiDataFormatPattern, Locale.getDefault())
                .parse(apiDateFormat) ?: return "N/A"
            return DateFormat.getDateTimeInstance(
                DateFormat.SHORT,
                DateFormat.SHORT
            ).format(date)
        } catch (ex: Exception) {
            ex.printStackTrace()
            return "N/A"
        }
    }
}
