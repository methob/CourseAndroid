package com.br.teste_catho.data.remote.helper

@Target(AnnotationTarget.FUNCTION, AnnotationTarget.ANNOTATION_CLASS)
@Retention(AnnotationRetention.RUNTIME)
annotation class SetKeyHeader(
    val value: String
)