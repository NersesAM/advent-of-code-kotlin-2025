plugins {
    kotlin("jvm") version "2.2.21"
}

sourceSets {
    main {
        kotlin.srcDir("src")
    }
}

tasks {
    wrapper {
        gradleVersion = "9.2.1"
    }
}


java {
  sourceCompatibility = JavaVersion.VERSION_24
  targetCompatibility = JavaVersion.VERSION_24
}

//kotlin {
//  compilerOptions {
//    freeCompilerArgs.add("-Xnon-local-break-continue")
//  }
//}

//dependencies {
//  implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.9.0")
//}
