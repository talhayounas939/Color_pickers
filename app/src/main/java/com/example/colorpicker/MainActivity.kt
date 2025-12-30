package com.example.colorpicker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.MaterialTheme
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.colorpicker.ui.theme.Screen.ColorPaletteScreen
import com.example.colorpicker.ui.theme.Screen.CustomColorPickerScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MaterialTheme {
                val navController = rememberNavController()
                NavHost(navController = navController, startDestination = "colorPalette") {
                    composable("colorPalette") {
                        ColorPaletteScreen(onNavigateToCustomPicker = { navController.navigate("customPicker") })
                    }
                    composable("customPicker") {
                        CustomColorPickerScreen()
                    }
                }
            }
        }
    }
}
