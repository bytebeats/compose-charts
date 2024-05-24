//val signingPropertyKeys by listOf(
//    "signing.keyId",
//    "signing.password",
//    "signing.secretKeyRingFile",
//    "ossrhUsername",
//    "ossrhPassword"
//)

//extra["signing.keyId"] = ""
//extra["signing.password"] = ""
//extra["signing.secretKeyRingFile"] = ""
//extra["ossrhUsername"] = ""
//extra["ossrhPassword"] = ""


//val secretPropsFile = project.rootProject.file("local.properties")
//if (secretPropsFile.exists()) {
//    println("Found secret props file, loading props")
//    val p = Properties()
//    p.load(FileInputStream(secretPropsFile))
//    p.each { name, value ->
//        extra[name] = value
//    }
//} else {
//    println("No props file, loading env vars")
//}

//val fis = FileInputStream("local.properties")
//val properties = Properties().apply {
//    load(fis)
//}
//val ossUser = properties.getProperty("oss.user")
//val ossPassword = properties.getProperty("oss.password")
//extra["signing.keyId"] = properties.getProperty("signing.keyId")
//extra["signing.password"] = properties.getProperty("signing.password")
//extra["signing.secretKeyRingFile"] = properties.getProperty("signing.secretKeyRingFile")