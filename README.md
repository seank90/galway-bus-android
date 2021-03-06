### Android Galway Bus app using Kotlin/Architecture Components/Clean Architecture


[![Get it on Google Play](https://play.google.com/intl/en_us/badges/images/generic/en-play-badge.png)](https://play.google.com/store/apps/details?id=com.surrus.galwaybus)


This was created as part of effort to get more familiar with developing Android apps using 
Kotlin and the new [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html),
and also to explore use of the increasingly popular [Clean Architecture](https://8thlight.com/blog/uncle-bob/2012/08/13/the-clean-architecture.html) approach. It's heavily based on https://github.com/bufferapp/clean-architecture-components-boilerplate. 
This is stil work in progress and also, at least for now,
 have omitted formal `Mapper` classes (though some data model translation does occur between the layers).

As I'm pretty new to Kotlin and some of the libraries used I'm sure 
there are better ways of implementing some of the code I have so feedback (and PRs!)
are very welcome.  I also continue to incorporate changes based on articles and other
repos I come across.  

Note also that this is using [REST endpoint](https://github.com/appsandwich/galwaybus) provided by @appsandwich to retrieve
 Galway Bus route/timetable info  (Thanks Vinny!)



### Use of Clean Architecture

For an app of this size and complexity it can be argued that full use
 of Clean Architecture abstractions is overkill....at least right now method implementations 
 in many of the layers simply delegate to corresponding method in layer below (though
 starting to see a few exceptions to that).
A reasonable approach for an app like this might be, for example, to have `ViewModel` 
implementations interact directly with the `Repository`.  In either case,
 a key important benefit of this architecture is that code below the UI layer should not have 
 any dependencies on Android framework and can be easily unit tested.


### Kotlin Multiplatform

More recently I've also been using this project to explore some of the relatively new Kotlin Multiplatform
capabilities.  There is now **kotlin-multiplatform** `ShareCode` module for example and some sample iOS apps in `ios` folder. Have also 
written a couple of post about some of my experiences doing this so far

* [SwiftUI meets Kotlin Multiplatform!](https://johnoreilly.dev/2019/06/08/swiftui-meetings-kotlin-multiplatform.html)
* [Introduction to Multiplatform Persistence with SQLDelight](https://johnoreilly.dev/posts/sqldelight-multiplatform/)


### Languages, libraries and tools used

* [Kotlin](https://kotlinlang.org/)
* [Kotlin Corooutines](https://kotlinlang.org/docs/reference/coroutines-overview.html)
* [Room](https://developer.android.com/topic/libraries/architecture/room.html)
* [Android Architecture Components](https://developer.android.com/topic/libraries/architecture/index.html)
* [Android Support Libraries](https://developer.android.com/topic/libraries/support-library/index.html)
* [Koin](https://github.com/InsertKoinIO/koin)
* [Retrofit](http://square.github.io/retrofit/)
* [OkHttp](http://square.github.io/okhttp/)
* [Gson](https://github.com/google/gson)
* [Logger](https://github.com/orhanobut/logger)
* [PdfViewPager](https://github.com/voghDev/PdfViewPager)
* [Mockito](http://site.mockito.org/)
* [MockWebServer](https://github.com/square/okhttp/tree/master/mockwebserver)
* [Stetho](https://github.com/facebook/stetho)
