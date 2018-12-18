buildscript {
	val kotlinVersion = "1.3.11"
	repositories {
		google()
		jcenter()
	}
	dependencies {
		classpath("com.android.tools.build:gradle:3.3.0-rc02")
		classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
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