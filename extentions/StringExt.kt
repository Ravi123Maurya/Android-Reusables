

fun String.capitalizeFirst() = replaceFirstChar { it.upperCase() }
fun String.takeFirstTwo() = take(2)

fun String.isEmailValid() = android.util.Patterns.EMAIL_ADDRESS.matcher(this).matches()

