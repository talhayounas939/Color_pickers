package com.example.colorpicker.ui.theme.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.colorpicker.ui.theme.model.ColorFamily
import com.example.colorpicker.ui.theme.model.ColorShade

/**
 * Displays all the shades of a ColorFamily vertically.
 */
@Composable
fun ColorColumn(
    family: ColorFamily,
    selectedColor: Color,
    onColorSelected: (Color) -> Unit
) {
    Column(
        modifier = Modifier
            .padding(horizontal = 1.dp)
            .width(60.dp) // Fixed width for each color column
    ) {
        // Display the family name
        Text(
            text = family.name,
            style = MaterialTheme.typography.labelSmall,
            modifier = Modifier.padding(bottom = 4.dp),
            maxLines = 1 // Prevent text from wrapping too much
        )

        // Display all color shades as clickable swatches
        family.shades.forEach { shade ->
            ColorSwatch(
                colorShade = shade,
                isSelected = shade.color == selectedColor,
                onColorSelected = onColorSelected
            )
            Spacer(modifier = Modifier.height(2.dp))
        }
    }
}

/**
 * Displays a single color swatch with selection indicator.
 */
@Composable
fun ColorSwatch(
    colorShade: ColorShade,
    isSelected: Boolean,
    onColorSelected: (Color) -> Unit
) {
    // FIX: A Box with no content needs an explicit size. Added fillMaxWidth().
    // FIX: Simplified the border logic using the `border` modifier for clarity and correctness.
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .height(24.dp)
            .background(colorShade.color, RoundedCornerShape(4.dp))
            .clickable { onColorSelected(colorShade.color) }
            .then(
                if (isSelected) {
                    Modifier.border(2.dp, Color.Black, RoundedCornerShape(4.dp))
                } else {
                    Modifier
                }
            )
    )
}
