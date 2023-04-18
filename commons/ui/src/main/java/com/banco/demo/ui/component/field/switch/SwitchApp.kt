package com.banco.demo.ui.component.field.switch

import androidx.compose.foundation.layout.size
import androidx.compose.material.Icon
import androidx.compose.material.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.banco.demo.ui.R
import com.banco.demo.ui.theme.PrimaryPurpleDarkest

@Composable
fun SwitchApp(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {

    IconButton(
        modifier = modifier,
        onClick = {
            if (onCheckedChange != null) onCheckedChange(!checked)
        }
    ) {
        Icon(
            modifier = Modifier.size(width = 24.dp, height = 16.dp),
            painter = painterResource(id = if (checked) R.drawable.ic_switch_checked else R.drawable.ic_switch_unchecked),
            contentDescription = "Icon switch",
            tint = PrimaryPurpleDarkest
        )
    }
}