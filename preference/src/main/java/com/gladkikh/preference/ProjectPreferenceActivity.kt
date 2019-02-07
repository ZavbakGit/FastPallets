package com.gladkikh.preference

import android.support.v7.app.AppCompatActivity
import android.os.Bundle

class ProjectPreferenceActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        supportFragmentManager.beginTransaction()
            .replace(android.R.id.content,SettingsFragment())
            .commit()
    }
}
