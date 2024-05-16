// Top-level build file where you can add configuration options common to all sub-projects/modules.

plugins {
  alias(libs.plugins.android.application) apply false
  alias(libs.plugins.jetbrains.kotlin.android) apply false
  alias(libs.plugins.android.library) apply false
}

extra["GROUP_ID"] = "io.github.bytebeats"
extra["DEVELOPER_ID"] = "bytebeats"
extra["DEVELOPER_NAME"] = "Chen Pan"
extra["DEVELOPER_EMAIL"] = "happychinapc@gmail.com"
extra["SCM_CONNECTION"] = "scm:git:github.com/bytebeats/compose-charts.git"
extra["SCM_DEVELOPER_CONNECTION"] = "scm:git:ssh:github.com/bytebeats/compose-charts.git"
extra["SCM_URL"] = "https://github.com/bytebeats/compose-charts/tree/master"
extra["LICENSE_NAME"] = "The Apache License, Version 2.0"
extra["LICENSE_URL"] = "http://www.apache.org/licenses/LICENSE-2.0.txt"
extra["POM_URL"] = "https://github.com/bytebeats/compose-charts"
extra["RELEASES_REPO_URL"] = "https://s01.oss.sonatype.org/service/local/staging/deploy/maven2/"
extra["SNAPSHOTS_REPO_URL"] = "https://s01.oss.sonatype.org/content/repositories/snapshots/"
