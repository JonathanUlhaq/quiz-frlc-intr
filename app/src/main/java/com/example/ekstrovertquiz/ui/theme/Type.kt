package com.example.ekstrovertquiz.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.example.ekstrovertquiz.R

// Set of Material typography styles to start with
val monsterat = FontFamily(
    Font(R.font.montserrat_medium, weight = FontWeight.Medium),
    Font(R.font.montserrat_bold, weight = FontWeight.Bold)
)
val poppins = FontFamily(
    Font(R.font.poppins_bold, weight = FontWeight.Bold),
    Font(R.font.poppins_semibold, weight = FontWeight.SemiBold),
    Font(R.font.poppins_light, weight = FontWeight.Light),
    Font(R.font.poppins_extrabold, weight = FontWeight.ExtraBold),
    Font(R.font.poppins_regular, weight = FontWeight.Normal),
    Font(R.font.poppins_medium, weight = FontWeight.Medium)
)
val questrial = FontFamily(
    Font(R.font.questrial_reguler, weight = FontWeight.Normal)
)

val kanit = FontFamily(
    Font(R.font.kanit_regular, weight = FontWeight.Normal),
    Font(R.font.kanit_bold, weight = FontWeight.Bold)
)
val Typography = Typography(
    body1 = TextStyle(
        fontFamily = monsterat,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    body2 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    h1 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h2 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.SemiBold,
        fontSize = 14.sp
    ),
    h3 = TextStyle(
        fontFamily = questrial,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h4 = TextStyle(
        fontFamily = kanit,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    h5 = TextStyle(
        fontFamily = monsterat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    h6 = TextStyle(
        fontFamily = kanit,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp
    ),
    overline = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Light,
        fontSize = 14.sp
    ),
    subtitle1 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    subtitle2 = TextStyle(
        fontFamily = poppins,
        fontWeight = FontWeight.ExtraBold,
        fontSize = 14.sp,
        shadow = Shadow(
            Color.Black,
            offset = Offset(x = 0f,y = 4f),
            blurRadius = 10f
        )
    ),
    caption = TextStyle(
        fontFamily = monsterat,
        fontWeight = FontWeight.Bold,
        fontSize = 14.sp,
        textDecoration = TextDecoration.Underline
    ),
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)