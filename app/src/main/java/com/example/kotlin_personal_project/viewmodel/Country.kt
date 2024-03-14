package com.example.kotlin_personal_project.viewmodel

data class Success(val todos: List<Country>)

data class Country(
    var name: Name,
    var unMember: Boolean,
    var capital: List<String>,
    var flags: Flags,
    var region: String,
    var area: Float,
    var population: Int,
    )
data class Name (
    var official: String,
)
data class Flags (
    var png: String,
    var alt: String,
)