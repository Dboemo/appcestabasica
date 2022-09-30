package com.example.appcestabasica;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import java.io.IOException;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {
Button btreg,btest,btpreco,btsair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btreg=(Button) findViewById(R.id.btRegpreco) ;
        btest=(Button) findViewById(R.id.btEstabelecimentos) ;
        btpreco=(Button) findViewById(R.id.btPrecos) ;
        btsair=(Button) findViewById(R.id.btEncerrar) ;
btreg.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        abreregistros();
    }
});
     btest.setOnClickListener(new View.OnClickListener() {
         @Override
         public void onClick(View view) {
             abreestabeleciemento();
         }
     });
        btpreco.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abreprecos();
            }
        });
        btsair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                finish();
            }
        });
    }


    private void abreregistros() {
        Intent intent = new Intent(this,tela_levantamento.class);
        startActivity(intent);
        finish();
    }
    private void abreestabeleciemento() {
        Intent intent = new Intent(this,tela_estabelecimentos.class);
        startActivity(intent);
        finish();
    }
    private void abreprecos() {
        salvaarquivotxt(MainActivity.this);
        /*
        Intent intent = new Intent(this, tela_precos.class);
        startActivity(intent);
        finish();*/
    }
    private void salvaarquivotxt( Context context) {

        try {
            String texto="a;b;c;d\n";
            OutputStreamWriter objgravacao = new OutputStreamWriter(context.openFileOutput("teste2.csv", Context.MODE_APPEND));

            objgravacao.write(texto);
            objgravacao.close();
            Log.e("Sucesso na gravação", "arquivo  foi gravado com sucesso");

        } catch (IOException ex) {
            Log.e("Erro de gravação", "Erro ao tentar gravar arquivo");

        }
    }
}