buildscript {
	val kotlinVersion = "1.3.11"
	repositories {
		google()
		jcenter()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:3.3.0")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
		classpath("com.novoda:bintray-release:0.9")
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