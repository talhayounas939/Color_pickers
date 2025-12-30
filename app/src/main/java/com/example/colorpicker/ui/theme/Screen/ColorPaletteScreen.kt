package com.example.colorpicker.ui.theme.Screen

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.colorpicker.ui.theme.components.ColorColumn
import com.example.colorpicker.ui.theme.model.colorFamilies

@Composable
fun ColorPaletteScreen(onNavigateToCustomPicker: () -> Unit) {
    var selectedColor by remember { mutableStateOf(colorFamilies.first().shades[2].color) }

    // PERFORMANCE: Use `remember` to avoid re-calculating on every recomposition.
    // This will only re-calculate when `selectedColor` changes.
    val (selectedFamily, selectedShade) = remember(selectedColor) {
        val family = colorFamilies.find { family ->
            family.shades.any { it.color == selectedColor }
        }
        val shade = family?.shades?.find { it.color == selectedColor }
        Pair(family, shade)
    }

    val colorLabel = selectedShade?.label ?: selectedFamily?.name ?: "Unknown"

    // FIX: Changed hex code to #RRGGBB format.
    val hexCode = "#${selectedColor.toArgb().toUInt().toString(16).uppercase().takeLast(6)}"

    // Determine text color for good contrast.
    val textColorOnSelected = remember(selectedColor) {
        if (selectedColor.red * 0.299 + selectedColor.green * 0.587 + selectedColor.blue * 0.114 > 0.5) {
            Color.Black
        } else {
            Color.White
        }
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState()) // Make the screen scrollable
    ) {

        // FIX: Move the color name and hex code to the top-right corner.
        Box(
            modifier = Modifier
                .fillMaxWidth()
                .padding(16.dp)
                .shadow(8.dp, RoundedCornerShape(16.dp))
                .background(selectedColor, RoundedCornerShape(16.dp))
                .height(120.dp),
            contentAlignment = Alignment.TopEnd // Aligns content to the top-right
        ) {
            Column(
                modifier = Modifier.padding(12.dp),
                horizontalAlignment = Alignment.End, // Aligns text to the right
            ) {
                Text(
                    text = colorLabel,
                    style = MaterialTheme.typography.titleMedium,
                    color = textColorOnSelected
                )
                Spacer(modifier = Modifier.height(4.dp))
                Text(
                    text = hexCode,
                    style = MaterialTheme.typography.bodyLarge, // FIX: Use a smaller text size
                    color = textColorOnSelected
                )
            }
        }

        // FIX: Replaced the Button with a custom Box with a professional blue gradient background.
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 16.dp, vertical = 8.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            Text(
                text = "Select a Color",
                style = MaterialTheme.typography.titleLarge
            )
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .clip(RoundedCornerShape(50))
                    .background(
                        brush = Brush.horizontalGradient(
                            colors = listOf(Color(0xFF2196F3), Color(0xFF1A237E))
                        )
                    )
                    .clickable { onNavigateToCustomPicker() }
            ) {
                Text(
                    text = "Advanced",
                    color = Color.White,
                    fontWeight = FontWeight.Bold,
                    modifier = Modifier.padding(horizontal = 20.dp, vertical = 10.dp)
                )
            }
        }

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .horizontalScroll(rememberScrollState())
                .padding(horizontal = 8.dp),
            horizontalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            // PERFORMANCE: Add a `key` to help Compose identify items.
            colorFamilies.forEach { family ->
                key(family.name) {
                    ColorColumn(
                        family = family,
                        selectedColor = selectedColor,
                        onColorSelected = { selectedColor = it }
                    )
                }
            }
        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(260.dp)
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .shadow(0.dp, RoundedCornerShape(12.dp))
                .background(Color.LightGray.copy(alpha = 0.2f), RoundedCornerShape(12.dp))
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .verticalScroll(rememberScrollState())
                    .padding(12.dp)
            ) {
                Text(
                    text = "All Families",
                    style = MaterialTheme.typography.titleLarge,
                    modifier = Modifier.padding(bottom = 8.dp)
                )

                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .horizontalScroll(rememberScrollState()),
                    horizontalArrangement = Arrangement.spacedBy(0.dp)
                ) {
                    // PERFORMANCE: Add a `key` to help Compose identify items.
                    colorFamilies.forEach { family ->
                        key(family.name) {
                            ColorColumn(
                                family = family,
                                selectedColor = selectedColor,
                                onColorSelected = { selectedColor = it }
                            )
                        }
                    }
                }
            }
        }
    }
}
