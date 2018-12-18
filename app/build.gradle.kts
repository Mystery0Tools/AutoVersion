plugins {
	id("com.android.application")
}

android {
	compileSdkVersion(28)
	defaultConfig {
		applicationId = "vip.mystery0.simple_autoversion"
		minSdkVersion(14)
		versionCode = 1
		versionName = "1.0"
		testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
	}

	buildTypes {
		getByName("release") {
			isMinifyEnabled = false
			proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
		}
	}
}

dependencies {
	implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))
	implementation("androidx.appcompat:appcompat:1.0.2")
	testImplementation("junit:junit:4.12")
	androidTestImplementation("com.android.support.test:runner:1.1.1")
	androidTestImplementation("androidx.test.espresso:espresso-core:3.1.1")
}