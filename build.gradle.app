apply plugin: 'com.android.application'

android {
    compileSdkVersion 30
    buildToolsVersion "30.0.2"

    defaultConfig {
        applicationId "com.roiding.rterm"
        minSdkVersion 21
        targetSdkVersion 21
        versionCode 1
        versionName "1.2.1"
    }

    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android.txt'), 'proguard-rules.txt'
        }
    }
}

task wrapper(type: Wrapper){
    gradleVersion = '4.1.2'
}

dependencies {
    implementation 'androidx.appcompat:appcompat:1.2.0'
}
