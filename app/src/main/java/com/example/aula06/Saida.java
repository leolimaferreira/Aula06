package com.example.aula06;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.aula06.model.Ingresso;
import com.example.aula06.model.IngressoComum;
import com.example.aula06.model.IngressoVIP;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class Saida extends AppCompatActivity {

    private Ingresso ingresso;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_saida);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        TextView tvValorFinal = findViewById(R.id.tvValorFinal);
        tvValorFinal.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        Button btnVoltar = findViewById(R.id.btnVoltar);

        Intent intent = getIntent();
        Bundle bundle = intent.getExtras();


        String tipo = bundle.getString("tipo");
        if (tipo.equals("comum")) {
            ingresso = new IngressoComum(bundle.getString("codId"), bundle.getFloat("valorFinal"));
        } else {
            ingresso = new IngressoVIP(bundle.getString("codId"), bundle.getFloat("valorFinal"));
            ((IngressoVIP) ingresso).setFuncao(bundle.getString("funcao"));
        }
        BigDecimal valorFinal = BigDecimal.valueOf(ingresso.getValor()).setScale(2, RoundingMode.HALF_UP);
        if (tipo.equals("comum")) {
            tvValorFinal.setText(getString(R.string.CodId) + ingresso.getCodId() + "\n" + getString(R.string.ValorSaida) + valorFinal + "\n" + getString(R.string.SemFuncao));
        } else {
            tvValorFinal.setText(getString(R.string.CodId) + ingresso.getCodId() + "\n" + getString(R.string.ValorSaida) + valorFinal + "\n" + getString(R.string.Func) + (((IngressoVIP) ingresso).getFuncao()));
        }

        btnVoltar.setOnClickListener(op -> voltar());
    }

    private void voltar() {
        Intent i = new Intent(this, MainActivity.class);
        this.startActivity(i);
        this.finish();
    }
}