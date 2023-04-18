package com.banco.demo.ui.component.field.checkbox

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.banco.demo.ui.R

@Composable
fun CheckboxApp(
    modifier: Modifier = Modifier,
    checked: Boolean,
    onCheckedChange: ((Boolean) -> Unit)?,
) {


    Image(
        modifier = modifier.clickable {
            if (onCheckedChange != null) onCheckedChange(!checked)
        },
        painter = painterResource(id = if (checked) R.drawable.ic_checkbox_checked else R.drawable.ic_checkbox_unchecked),
        contentDescription = "Checkbox"

    )


}