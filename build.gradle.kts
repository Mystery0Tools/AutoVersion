buildscript {
	val kotlinVersion = "1.3.11"
	repositories {
		google()
		jcenter()
		maven("https://jitpack.io")
	}
	dependencies {
		classpath("com.android.tools.build:gradle:3.3.0-rc02")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("com.github.Mystery0Tools:AutoVersion:1.0.2")
	}
}

allprojects {
	repositories {
		google()
		jcenter()
	}
}

task("clean", Delete::class) {
	delete = setOf(rootProject.buildDir)
}