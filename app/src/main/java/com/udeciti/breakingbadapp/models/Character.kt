package com.udeciti.breakingbadapp.models

class Character(
    val char_id: Int,
    val name: String,
    val birthday: String?,
    val occupation: Array<String>?,
    val img: String?,
    val status: String?,
    val appearance: Array<Int>?,
    val nickname: String?,
    val portrayed: String?,
    val better_call_saul_appearance: Array<Int>?
) {
}