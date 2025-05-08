package com.example.rutamascotamaps;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    Button btnVerRuta, btnVerLugar, btnBuscarRestaurantes, btnStreetView, btnBuscarDireccion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Enlazar botones con la vista
        btnVerRuta = findViewById(R.id.btnVerRuta);
        btnVerLugar = findViewById(R.id.btnVerLugar);
        btnBuscarRestaurantes = findViewById(R.id.btnBuscarRestaurantes);
        btnStreetView = findViewById(R.id.btnStreetView);
        btnBuscarDireccion = findViewById(R.id.btnBuscarDireccion);

        // Acciones de cada botón
        btnVerRuta.setOnClickListener(v -> mostrarRuta());
        btnVerLugar.setOnClickListener(v -> mostrarLugar());
        btnBuscarRestaurantes.setOnClickListener(v -> buscarRestaurantes());
        btnStreetView.setOnClickListener(v -> verStreetView());
        btnBuscarDireccion.setOnClickListener(v -> buscarDireccion());
    }

    // Muestra una ruta entre dos coordenadas
    private void mostrarRuta() {
        Uri uri = Uri.parse("https://www.google.com/maps/dir/?api=1" +
                "&origin=4.634003,-74.064591" +
                "&destination=4.632314,-74.066543" +
                "&travelmode=walking");
        Intent intent = new Intent(Intent.ACTION_VIEW, uri);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
    }

    // Muestra una ubicación específica con etiqueta
    private void mostrarLugar() {
        Uri gmmIntentUri = Uri.parse("geo:4.634003,-74.064591?q=Veterinaria");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    // Busca restaurantes cercanos
    private void buscarRestaurantes() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=restaurantes");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    // Muestra Street View en coordenadas
    private void verStreetView() {
        Uri gmmIntentUri = Uri.parse("google.streetview:cbll=4.634003,-74.064591");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }

    // Busca una dirección escrita
    private void buscarDireccion() {
        Uri gmmIntentUri = Uri.parse("geo:0,0?q=Cra 7 #72-41 Bogotá");
        Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
        mapIntent.setPackage("com.google.android.apps.maps");
        startActivity(mapIntent);
    }
}
