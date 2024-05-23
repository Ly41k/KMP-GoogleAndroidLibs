package core

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Stable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.unit.dp


@[Stable Composable]
fun CommonOutlinedTextField(
    modifier: Modifier,
    text: String,
    hint: String,
    placeholder: String = "",
    enabled: Boolean = true,
    isSecure: Boolean = false,
    isError: Boolean = false,
    errorMessage: String = "",
    keyboardType: KeyboardType = KeyboardType.Password,
    trailingIcon: @Composable () -> Unit = {},
    onValueChanged: (String) -> Unit
) {
    OutlinedTextField(
        modifier = modifier,
        value = text,
        singleLine = true,
        colors = DefaultOutlinedTextFieldTheme(),
        visualTransformation = if (isSecure) PasswordVisualTransformation() else VisualTransformation.None,
        label = { Label(hint) },
        placeholder = { Label(placeholder) },
        shape = RoundedCornerShape(10.dp),
        trailingIcon = { trailingIcon.invoke() },
        isError = isError,
        supportingText = { SupportingText(isError, errorMessage) },
        enabled = enabled,
        onValueChange = { onValueChanged(it) },
        keyboardOptions = KeyboardOptions(keyboardType = keyboardType)
    )
}

@[Stable Composable]
private fun SupportingText(isError: Boolean, errorMessage: String) {
    if (isError) {
        Text(
            modifier = Modifier.fillMaxWidth(),
            text = errorMessage,
            style = MaterialTheme.typography.labelSmall,
            color = MaterialTheme.colorScheme.error
        )
    }
}

@[Stable Composable]
private fun Label(hint: String) {
    Text(text = hint, color = MaterialTheme.colorScheme.secondary)
}

@[Stable Composable]
fun DefaultOutlinedTextFieldTheme() = OutlinedTextFieldDefaults.colors(
    focusedTextColor = MaterialTheme.colorScheme.primary,
    unfocusedTextColor = MaterialTheme.colorScheme.primary,
    focusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
    unfocusedContainerColor = MaterialTheme.colorScheme.primaryContainer,
    cursorColor = MaterialTheme.colorScheme.secondary,
    disabledBorderColor = MaterialTheme.colorScheme.secondaryContainer,
    focusedBorderColor = MaterialTheme.colorScheme.secondary,
    errorBorderColor = MaterialTheme.colorScheme.error,
    unfocusedBorderColor = MaterialTheme.colorScheme.secondaryContainer
)
