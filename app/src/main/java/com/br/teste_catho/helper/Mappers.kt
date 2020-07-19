package com.br.teste_catho.helper

import com.br.teste_catho.data.remote.entity.RemoteError
import com.br.teste_catho.model.ViewError

fun RemoteError.toViewError(): ViewError = ViewError(this.message)