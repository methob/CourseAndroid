package com.br.teste_catho.data.local.mapper

import com.br.teste_catho.data.local.entity.KeysTb
import com.br.teste_catho.data.local.entity.UserTb
import com.br.teste_catho.data.remote.entity.Keys
import com.br.teste_catho.data.remote.entity.User

fun UserTb?.convertToUserModel() =
    User().also {
        this?.apply {
            it.id = id
            it.name = name
            it.photo = photo
            it.token = token
        }
    }

fun KeysTb?.convertToKeysModel() =
    Keys().also {
        this?.apply {
            it.auth = auth
            it.suggestion = suggestion
            it.survey = survey
            it.tips = tips
        }
    }

fun Keys.convertToKeysTB() = KeysTb().also {
    it.auth = auth
    it.suggestion = suggestion
    it.survey = survey
    it.tips = tips
}

fun User.convertToUserTB() = UserTb().also {
    it.id = id
    it.name = name
    it.photo = photo
    it.token = token
}