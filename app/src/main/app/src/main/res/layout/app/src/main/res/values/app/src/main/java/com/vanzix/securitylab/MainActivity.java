package com.vanzix.securitylab;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.text.InputType;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity {

    private TextView log;

    private void addLog(String text) {
        log.append("\n• " + text);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        log = findViewById(R.id.log);

        Button flash = findViewById(R.id.flash);
        Button lock = findViewById(R.id.lock);
        Button gps = findViewById(R.id.gps);
        Button activity = findViewById(R.id.activity);

        flash.setOnClickListener(v -> {
            addLog("FLASH ATTACK: simulasi saja.");
            new AlertDialog.Builder(this)
                    .setTitle("Simulasi Flash")
                    .setMessage("Tidak mengakses flash perangkat.")
                    .setPositiveButton("OK", null)
                    .show();
        });

        lock.setOnClickListener(v -> {
            addLog("DEVICE LOCK: simulasi saja.");

            EditText input = new EditText(this);
            input.setInputType(InputType.TYPE_CLASS_NUMBER);
            input.setHint("PIN latihan: 1234");

            new AlertDialog.Builder(this)
                    .setTitle("Simulasi Device Lock")
                    .setView(input)
                    .setMessage("Ini tidak mengunci Android.")
                    .setPositiveButton("Buka",
                            (dialog, which) -> addLog("Simulasi lock dibuka."))
                    .show();
        });

        gps.setOnClickListener(v -> {
            addLog("GPS TRACKING: lokasi fiktif 0.0000, 0.0000.");
            Toast.makeText(
                    this,
                    "Lokasi hanya data fiktif.",
                    Toast.LENGTH_SHORT
            ).show();
        });

        activity.setOnClickListener(v -> {
            addLog(
                    "ACTIVITY MONITOR: WhatsApp, Galeri, Browser (simulasi)."
            );
        });
    }
              }
