package com.joaolima.atvmediageral.ui.model

data class Aluno(
    var nome: String,
    var notas: MutableList<Double> = mutableListOf()
) {
    fun media(): Double {
        return if (notas.isNotEmpty()) notas.sum() / notas.size else 0.0
    }

    fun status(): String {
        val m = media()
        return when {
            m < 6.0 -> "Reprovado"
            m <= 9.0 -> "Aprovado"
            else -> "Ótimo Aproveitamento"
        }
    }
}

