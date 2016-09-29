package br.ufba.chavesime.controller;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import br.ufba.chavesime.R;

public class PassarChaveActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_passar_chave);
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
