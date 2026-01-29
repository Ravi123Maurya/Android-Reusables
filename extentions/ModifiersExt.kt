
// Padding Extentions
fun Modifier.paddingAll(value: Dp) = this.padding(value)
fun Modifier.paddingHorizontal(value: Dp) = this.padding(horizontal = value)
fun Modifier.paddingVertical(value: Dp) = this.padding(vertical = value)


// Rounded Corners
fun Modifier.circleClip() = this.clip(CircleShape)

// Clickable without Ripple
fun Modifier.clickableNoRipple(onClick: () -> Unit): Modifier{
    return this.clickable(
        indication = null,
        interactionSource = remember{ MutableInteractionSource() },
        onClick = onClick
    )
}

// Spacers
fun Modifier.heightSpacer(height: Dp) = this.padding(vertical = height)
fun Modifier.widthSpacer(width: Dp) = this.padding(horizontal = width)

// Debugging helper (adds red background to visualize layout bounds)
fun Modifier.debugBounds() = this.background(Color.Red.copy(alpha = 0.2f))