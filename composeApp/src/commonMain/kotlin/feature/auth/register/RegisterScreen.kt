package feature.auth.register

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import core.CommonActionButton


@Composable
fun RegisterScreen(navAction: (RegisterAction) -> Unit) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    ) {

        Column(
            modifier = Modifier.fillMaxWidth().weight(1f),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "RegisterScreen",
                textAlign = TextAlign.Center,
                fontSize = 32.sp,
                fontWeight = FontWeight.Bold,
                color = MaterialTheme.colorScheme.secondary
            )
        }

        CommonActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Back",
            enabled = true,
            onClick = { navAction(RegisterAction.Back) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CommonActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Forgot",
            enabled = true,
            onClick = { navAction(RegisterAction.OpenForgotScreen) }
        )

        Spacer(modifier = Modifier.height(8.dp))

        CommonActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Main",
            enabled = true,
            onClick = { navAction(RegisterAction.OpenMainScreen) }
        )
    }
}