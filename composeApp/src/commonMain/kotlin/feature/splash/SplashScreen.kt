package feature.splash

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentHeight
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
fun SplashScreen(navAction: (SplashAction) -> Unit) {

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
            Box(
                modifier = Modifier
                    .size(200.dp)
                    .background(MaterialTheme.colorScheme.secondaryContainer)
                    .wrapContentHeight(align = Alignment.CenterVertically)
            ) {
                Text(
                    modifier = Modifier.fillMaxWidth(),
                    text = "Logo",
                    textAlign = TextAlign.Center,
                    fontSize = 32.sp,
                    fontWeight = FontWeight.Bold,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }

        CommonActionButton(
            modifier = Modifier.fillMaxWidth(),
            text = "Login",
            enabled = true,
            onClick = { navAction(SplashAction.OpenLoginScreen) }
        )
    }
}
