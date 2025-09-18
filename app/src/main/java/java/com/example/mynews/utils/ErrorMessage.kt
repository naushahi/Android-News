package java.com.example.mynews.utils

import androidx.annotation.StringRes

data class ErrorMessage(
    val id: Long,
    @StringRes val messageId: Int
)