plugins {
    id("com.android.application")
    id("org.jetbrains.kotlin.android")
    id("com.google.gms.google-services")

}

android {
    namespace = "com.example.valorantx"
    compileSdk = 34

    defaultConfig {
        applicationId = "com.example.valorantx"
        minSdk = 24
        targetSdk = 34
        versionCode = 2
        versionName = "2.0"

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    // ViewBinding
    viewBinding{
        enable = true
    }

}

dependencies {
    val nav_version = "2.7.4"

    implementation ("androidx.appcompat:appcompat:1.3.0")


    implementation("androidx.core:core-ktx:1.12.0")
    implementation("androidx.appcompat:appcompat:1.6.1")
    implementation("com.google.android.material:material:1.10.0")
    implementation("androidx.constraintlayout:constraintlayout:2.1.4")

    // Navegation Component
    implementation("androidx.navigation:navigation-fragment-ktx:$nav_version")
    implementation("androidx.navigation:navigation-ui-ktx:$nav_version")

    // Splash
    implementation("androidx.core:core-splashscreen:1.0.1")
    implementation("androidx.preference:preference-ktx:1.2.1")
    implementation("androidx.core:core-splashscreen:1.0.0-rc01")

    testImplementation("junit:junit:4.13.2")
    androidTestImplementation("androidx.test.ext:junit:1.1.5")
    androidTestImplementation("androidx.test.espresso:espresso-core:3.5.1")

    // Lottie
    implementation("com.airbnb.android:lottie:3.4.2")

    // Glide
    implementation("com.github.bumptech.glide:glide:4.12.0")
    implementation("com.github.bumptech.glide:compiler:4.12.0")

    //FIREBASE
    implementation(platform("com.google.firebase:firebase-bom:32.5.0"))
    implementation("com.google.firebase:firebase-firestore")
    implementation("com.google.firebase:firebase-analytics")
    implementation("com.google.firebase:firebase-auth-ktx:22.2.0")




}