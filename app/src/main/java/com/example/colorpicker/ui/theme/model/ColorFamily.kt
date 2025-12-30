package com.example.colorpicker.ui.theme.model

import androidx.compose.ui.graphics.Color

// Data classes
data class ColorShade(val label: String, val color: Color)
data class ColorFamily(val name: String, val shades: List<ColorShade>)

// ================== COLOR FAMILIES ==================

val redFamily = ColorFamily(
    "Red", listOf(
        ColorShade("Red", Color(0xFFFFEBEE)),
        ColorShade("Red", Color(0xFFFFCDD2)),
        ColorShade("Red", Color(0xFFEF9A9A)),
        ColorShade("Red", Color(0xFFE57373)),
        ColorShade("Red", Color(0xFFEF5350)),
        ColorShade("Red", Color(0xFFF44336)),
        ColorShade("Red", Color(0xFFE53935)),
        ColorShade("Red", Color(0xFFD32F2F)),
        ColorShade("Red", Color(0xFFC62828)),
        ColorShade("Red", Color(0xFFB71C1C)),
        ColorShade("Red Deep", Color(0xFF8B0000))
    )
)

val pinkFamily = ColorFamily(
    "Pink", listOf(
        ColorShade("Pink", Color(0xFFFCE4EC)),
        ColorShade("Pink", Color(0xFFF8BBD0)),
        ColorShade("Pink", Color(0xFFF48FB1)),
        ColorShade("Pink", Color(0xFFF06292)),
        ColorShade("Pink", Color(0xFFEC407A)),
        ColorShade("Pink", Color(0xFFE91E63)),
        ColorShade("Pink", Color(0xFFD81B60)),
        ColorShade("Pink", Color(0xFFC2185B)),
        ColorShade("Pink", Color(0xFFAD1457)),
        ColorShade("Pink", Color(0xFF880E4F)),
        ColorShade("Pink Deep", Color(0xFF560027))
    )
)

val purpleFamily = ColorFamily(
    "Purple", listOf(
        ColorShade("Purple", Color(0xFFF3E5F5)),
        ColorShade("Purple", Color(0xFFE1BEE7)),
        ColorShade("Purple", Color(0xFFCE93D8)),
        ColorShade("Purple", Color(0xFFBA68C8)),
        ColorShade("Purple", Color(0xFFAB47BC)),
        ColorShade("Purple", Color(0xFF9C27B0)),
        ColorShade("Purple", Color(0xFF8E24AA)),
        ColorShade("Purple", Color(0xFF7B1FA2)),
        ColorShade("Purple", Color(0xFF6A1B9A)),
        ColorShade("Purple", Color(0xFF4A148C)),
        ColorShade("Purple Deep", Color(0xFF2E0057))
    )
)

val deepPurpleFamily = ColorFamily(
    "Purple (Deep)", listOf(
        ColorShade("Purple(Deep)", Color(0xFFEDE7F6)),
        ColorShade("Purple(Deep)", Color(0xFFD1C4E9)),
        ColorShade("Purple(Deep)", Color(0xFFB39DDB)),
        ColorShade("Purple(Deep)", Color(0xFF9575CD)),
        ColorShade("Purple(Deep)", Color(0xFF7E57C2)),
        ColorShade("Purple(Deep)", Color(0xFF673AB7)),
        ColorShade("Purple(Deep)", Color(0xFF5E35B1)),
        ColorShade("Purple(Deep)", Color(0xFF512DA8)),
        ColorShade("Purple(Deep)", Color(0xFF4527A0)),
        ColorShade("Purple(Deep)", Color(0xFF311B92)),
        ColorShade("Purple Deepest", Color(0xFF1B0066))
    )
)

val indigoFamily = ColorFamily(
    "Indigo", listOf(
        ColorShade("Indigo", Color(0xFFE8EAF6)),
        ColorShade("Indigo", Color(0xFFC5CAE9)),
        ColorShade("Indigo", Color(0xFF9FA8DA)),
        ColorShade("Indigo", Color(0xFF7986CB)),
        ColorShade("Indigo", Color(0xFF5C6BC0)),
        ColorShade("Indigo", Color(0xFF3F51B5)),
        ColorShade("Indigo", Color(0xFF3949AB)),
        ColorShade("Indigo", Color(0xFF303F9F)),
        ColorShade("Indigo", Color(0xFF283593)),
        ColorShade("Indigo", Color(0xFF1A237E)),
        ColorShade("Indigo Deep", Color(0xFF0F1452))
    )
)

