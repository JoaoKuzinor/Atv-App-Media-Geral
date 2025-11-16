package com.joaolima.atvmediageral.ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.joaolima.atvmediageral.ui.model.Aluno
import com.joaolima.atvmediageral.ui.theme.AtvMediaGeralTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AtvMediaGeralTheme {
                TelaCalculoAluno()
            }
        }
    }
}

@Composable
fun TelaCalculoAluno() {

    var nome by remember { mutableStateOf("") }
    var tp1 by remember { mutableStateOf("") }
    var tp2 by remember { mutableStateOf("") }
    var tp3 by remember { mutableStateOf("") }

    var resultado by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Text(
            "Cálculo de Média do Aluno",
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Card(
            modifier = Modifier.fillMaxWidth(),
            elevation = CardDefaults.cardElevation(8.dp)
        ) {
            Column(
                modifier = Modifier
                    .padding(18.dp),
                verticalArrangement = Arrangement.spacedBy(14.dp)
            ) {

                OutlinedTextField(
                    value = nome,
                    onValueChange = { nome = it },
                    label = { Text("Nome do aluno", fontSize = 18.sp) },
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = tp1,
                    onValueChange = { tp1 = it },
                    label = { Text("Nota TP1", fontSize = 18.sp) },
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = tp2,
                    onValueChange = { tp2 = it },
                    label = { Text("Nota TP2", fontSize = 18.sp) },
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    modifier = Modifier.fillMaxWidth()
                )

                OutlinedTextField(
                    value = tp3,
                    onValueChange = { tp3 = it },
                    label = { Text("Nota TP3", fontSize = 18.sp) },
                    textStyle = LocalTextStyle.current.copy(fontSize = 18.sp),
                    modifier = Modifier.fillMaxWidth()
                )

                Button(
                    onClick = {
                        if (nome.isBlank()) {
                            resultado = "⚠ Informe o nome do aluno!"
                            return@Button
                        }

                        val notas = mutableListOf<Double>()

                        try {
                            if (tp1.isNotBlank()) {
                                val nota = tp1.toDouble()
                                if (nota < 0 || nota > 10) throw Exception("Nota TP1 inválida!")
                                notas.add(nota)
                            }

                            if (tp2.isNotBlank()) {
                                val nota = tp2.toDouble()
                                if (nota < 0 || nota > 10) throw Exception("Nota TP2 inválida!")
                                notas.add(nota)
                            }

                            if (tp3.isNotBlank()) {
                                val nota = tp3.toDouble()
                                if (nota < 0 || nota > 10) throw Exception("Nota TP3 inválida!")
                                notas.add(nota)
                            }

                            val aluno = Aluno(nome, notas)
                            val mediaFormatada = String.format("%.2f", aluno.media())

                            resultado = "Média: $mediaFormatada\nStatus: ${aluno.status()}"

                            nome = ""
                            tp1 = ""
                            tp2 = ""
                            tp3 = ""

                        } catch (e: Exception) {
                            resultado = "⚠ Erro: ${e.message}"
                        }

                    },
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        contentColor = Color.Black
                    )
                ) {
                    Text("CALCULAR", fontSize = 20.sp, color = Color.Black)
                }
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        if (resultado.isNotEmpty()) {
            Text(
                resultado,
                fontSize = 22.sp,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )
        }
    }
}
