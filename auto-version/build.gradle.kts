import org.jetbrains.kotlin.gradle.tasks.KotlinCompile

plugins {
	id("groovy")
	id("maven")
}

dependencies {
	compile(gradleApi())
	compile(localGroovy())
}

repositories {
	mavenCentral()
}
apply(from = "../push.gradle")