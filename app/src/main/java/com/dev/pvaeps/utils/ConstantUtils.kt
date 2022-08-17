package com.dev.pvaeps.utils

import android.text.TextUtils.concat


object ConstantUtils {
    val SERVER_BASE_URL = "https://cogentmind.tech/PayVenue/api/statepay/v1/"
    val PRE_URL_MAIN = "https://www.paysallbanking.com/"
    val PRE_URL = concat(PRE_URL_MAIN, "api/authController/")
    val PREF_NAME = "PV AEPS"


}