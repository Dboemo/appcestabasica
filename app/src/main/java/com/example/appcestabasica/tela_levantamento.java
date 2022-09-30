package com.example.appcestabasica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class tela_levantamento extends AppCompatActivity {
Button btregistrar,btlevantamentoretornar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_levantamento);
        btregistrar=findViewById(R.id.btregistrar);
        btlevantamentoretornar=findViewById(R.id.btlevantamentoretornar);

    }

    private void salvaarquivotxt(String arq, String texto, Context context) {

        try {
            OutputStreamWriter objgravacao = new OutputStreamWriter(context.openFileOutput(arq, Context.MODE_APPEND));

            objgravacao.write(texto);
            objgravacao.close();
            Log.e("Sucesso na gravação", "arquivo " + arq + " foi gravado com sucesso");

        } catch (IOException ex) {
            Log.e("Erro de gravação", "Erro ao tentar gravar arquivo");

        }
    }
}