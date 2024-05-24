apply(plugin = "maven-publish")
apply(plugin = "signing")


//val sourcesJar by tasks.register(Jar::class) {
//
//}


//def androidSourcesJar(Jar::class) {
//    from android.sourceSets.main.java.source
//    from android.sourceSets.main.kotlin.source
//    classifier("sources")
//}

apply(from = "../local.gradle.kts")

//project.publishing {
//    publications {
//        release(MavenPublication) {
//            // The coordinates of the library, being set from variables that
//            // we'll set up in a moment
//            groupId GROUP_ID
//            artifactId COMPOSE_CHARTS_ARTIFACT_ID
//            version COMPOSE_CHARTS_VERSION
//
//            // Two artifacts, the `aar` and the sources
//            artifact("$buildDir/outputs/aar/${project.getName()}-release.aar")
//            artifact androidSourcesJar
//
//            // Self-explanatory metadata for the most part
//            pom {
//                name = COMPOSE_CHARTS_ARTIFACT_ID
//                description = COMPOSE_CHARTS_POM_DESCRIPTION
//                // If your project has a dedicated site, use its URL here
//                url = POM_URL
//                licenses {
//                    license {
//                        //协议类型，一般默认Apache License2.0的话不用改：
//                        name = LICENSE_NAME
//                        url = LICENSE_URL
//                    }
//                }
//                developers {
//                    developer {
//                        id = DEVELOPER_ID
//                        name = DEVELOPER_NAME
//                        email = DEVELOPER_EMAIL
//                    }
//                }
//                // Version control info, if you're using GitHub, follow the format as seen here
//                scm {
//                    //修改成你的Git地址：
//                    connection = SCM_CONNECTION
//                    developerConnection = SCM_DEVELOPER_CONNECTION
//                    //分支地址：
//                    url = SCM_URL
//                }
//                // A slightly hacky fix so that your POM will include any transitive dependencies
//                // that your library builds upon
//                withXml {
//                    def dependenciesNode = asNode().appendNode('dependencies')
//
//                    project.configurations.implementation.allDependencies.each {
//                        def dependencyNode = dependenciesNode.appendNode('dependency')
//                        dependencyNode.appendNode('groupId', it.group)
//                        dependencyNode.appendNode('artifactId', it.name)
//                        dependencyNode.appendNode('version', it.version)
//                    }
//                }
//            }
//        }
//    }
//    repositories {
//        // The repository to publish to, Sonatype/MavenCentral
//        maven {
//            // This is an arbitrary name, you may also use "mavencentral" or
//            // any other name that's descriptive for you
//            name = "compose-charts"
//
//            // You only need this if you want to publish snapshots, otherwise just set the URL
//            // to the release repo directly
//            url = version.endsWith('SNAPSHOT') ? SNAPSHOTS_REPO_URL : RELEASES_REPO_URL
//
//            // The username and password we've fetched earlier
//            credentials {
//                username ossrhUsername
//                password ossrhPassword
//            }
//        }
//    }
//}
//signing {
//    sign publishing.publications
//}