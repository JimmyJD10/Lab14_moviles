package com.example.lab14

import android.content.Context
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp
import androidx.glance.GlanceId
import androidx.glance.GlanceModifier
import androidx.glance.GlanceTheme
import androidx.glance.appwidget.GlanceAppWidget
import androidx.glance.appwidget.provideContent
import androidx.glance.layout.Alignment
import androidx.glance.layout.Column
import androidx.glance.layout.Row
import androidx.glance.layout.fillMaxSize
import androidx.glance.layout.padding
import androidx.glance.text.Text
import androidx.glance.Button
import androidx.glance.action.actionStartActivity

class SimpleFitnessWidget : GlanceAppWidget() {
    override suspend fun provideGlance(context: Context, id: GlanceId) {
        provideContent {
            GlanceTheme {
                SimpleFitnessWidgetContent()
            }
        }
    }

    @Composable
    private fun SimpleFitnessWidgetContent() {
        Column(
            modifier = GlanceModifier
                .fillMaxSize()
                .padding(16.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(text = "Resumen de Fitness")

            Row(modifier = GlanceModifier.padding(bottom = 12.dp)) {
                Text(text = "Calorías quemadas: 320 kcal | Pasos: 8500")
            }

            Row(modifier = GlanceModifier.padding(bottom = 12.dp)) {
                Button(text = "Inicio", onClick = actionStartActivity<MainActivity>())
                Button(text = "Entrenamiento", onClick = actionStartActivity<ProgressActivity>())
                Button(text = "Estadísticas", onClick = actionStartActivity<SettingsActivity>())
            }

            Column(modifier = GlanceModifier.padding(top = 12.dp)) {
                Text(text = "Últimas acciones:")
                Text(text = "- 5 km de carrera completados")
                Text(text = "- Meta alcanzada: 10,000 pasos")
            }
        }
    }
}
