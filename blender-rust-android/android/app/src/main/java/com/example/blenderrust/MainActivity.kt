package com.example.blenderrust

import android.app.Activity
import android.os.Bundle
import android.widget.TextView
import android.widget.LinearLayout
import android.view.Gravity
import android.graphics.Typeface

class MainActivity : Activity() {
    companion object {
        init {
            System.loadLibrary("blender_rust_core")
        }
    }

    private external fun nativeGetStatus(): String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        val title = TextView(this).apply {
            text = "Blender-Rust"
            textSize = 28f
            typeface = Typeface.DEFAULT_BOLD
        }
        val status = TextView(this).apply {
            text = nativeGetStatus()
            textSize = 16f
        }
        val note = TextView(this).apply {
            text = "Android shell is running. 3D viewport is the next milestone."
            textSize = 14f
        }

        setContentView(LinearLayout(this).apply {
            orientation = LinearLayout.VERTICAL
            gravity = Gravity.CENTER
            setPadding(24, 24, 24, 24)
            addView(title)
            addView(status)
            addView(note)
        })
    }
}