val blueFamily = ColorFamily(
    "Blue", listOf(
        ColorShade("Blue", Color(0xFFE3F2FD)),
        ColorShade("Blue", Color(0xFFBBDEFB)),
        ColorShade("Blue", Color(0xFF90CAF9)),
        ColorShade("Blue", Color(0xFF64B5F6)),
        ColorShade("Blue", Color(0xFF42A5F5)),
        ColorShade("Blue", Color(0xFF2196F3)),
        ColorShade("Blue", Color(0xFF1E88E5)),
        ColorShade("Blue", Color(0xFF1976D2)),
        ColorShade("Blue", Color(0xFF1565C0)),
        ColorShade("Blue", Color(0xFF0D47A1)),
        ColorShade("Blue Deep", Color(0xFF002171))
    )
)

val lightBlueFamily = ColorFamily(
    "Light Blue", listOf(
        ColorShade("Light Blue", Color(0xFFE1F5FE)),
        ColorShade("Light Blue", Color(0xFFB3E5FC)),
        ColorShade("Light Blue", Color(0xFF81D4FA)),
        ColorShade("Light Blue", Color(0xFF4FC3F7)),
        ColorShade("Light Blue", Color(0xFF29B6F6)),
        ColorShade("Light Blue", Color(0xFF03A9F4)),
        ColorShade("Light Blue", Color(0xFF039BE5)),
        ColorShade("Light Blue", Color(0xFF0288D1)),
        ColorShade("Light Blue", Color(0xFF0277BD)),
        ColorShade("Light Blue", Color(0xFF01579B)),
        ColorShade("Light Blue Deep", Color(0xFF003C6E))
    )
)

val cyanFamily = ColorFamily(
    "Cyan", listOf(
        ColorShade("Cyan", Color(0xFFE0F7FA)),
        ColorShade("Cyan", Color(0xFFB2EBF2)),
        ColorShade("Cyan", Color(0xFF80DEEA)),
        ColorShade("Cyan", Color(0xFF4DD0E1)),
        ColorShade("Cyan", Color(0xFF26C6DA)),
        ColorShade("Cyan", Color(0xFF00BCD4)),
        ColorShade("Cyan", Color(0xFF00ACC1)),
        ColorShade("Cyan", Color(0xFF0097A7)),
        ColorShade("Cyan", Color(0xFF00838F)),
        ColorShade("Cyan", Color(0xFF006064)),
        ColorShade("Cyan Deep", Color(0xFF00363D))
    )
)

val tealFamily = ColorFamily(
    "Teal", listOf(
        ColorShade("Teal", Color(0xFFE0F2F1)),
        ColorShade("Teal", Color(0xFFB2DFDB)),
        ColorShade("Teal", Color(0xFF80CBC4)),
        ColorShade("Teal", Color(0xFF4DB6AC)),
        ColorShade("Teal", Color(0xFF26A69A)),
        ColorShade("Teal", Color(0xFF009688)),
        ColorShade("Teal", Color(0xFF00897B)),
        ColorShade("Teal", Color(0xFF00796B)),
        ColorShade("Teal", Color(0xFF00695C)),
        ColorShade("Teal", Color(0xFF004D40)),
        ColorShade("Teal Deep", Color(0xFF002D26))
    )
)

val greenFamily = ColorFamily(
    "Green", listOf(
        ColorShade("Green", Color(0xFFE8F5E9)),
        ColorShade("Green", Color(0xFFC8E6C9)),
        ColorShade("Green", Color(0xFFA5D6A7)),
        ColorShade("Green", Color(0xFF81C784)),
        ColorShade("Green", Color(0xFF66BB6A)),
        ColorShade("Green", Color(0xFF4CAF50)),
        ColorShade("Green", Color(0xFF43A047)),
        ColorShade("Green", Color(0xFF388E3C)),
        ColorShade("Green", Color(0xFF2E7D32)),
        ColorShade("Green", Color(0xFF1B5E20)),
        ColorShade("Green Deep", Color(0xFF003300))
    )
)

