package com.areeb.dynamicappicon.ui.IconChangerScreen

import android.widget.Toast
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.areeb.dynamicappicon.R
import com.areeb.dynamicappicon.data.models.Icon
import com.areeb.dynamicappicon.ui.IconChangerScreen.dialog.PremiumDialog
import com.areeb.dynamicappicon.ui.theme.DynamicAppIconTheme

@Preview
@Composable
fun IconChanger() {
    DynamicAppIconTheme {
        GetIcons()
    }
}

@Composable
fun GetIcons() {
    Column(modifier = Modifier.fillMaxSize()) {
        Text(
            text = "Choose App Icon",
            modifier = Modifier.padding(10.dp),
            fontWeight = FontWeight.Bold,
            fontStyle = FontStyle.Normal,
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.padding(top = 10.dp))
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(iconList()) {
                IconsView(icon = it)
            }
        }
    }
}

@Composable
fun IconsView(icon: Icon) {
    val context = LocalContext.current
    var isDialogVisible by remember {
        mutableStateOf(false)
    }
    val backgroundBrush = if (icon.free) {
        Brush.horizontalGradient(
            colors = listOf(
                colorResource(id = R.color.light_blue),
                colorResource(id = R.color.light_blue)
            )
        )
    } else {
        Brush.horizontalGradient(
            colors = listOf(
                Color(0xFFF9F29F), // Light gold
                Color(0xFFE0AA23), // Middle gold
                Color(0xFFFFF8F8)
            )
        )
    }

    Card(
        modifier = Modifier
            .padding(10.dp)
            .clip(RoundedCornerShape(12.dp))
            .fillMaxWidth()
            .height(100.dp),
    ) {
        Box(
            modifier = Modifier
                .fillMaxSize()
                .background(backgroundBrush)
                .padding(10.dp)
                .clickable {
                    if (!icon.free) {
                        isDialogVisible = true
                    } else {
                        Toast
                            .makeText(context, "icon set", Toast.LENGTH_SHORT)
                            .show()
                    }
                },
            contentAlignment = Alignment.Center
        ) {

            Image(
                painter = painterResource(id = icon.icon),
                contentDescription = "image",
                modifier = Modifier
                    .width(200.dp)
                    .height(200.dp)
                    .padding(10.dp),
            )


        }
    }

    if (isDialogVisible) {
        PremiumDialog {
            isDialogVisible = it
        }
    }
}

fun openDialog() {
    TODO("Not yet implemented")
}

fun iconList(): List<Icon> {
    val list = mutableListOf<Icon>()
    list.add(Icon("ch1", 1, R.drawable.tiktok, true))
    list.add(Icon("ch1", 2, R.drawable.facebook, false))
    list.add(Icon("ch1", 3, R.drawable.logo, true))
    list.add(Icon("ch1", 4, R.drawable.instagram, true))
    list.add(Icon("ch1", 5, R.drawable.snapchat, true))
    list.add(Icon("ch1", 6, R.drawable.mushroom, false))
    list.add(Icon("ch1", 7, R.drawable.airbnb, true))
    list.add(Icon("ch1", 8, R.drawable.airbnb2, false))
    list.add(Icon("ch1", 9, R.drawable.house, false))
    return list
}