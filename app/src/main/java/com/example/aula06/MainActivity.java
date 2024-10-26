package com.example.aula06;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula06.model.Ingresso;
import com.example.aula06.model.IngressoComum;
import com.example.aula06.model.IngressoVIP;

public class MainActivity extends AppCompatActivity {

    //private Ingresso ingresso;
    private RadioButton rbComum;
    private RadioButton rbVIP;
    private EditText etCodigo;
    private EditText etValor;
    private EditText etFuncao;
    private Button btnValorFinal;

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

        rbComum = findViewById(R.id.rbComum);
        rbComum.setChecked(true);
        rbVIP = findViewById(R.id.rbVIP);
        etCodigo = findViewById(R.id.etCodigo);
        etValor = findViewById(R.id.etValor);
        etFuncao = findViewById(R.id.etFuncao);
        btnValorFinal = findViewById(R.id.btnValorFinal);

        btnValorFinal.setOnClickListener(op -> calc());

    }

    private void calc() {
        String tipo = "";
        Bundle bundle = new Bundle();
        String codId = "";
        float valorFinal = 0;
        if(rbComum.isChecked()) {
            IngressoComum ingresso = new IngressoComum(etCodigo.getText().toString(), Float.parseFloat(etValor.getText().toString()));
            tipo = "comum";
            codId = etCodigo.getText().toString();
            valorFinal = ingresso.valorFinal(0.15f);
            bundle.putString("codId", codId);
            bundle.putFloat("valorFinal", valorFinal);
            bundle.putString("tipo", tipo);
        }
        if(rbVIP.isChecked()) {
            IngressoVIP ingresso = new IngressoVIP(etCodigo.getText().toString(), Float.parseFloat(etValor.getText().toString()));
            tipo = "vip";
            String funcao = etFuncao.getText().toString();
            codId = etCodigo.getText().toString();
            valorFinal = ingresso.valorFinal(0.15f);
            bundle.putString("funcao", funcao);
            bundle.putString("codId", codId);
            bundle.putFloat("valorFinal", valorFinal);
            bundle.putString("tipo", tipo);
        }

        troca(bundle);
    }

    private void troca(Bundle bundle) {
        Intent i = new Intent(this, Saida.class);
        i.putExtras(bundle);
        this.startActivity(i);
        this.finish();
    }
}