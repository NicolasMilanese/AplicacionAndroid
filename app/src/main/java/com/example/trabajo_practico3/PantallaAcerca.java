package com.example.trabajo_practico3;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class PantallaAcerca extends AppCompatActivity {

    Button btnVolver;
    ImageButton botonTelefono;
    ImageButton botonEmail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_pantalla_acerca);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Configurar el botón para volver a la pantalla principal
        configurarBotonVolver();

        // Configurar los botones para el teléfono y el correo electrónico
        configurarBotonTelefono();
        configurarBotonEmail();
    }

    private void configurarBotonVolver() {
        btnVolver = findViewById(R.id.Volver);
        btnVolver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getBaseContext(), PantallaPrincipal.class);
                startActivity(intent);
            }
        });
    }

    private void configurarBotonTelefono() {
        botonTelefono = findViewById(R.id.BotonTelefono);
        botonTelefono.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialPhoneNumber();
            }
        });
    }

    private void configurarBotonEmail() {
        botonEmail = findViewById(R.id.BotonEmail);
        botonEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendEmail();
            }
        });
    }

    private void dialPhoneNumber() {
        Intent intent = new Intent(Intent.ACTION_DIAL);
        intent.setData(Uri.parse("tel:123456789"));
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    private void sendEmail() {
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setType("text/plain");
        emailIntent.putExtra(Intent.EXTRA_EMAIL, new String[]{"nicolasmilanese2004@gmail.com"});
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Asunto del correo");
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Hola,");
        startActivity(emailIntent);
    }
}