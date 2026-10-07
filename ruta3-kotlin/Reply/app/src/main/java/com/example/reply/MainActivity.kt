package com.example.reply

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import com.example.reply.ui.ReplyApp
import com.example.reply.ui.theme.ReplyTheme

class MainActivity : ComponentActivity() {
    @OptIn(ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)
        setContent {
            ReplyTheme {
                val windowSize = calculateWindowSizeClass(this)
                ReplyApp(windowSize = windowSize.widthSizeClass)
            }
        }
    }
}
@androidx.compose.ui.tooling.preview.Preview(showBackground = true, widthDp = 400)
@androidx.compose.runtime.Composable
fun ReplyAppCompactPreview() {
    ReplyTheme {
        ReplyApp(windowSize = androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Compact)
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true, widthDp = 700)
@androidx.compose.runtime.Composable
fun ReplyAppMediumPreview() {
    ReplyTheme {
        ReplyApp(windowSize = androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Medium)
    }
}

@androidx.compose.ui.tooling.preview.Preview(showBackground = true, widthDp = 1000)
@androidx.compose.runtime.Composable
fun ReplyAppExpandedPreview() {
    ReplyTheme {
        ReplyApp(windowSize = androidx.compose.material3.windowsizeclass.WindowWidthSizeClass.Expanded)
    }
}