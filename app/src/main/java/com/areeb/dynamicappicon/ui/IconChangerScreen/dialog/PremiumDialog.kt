package com.areeb.dynamicappicon.ui.IconChangerScreen.dialog

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.paddingFrom
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.areeb.dynamicappicon.R

@Composable
fun PremiumDialog(showDialog: (Boolean) -> Unit) {
    Dialog(
        onDismissRequest = { showDialog(false) },
        properties = DialogProperties(dismissOnBackPress = true, dismissOnClickOutside = true)
    ) {
        Surface(
            shape = RoundedCornerShape(12.dp),
            color = colorResource(id = R.color.white),
            modifier = Modifier.padding(20.dp)
        ) {
            Text(
                text = "Please Subscribe the App to use  premium features",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(20.dp)
            )
        }
    }
}