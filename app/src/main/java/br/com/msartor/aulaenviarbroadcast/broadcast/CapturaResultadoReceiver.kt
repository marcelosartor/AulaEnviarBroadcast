package br.com.msartor.aulaenviarbroadcast.broadcast

import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import android.util.Log

class CapturaResultadoReceiver : BroadcastReceiver() {

    override fun onReceive(context: Context, intent: Intent) {
        var initialCode = resultCode
        var initialData = resultData
        var extras = getResultExtras(true)
        var dadosExtras = extras.getString("DadosExtras")

        val textoParametro = "[CapturaResultado] Code: $initialCode - Data: $initialData - Extras: $dadosExtras"
        Log.i("broadcast_android", textoParametro)
    }
}