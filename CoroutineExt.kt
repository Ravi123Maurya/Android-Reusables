
fun CoroutineScope.launchIO(block: suspend () -> Unit) = 
    this.launch(Dispatchers.IO){ block() }

fun CoroutineScope.launchMain(block: suspend () -> Unit) = 
    this.launch(Dispatchers.Main){ block() }

fun CoroutineScope.launchDefault(block: suspend () -> Unit) = 
    this.launch(Dispatchers.Default){ block() }