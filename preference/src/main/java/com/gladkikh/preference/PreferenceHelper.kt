package com.gladkikh.preference

import android.content.Intent

interface PreferenceHelper {
    public fun getIntentPreferenceActivity():Intent
    public fun getHost():String
    public fun getLogin():String?
    public fun getPass():String?
}