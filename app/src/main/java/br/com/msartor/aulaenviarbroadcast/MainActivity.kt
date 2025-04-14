package br.com.msartor.aulaenviarbroadcast

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import br.com.msartor.aulaenviarbroadcast.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private val binding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        binding.btnAbrirPdf.setOnClickListener {
            Log.i("ComunicacaoBroadcastReceiver", "ComunicacaoBroadcastReceiver clicou no botao ")
            val intent = Intent("br.com.msartor.aulaservice.ABRIR_ARQUIVO_PDF")
            val bundle = Bundle()
            bundle.putString("ARQUIVO","arquivo/perfil.pdf")
            intent.putExtras(bundle)

            sendBroadcast(intent)
        }
    }
}