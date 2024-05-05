API Response Wrapper to Reduce Boilerplate by creating single sealed class to manage API Response State.
Copied from [Stevdza-san](https://github.com/stevdza-san)'s [gist](https://gist.github.com/stevdza-san/cca20eff9f2c4c7d783ffd0a0061b352). 

So You don't have to copy them again from the gist, just add this library to your dependency:

### Add jitpack to your settings.gradle
```Kotlin
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
        maven("https://jitpack.io") // This line
    }
}
```

### And the library implementation to your build.gradle
[![](https://jitpack.io/v/rmaprojects/apiresponsewrapper.svg)](https://jitpack.io/#rmaprojects/apiresponsewrapper)
#### TOML (Latest Android Studio Version [Iguana And Above]):
```toml
[version]
apiresponsewrapper = "<latest version here>"

[libraries]
apiResponseWrapper = { module = "com.github.rmaprojects:apiresponsewrapper", version.ref = "apiresponsewrapper" }

```
```Kotlin
‎ 
implementation(libs.apiResponseWrapper)
‎ 
```
#### gradle.kts:
```Kotlin
‎ 
implementation("com.github.rmaprojects:apiresponsewrapper:<latest version here>")
‎ 
```

# Example:
See more on [samples](https://github.com/rmaprojects/apiresponsewrapper/tree/main/sample/src/main)
## Before:
```Kotlin
    val homeScreenState by viewModel.homeScreeState.collectAsState(initial = HomeScreenState.Idle)
    when (homeScreenState) {
        is HomeStates.Error -> {
          // Your UI
        }
        is HomeStates.Loading -> {
          // Your UI
        }
        is HomeStates.Success -> {
          // Your UI
        }
    }
```
## After:
```Kotlin
    val data = viewModel.data.collectAsState(initial = ResponseState.Idle)
    data.value.DisplayResult(
       onLoading = {
        //Put your UI Here
      },
        onSuccess = { data ->
        //Put your UI Here
      },
        onError = { errorMessage ->
        //Put your UI Here
      }
    )
  //You can check wether the response is Success or Error outside of DisplayResult scope:
  val checkIfError = data.value.isError()
  val checkIfSuccess = data.value.isSuccess()

```
