package com.example.revcare.infra.gui;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.revcare.R;

public class ServicosAgendados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_servicos_agendados);
    }
}
