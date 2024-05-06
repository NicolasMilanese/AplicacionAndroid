package com.example.trabajo_practico3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnIngresar;
    EditText edtMainNombreUsuario;
    EditText edtMainContraseñaUsuario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        this.Ingresar();
    }

    private void Ingresar() {
        btnIngresar = findViewById(R.id.btnIngresar);
        edtMainNombreUsuario = findViewById(R.id.edtMainNombreUsuario);
        edtMainContraseñaUsuario = findViewById(R.id.edtMainContraseñaUsuario);


            btnIngresar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (edtMainNombreUsuario.getText().toString().equals("alumno")&&(edtMainContraseñaUsuario.getText().toString().equals("1234"))) {
                    Intent intent = new Intent(getBaseContext(), PantallaPrincipal.class);
                    startActivity(intent);
                    }
                    else {
                        Toast.makeText(MainActivity.this, getString(R.string.Incorrecto), Toast.LENGTH_SHORT).show();

                    }
                }
            });

        }
    }