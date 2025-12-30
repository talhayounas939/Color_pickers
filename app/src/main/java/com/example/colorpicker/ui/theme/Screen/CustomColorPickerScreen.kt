package com.example.colorpicker.ui.theme.Screen

import android.graphics.Color.colorToHSV
import android.graphics.Color.parseColor
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardActionScope
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Slider
import androidx.compose.material3.SliderDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onSizeChanged
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.IntOffset
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import kotlin.math.roundToInt

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomColorPickerScreen() {
    var hue by remember { mutableFloatStateOf(0f) }
    var saturation by remember { mutableFloatStateOf(1f) }
    var value by remember { mutableFloatStateOf(1f) }
    var alpha by remember { mutableFloatStateOf(1f) }

    val color = Color.hsv(hue, saturation, value, alpha)
    val focusManager = LocalFocusManager.current

    var hexInput by remember { mutableStateOf("") }
    var rInput by remember { mutableStateOf("") }
    var gInput by remember { mutableStateOf("") }
    var bInput by remember { mutableStateOf("") }
    var aInput by remember { mutableStateOf("") }

    LaunchedEffect(color) {
        hexInput = color.toArgb().toUInt().toString(16).uppercase().takeLast(6)
        rInput = (color.red * 255).toInt().toString()
        gInput = (color.green * 255).toInt().toString()
        bInput = (color.blue * 255).toInt().toString()
        aInput = (alpha * 100).toInt().toString()
    }

    fun updateColorFromRgba() {
        val r = rInput.toIntOrNull()?.coerceIn(0, 255) ?: (color.red * 255).toInt()
        val g = gInput.toIntOrNull()?.coerceIn(0, 255) ?: (color.green * 255).toInt()
        val b = bInput.toIntOrNull()?.coerceIn(0, 255) ?: (color.blue * 255).toInt()
        val aPercent = aInput.toIntOrNull()?.coerceIn(0, 100) ?: (alpha * 100).toInt()

        val newColor = Color(r, g, b)
        val newAlpha = aPercent / 100f

        val hsv = FloatArray(3)
        colorToHSV(newColor.toArgb(), hsv)
        hue = hsv[0]
        saturation = hsv[1]
        value = hsv[2]
        alpha = newAlpha
    }

    val textColor = remember(color) {
        if (color.red * 0.299 + color.green * 0.587 + color.blue * 0.114 > 0.5) Color.Black else Color.White
    }

    Column(modifier = Modifier.fillMaxSize().padding(16.dp)) {
        Box(
            modifier = Modifier.fillMaxWidth().height(120.dp).shadow(8.dp, RoundedCornerShape(16.dp)).background(color, RoundedCornerShape(16.dp)),
            contentAlignment = Alignment.TopEnd
        ) {
            Text(
                modifier = Modifier.padding(12.dp),
                text = "#${hexInput.uppercase()}",
                style = MaterialTheme.typography.bodyLarge,
                color = textColor
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        var squareSize by remember { mutableStateOf(IntSize.Zero) }
        var squarePosition by remember { mutableStateOf(Offset(saturation * (squareSize.width.toFloat()), (1f - value) * squareSize.height.toFloat())) }

        LaunchedEffect(saturation, value, squareSize) {
            squarePosition = Offset(saturation * squareSize.width.toFloat(), (1f - value) * squareSize.height.toFloat())
        }

        val thumbSize = 24.dp
        val thumbRadius = with(LocalDensity.current) { thumbSize.toPx() / 2f }

        Box(
            modifier = Modifier.fillMaxWidth().height(200.dp).onSizeChanged { squareSize = it }.pointerInput(Unit) {
                detectDragGestures { change, _ ->
                    val newPosition = change.position
                    squarePosition = Offset(
                        x = newPosition.x.coerceIn(0f, squareSize.width.toFloat()),
                        y = newPosition.y.coerceIn(0f, squareSize.height.toFloat())
                    )
                    saturation = (squarePosition.x / squareSize.width).coerceIn(0f, 1f)
                    value = 1f - (squarePosition.y / squareSize.height).coerceIn(0f, 1f)
                }
            }.background(Brush.horizontalGradient(colors = listOf(Color.White, Color.hsv(hue, 1f, 1f))))
        ) {
            Box(modifier = Modifier.fillMaxSize().background(Brush.verticalGradient(colors = listOf(Color.Transparent, Color.Black))))
            Box(
                modifier = Modifier.offset {
                    IntOffset(
                        x = (squarePosition.x - thumbRadius).roundToInt().coerceIn(0, squareSize.width - thumbSize.toPx().roundToInt()),
                        y = (squarePosition.y - thumbRadius).roundToInt().coerceIn(0, squareSize.height - thumbSize.toPx().roundToInt())
                    )
                }.size(thumbSize).border(2.dp, Color.White, CircleShape).background(color, CircleShape)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Hue Slider
        Box(modifier = Modifier.height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier.fillMaxWidth().height(20.dp).background(
                    brush = Brush.horizontalGradient(
                        colors = listOf(Color.Red, Color.Yellow, Color.Green, Color.Cyan, Color.Blue, Color.Magenta, Color.Red)
                    ), shape = RoundedCornerShape(10.dp)
                ).align(Alignment.Center)
            )
            Slider(
                value = hue, onValueChange = { hue = it }, valueRange = 0f..360f, modifier = Modifier.fillMaxWidth(),
                thumb = { Box(modifier = Modifier.size(24.dp).background(Color.hsv(hue, 1f, 1f), CircleShape)) },
                colors = SliderDefaults.colors(activeTrackColor = Color.Transparent, inactiveTrackColor = Color.Transparent)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // Alpha Slider
        Box(modifier = Modifier.height(IntrinsicSize.Min)) {
            Box(
                modifier = Modifier.fillMaxWidth().height(20.dp).background(
                    brush = Brush.horizontalGradient(colors = listOf(color.copy(alpha = 0f), color.copy(alpha = 1f))),
                    shape = RoundedCornerShape(10.dp)
                ).align(Alignment.Center)
            )
            Slider(
                value = alpha, onValueChange = { alpha = it }, modifier = Modifier.fillMaxWidth(),
                thumb = { Box(modifier = Modifier.size(24.dp).background(color.copy(alpha = 1f), CircleShape)) },
                colors = SliderDefaults.colors(activeTrackColor = Color.Transparent, inactiveTrackColor = Color.Transparent)
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        val textFieldColors = OutlinedTextFieldDefaults.colors(
            focusedContainerColor = Color(0xFF3A3A3C),
            unfocusedContainerColor = Color(0xFF3A3A3C),
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            unfocusedBorderColor = Color.DarkGray,
            focusedBorderColor = Color.LightGray,
            unfocusedLabelColor = Color.Gray,
            focusedLabelColor = Color(0xFF1A237E),
            cursorColor = Color.White,
            focusedPrefixColor = Color.White,
            unfocusedPrefixColor = Color.Gray,
            focusedSuffixColor = Color.White,
            unfocusedSuffixColor = Color.White
        )

        // HEX Input
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = hexInput, onValueChange = { hexInput = it.take(6) }, label = { Text("HEX", fontWeight = FontWeight.Bold) },
                prefix = { Text("#") }, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Text, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = {
                    if (hexInput.length == 6) {
                        runCatching { Color(parseColor("#$hexInput")) }.getOrNull()?.let {
                            val hsv = FloatArray(3)
                            colorToHSV(it.toArgb(), hsv)
                            hue = hsv[0]
                            saturation = hsv[1]
                            value = hsv[2]
                        }
                    }
                    focusManager.clearFocus()
                }),
                colors = textFieldColors,
                modifier = Modifier.width(150.dp),
                textStyle = MaterialTheme.typography.bodyLarge
            )
        }

        Spacer(modifier = Modifier.height(16.dp))

        // RGBA Inputs
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.spacedBy(4.dp)) {
            val onDone: (KeyboardActionScope.() -> Unit) = {
                updateColorFromRgba()
                focusManager.clearFocus()
            }
            OutlinedTextField(
                value = rInput, onValueChange = { rInput = it.filter(Char::isDigit).take(3) }, label = { Text("R", fontWeight = FontWeight.Bold) }, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onDone = onDone), colors = textFieldColors, modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.bodyLarge
            )
            OutlinedTextField(
                value = gInput, onValueChange = { gInput = it.filter(Char::isDigit).take(3) }, label = { Text("G", fontWeight = FontWeight.Bold) }, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onDone = onDone), colors = textFieldColors, modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.bodyLarge
            )
            OutlinedTextField(
                value = bInput, onValueChange = { bInput = it.filter(Char::isDigit).take(3) }, label = { Text("B", fontWeight = FontWeight.Bold) }, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Next),
                keyboardActions = KeyboardActions(onDone = onDone), colors = textFieldColors, modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.bodyLarge
            )
            OutlinedTextField(
                value = aInput, onValueChange = { aInput = it.filter(Char::isDigit).take(3) }, label = { Text("A", fontWeight = FontWeight.Bold) }, singleLine = true,
                keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number, imeAction = ImeAction.Done),
                keyboardActions = KeyboardActions(onDone = onDone), colors = textFieldColors, modifier = Modifier.weight(1f),
                textStyle = MaterialTheme.typography.bodyLarge,
                suffix = { Text("%") }
            )
        }
    }
}

private fun Int.toHexString(): String = java.lang.String.format("%06X", 0xFFFFFF and this)
