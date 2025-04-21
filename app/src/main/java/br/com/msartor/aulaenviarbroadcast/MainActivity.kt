package br.com.msartor.aulaenviarbroadcast

import android.content.ComponentName
import android.content.Intent
import android.net.Uri
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
            Log.i("ComunicacaoBroadcastReceiver", "ComunicacaoBroadcastReceiver clicou no botao abrir pdf")
            val intent = Intent("br.com.msartor.aulaservice.ABRIR_ARQUIVO_PDF")
            val bundle = Bundle()
            bundle.putString("ARQUIVO","arquivo/perfil.pdf")
            intent.putExtras(bundle)

            sendBroadcast(intent)
        }

        binding.btnAbrirPdfExplicita.setOnClickListener {
            Log.i("ComunicacaoBroadcastReceiver", "ComunicacaoBroadcastReceiver clicou no botao abrir pdf explicita ")
            val intent = Intent("br.com.msartor.aulaservice.ABRIR_ARQUIVO_PDF")
            val bundle = Bundle()
            bundle.putString("ARQUIVO","arquivo/perfil.pdf")
            intent.putExtras(bundle)

            val component = ComponentName("br.com.msartor.aulaservice", "br.com.msartor.aulaservice.ComunicacaoBroadcastActivity")
            intent.component = component
            sendBroadcast(intent)

        }

        binding.btnIntentImplicita.setOnClickListener {
            Log.i(
                "ComunicacaoBroadcastReceiver",
                "ComunicacaoBroadcastReceiver clicou no botao Intent Implicita"
            )
            val link = "https://www.google.com"
            val intent = Intent(Intent.ACTION_VIEW, Uri.parse(link))
            startActivity(intent)


        }

        binding.btnIntentImplicitaWithChooser.setOnClickListener{
            Log.i(
                "ComunicacaoBroadcastReceiver",
                "ComunicacaoBroadcastReceiver clicou no botao Intent Implicita com Escolha"
            )
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT, "Texto a ser enviado")
            intent.type = "text/plain"

            val compartilhar = Intent.createChooser(intent, "Compartilhar")
            startActivity(compartilhar)

        }


    }
}