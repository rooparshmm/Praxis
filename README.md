# Praxis

This is a sample app written in Kotlin which fetches random jokes and displays it. This app has the following components

 - MVVM architecture
 - AndroidX libraries
 - Android Architecture components
 - Android Data Binding
 - DaggerAndroid
 - Retrofit
 - RXJava2
 - Kotlin Coroutines

The purpose of this app is to show how:

 - To implement Jetpack Android Architecture components with Dagger Android and Data Binding to minimize boiler plate code
 - Retrofit can be used with RxJava2 and Coroutines along with GSON
 - To create proper components and Subcomponents using Dagger Android and injecting into Activity, Fragment, View Models and Helper Classes
 - To use Coroutines to do background tasks

This project can be used as a template for new apps.
This project is continually evolving to integrate other libraries and techniques to keep it up to date.


 For Using GraphQL
 - ext.apolloVersion = '2.5.2'
 - classpath("com.apollographql.apollo:apollo-gradle-plugin:$apolloVersion")  -> In app build.gradle
 - apply plugin: "com.apollographql.apollo"
 - // Apollo Graphql
  implementation "com.apollographql.apollo:apollo-runtime:$apolloVersion"
  implementation "com.apollographql.apollo:apollo-coroutines-support:$apolloVersion"

  For downloading schema
  gradle  downloadApolloSchema --endpoint="https://apollo-fullstack-tutorial.herokuapp.com/graphql"  --schema="networkmodule/src/main/graphql/com/mutualmobile/praxis/schema.json"

