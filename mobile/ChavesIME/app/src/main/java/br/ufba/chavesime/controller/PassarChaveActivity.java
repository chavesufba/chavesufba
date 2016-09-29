package br.ufba.chavesime.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

import br.ufba.chavesime.R;

public class PassarChaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passar_chave);
        setTitle(getResources().getText(R.string.titlePassarChave));

        Toolbar toolbar = (Toolbar) findViewById(R.id.homeToolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            //TODO: Seta de voltar estar escura, corrigir!
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setHomeButtonEnabled(true);

        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // handle arrow click here
        if (item.getItemId() == android.R.id.home) {
            finish();
        }
        return super.onOptionsItemSelected(item);
    }

    void onShowGetUserDialog(View v) {
        /*
            Abre um Dialog para a seleção do usuário
                Dialog terá um campo de busca por nome, email, login??? Apenas Alunos?
                Retornará uma lista no próprio dialog, usuário escolhe!!!
         */
    }

    public void botaoPassarChave(View botao) {

        EditText usuario = (EditText) findViewById(R.id.passarChaveETUsuario);
        String numSala;
        String nomeUser = usuario.getText().toString();

        if (nomeUser != getString(R.string.buscarUsuario).toString()) {
            // Selecionou um usuário, e envia os dados para a notificação push

            //TODO: API para passar chave
            /*
                Envia uma notificação push para o usuário selecionado
                Passa como parâmetros:
                    1. Usuário que enviou
                    2. Sala
                Notificação push iniciará a tela de ReceberChaveActivity
             */
        }
        else {
            // Usuário não selecionado, mostrar msg de erro
        }
    }
}