val lightGreenFamily = ColorFamily(
    "Light Green", listOf(
        ColorShade("Light Green", Color(0xFFF1F8E9)),
        ColorShade("Light Green", Color(0xFFDCEDC8)),
        ColorShade("Light Green", Color(0xFFC5E1A5)),
        ColorShade("Light Green", Color(0xFFAED581)),
        ColorShade("Light Green", Color(0xFF9CCC65)),
        ColorShade("Light Green", Color(0xFF8BC34A)),
        ColorShade("Light Green", Color(0xFF7CB342)),
        ColorShade("Light Green", Color(0xFF689F38)),
        ColorShade("Light Green", Color(0xFF558B2F)),
        ColorShade("Light Green", Color(0xFF33691E)),
        ColorShade("Light Green Deep", Color(0xFF1B3D0F))
    )
)

val limeFamily = ColorFamily(
    "Lime", listOf(
        ColorShade("Lime", Color(0xFFF9FBE7)),
        ColorShade("Lime", Color(0xFFF0F4C3)),
        ColorShade("Lime", Color(0xFFDCE775)),
        ColorShade("Lime", Color(0xFFD4E157)),
        ColorShade("Lime", Color(0xFFCDDC39)),
        ColorShade("Lime", Color(0xFFC0CA33)),
        ColorShade("Lime", Color(0xFFAFB42B)),
        ColorShade("Lime", Color(0xFF9E9D24)),
        ColorShade("Lime", Color(0xFF827717)),
        ColorShade("Lime", Color(0xFF6B5E00)),
        ColorShade("Lime Deep", Color(0xFF4A4000))
    )
)

val yellowFamily = ColorFamily(
    "Yellow", listOf(
        ColorShade("Yellow", Color(0xFFFFFDE7)),
        ColorShade("Yellow", Color(0xFFFFF9C4)),
        ColorShade("Yellow", Color(0xFFFFF59D)),
        ColorShade("Yellow", Color(0xFFFFF176)),
        ColorShade("Yellow", Color(0xFFFFEE58)),
        ColorShade("Yellow", Color(0xFFFFEB3B)),
        ColorShade("Yellow", Color(0xFFFDD835)),
        ColorShade("Yellow", Color(0xFFFBC02D)),
        ColorShade("Yellow", Color(0xFFF9A825)),
        ColorShade("Yellow", Color(0xFFF57F17)),
        ColorShade("Yellow Deep", Color(0xFF665000))
    )
)

val amberFamily = ColorFamily(
    "Amber", listOf(
        ColorShade("Amber", Color(0xFFFFF8E1)),
        ColorShade("Amber", Color(0xFFFFECB3)),
        ColorShade("Amber", Color(0xFFFFE082)),
        ColorShade("Amber", Color(0xFFFFD54F)),
        ColorShade("Amber", Color(0xFFFFCA28)),
        ColorShade("Amber", Color(0xFFFFC107)),
        ColorShade("Amber", Color(0xFFFFB300)),
        ColorShade("Amber", Color(0xFFFFA000)),
        ColorShade("Amber", Color(0xFFFF8F00)),
        ColorShade("Amber", Color(0xFFFF6F00)),
        ColorShade("Amber Deep", Color(0xFF663C00))
    )
)

val orangeFamily = ColorFamily(
    "Orange", listOf(
        ColorShade("Orange", Color(0xFFFFF3E0)),
        ColorShade("Orange", Color(0xFFFFE0B2)),
        ColorShade("Orange", Color(0xFFFFCC80)),
        ColorShade("Orange", Color(0xFFFFB74D)),
        ColorShade("Orange", Color(0xFFFFA726)),
        ColorShade("Orange", Color(0xFFFF9800)),
        ColorShade("Orange", Color(0xFFFB8C00)),
        ColorShade("Orange", Color(0xFFF57C00)),
        ColorShade("Orange", Color(0xFFEF6C00)),
        ColorShade("Orange", Color(0xFFE65100)),
        ColorShade("Orange Deep", Color(0xFF6A2800))
    )
)

