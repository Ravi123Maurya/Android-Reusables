

import androidx.compose.foundation.ScrollState
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.statusBars
import androidx.compose.material.ContentAlpha
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawWithContent
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.unit.Dp



/**
 * A composable layout that draws a translucent status bar background
 * which gradually animates its opacity based on scroll position.
 *
 * @param scrollState The scroll state used to determine how far the user has scrolled.
 * @param modifier Optional [Modifier] for customizing layout behavior.
 * @param distanceUntilAnimated The scroll distance before the status bar reaches full opacity.
 * @param targetAlpha The maximum alpha value applied to the status bar color.
 * @param targetColor The background color of the status bar overlay.
 * @param content The UI content displayed inside the layout.
 *
 * Usage:
 * Wrap your screen content with [TranslucentStatusBarLayout] to have
 * a fading status bar effect that reacts to scrolling.
 */
@Composable
@Suppress("LongParameterList")
fun TranslucentStatusBarLayout(
    scrollState: ScrollState,
    modifier: Modifier = Modifier,
    distanceUntilAnimated: Dp = 100.dp,
    targetAlpha: Float = ContentAlpha.medium,
    targetColor: Color = MaterialTheme.colorScheme.background,
    content: @Composable () -> Unit
) {
    val distanceUntilAnimatedPx = with(LocalDensity.current) { distanceUntilAnimated.toPx() }
    val statusBarInsets = WindowInsets.statusBars
    Box(
        Modifier
            .drawWithContent {
                drawContent()
                drawRect(
                    color = targetColor.copy(
                        alpha = targetAlpha * if (scrollState.value < distanceUntilAnimatedPx) {
                            scrollState.value.toFloat() / distanceUntilAnimatedPx
                        } else 1f
                    ),
                    size = Size(
                        width = size.width,
                        height = statusBarInsets
                            .getTop(this)
                            .toFloat()
                    )
                )
            }
            .then(modifier)
    ) {
        content()
    }
}