package br.ufba.chavesime.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

import br.ufba.chavesime.R;

public class ReceberChaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receber_chave);
        setTitle(getResources().getText(R.string.titleReceberChave));

        /*
            Receberá como parâmetros
                1. Usuário que enviou
                2. Sala da chave

            Usuário confirmará ou não a se quer receber a chave.

            Seta os valores nos campos de texto.
            Botões de confirmação

            TODO: API para troca de chave

         */
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }
}
