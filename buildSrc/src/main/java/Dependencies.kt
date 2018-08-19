
object Versions {

  const val kotlin = "1.2.30"
  const val minSDK = 21
  const val compileSDK = 27
  const val targetSDK = 27
  const val versionCode = 1
  const val versionName = "1.0"
  const val androidSupport = "27.1.1"
  const val retrofitVersion = "2.4.0"
  const val daggerVersion = "2.16"
  const val rxAndroidVersion = "2.0.2"
  const val rxJavaVersion = "2.1.16"
  const val mockitoVersions = "2.20.1"
  const val constraintLayoutVersion = "1.1.2"
  const val junitVersion = "4.12"
}

object Deps {

  const val kotlinStandardLib = "org.jetbrains.kotlin:kotlin-stdlib-jre7:${Versions.kotlin}"
  const val appCompat = "com.android.support:appcompat-v7:${Versions.androidSupport}"
  const val recyclerView = "com.android.support:recyclerview-v7:${Versions.androidSupport}"
  const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofitVersion}"
  const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofitVersion}"
  const val retrofitConverters = "com.squareup.retrofit2:retrofit-converters:${Versions.retrofitVersion}"
  const val dagger = "com.google.dagger:dagger:${Versions.daggerVersion}"
  const val daggerCompiler = "com.google.dagger:dagger-compiler:${Versions.daggerVersion}"
  const val rxAndroid = "io.reactivex.rxjava2:rxandroid:${Versions.rxAndroidVersion}"
  const val rxJava = "io.reactivex.rxjava2:rxjava:${Versions.rxJavaVersion}"
  const val mockito = "org.mockito:mockito-core:${Versions.mockitoVersions}"
  const val constraintLayout = "com.android.support.constraint:constraint-layout:${Versions.constraintLayoutVersion}"
  const val junit = "junit:junit:${Versions.junitVersion}"



}