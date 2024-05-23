import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import navigation.AppNavGraph
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    MaterialTheme {
        AppNavGraph()
    }
}