val deepOrangeFamily = ColorFamily(
    "Orange (Deep)", listOf(
        ColorShade("Orange(Deep)", Color(0xFFFBE9E7)),
        ColorShade("Orange(Deep)", Color(0xFFFFCCBC)),
        ColorShade("Orange(Deep)", Color(0xFFFFAB91)),
        ColorShade("Orange(Deep)", Color(0xFFFF8A65)),
        ColorShade("Orange(Deep)", Color(0xFFFF7043)),
        ColorShade("Orange(Deep)", Color(0xFFFF5722)),
        ColorShade("Orange(Deep)", Color(0xFFF4511E)),
        ColorShade("Orange(Deep)", Color(0xFFE64A19)),
        ColorShade("Orange(Deep)", Color(0xFFD84315)),
        ColorShade("Orange(Deep)", Color(0xFFBF360C)),
        ColorShade("Orange Deepest", Color(0xFF661E00))
    )
)

val brownFamily = ColorFamily(
    "Brown", listOf(
        ColorShade("Brown", Color(0xFFEFEBE9)),
        ColorShade("Brown", Color(0xFFD7CCC8)),
        ColorShade("Brown", Color(0xFFBCAAA4)),
        ColorShade("Brown", Color(0xFFA1887F)),
        ColorShade("Brown", Color(0xFF8D6E63)),
        ColorShade("Brown", Color(0xFF795548)),
        ColorShade("Brown", Color(0xFF6D4C41)),
        ColorShade("Brown", Color(0xFF5D4037)),
        ColorShade("Brown", Color(0xFF4E342E)),
        ColorShade("Brown", Color(0xFF3E2723)),
        ColorShade("Brown Deep", Color(0xFF1E0F0D))
    )
)

val greyFamily = ColorFamily(
    "Grey", listOf(
        ColorShade("Grey", Color(0xFFFAFAFA)),
        ColorShade("Grey", Color(0xFFF5F5F5)),
        ColorShade("Grey", Color(0xFFEEEEEE)),
        ColorShade("Grey", Color(0xFFE0E0E0)),
        ColorShade("Grey", Color(0xFFBDBDBD)),
        ColorShade("Grey", Color(0xFF9E9E9E)),
        ColorShade("Grey", Color(0xFF757575)),
        ColorShade("Grey", Color(0xFF616161)),
        ColorShade("Grey", Color(0xFF424242)),
        ColorShade("Grey", Color(0xFF212121)),
        ColorShade("Grey Deep", Color(0xFF111111))
    )
)

val blueGreyFamily = ColorFamily(
    "Blue Grey", listOf(
        ColorShade("Blue Grey", Color(0xFFECEFF1)),
        ColorShade("Blue Grey", Color(0xFFCFD8DC)),
        ColorShade("Blue Grey", Color(0xFFB0BEC5)),
        ColorShade("Blue Grey", Color(0xFF90A4AE)),
        ColorShade("Blue Grey", Color(0xFF78909C)),
        ColorShade("Blue Grey", Color(0xFF607D8B)),
        ColorShade("Blue Grey", Color(0xFF546E7A)),
        ColorShade("Blue Grey", Color(0xFF455A64)),
        ColorShade("Blue Grey", Color(0xFF37474F)),
        ColorShade("Blue Grey", Color(0xFF263238)),
        ColorShade("Blue Grey Deep", Color(0xFF141A1E))
    )
)

// ================== FINAL LIST ==================
val colorFamilies = listOf(
    redFamily, pinkFamily, purpleFamily, deepPurpleFamily,
    indigoFamily, blueFamily, lightBlueFamily, cyanFamily,
    tealFamily, greenFamily, lightGreenFamily, limeFamily,
    yellowFamily, amberFamily, orangeFamily, deepOrangeFamily,
    brownFamily, greyFamily, blueGreyFamily
)
