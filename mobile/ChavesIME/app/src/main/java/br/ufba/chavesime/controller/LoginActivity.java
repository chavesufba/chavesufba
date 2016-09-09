package br.ufba.chavesime.controller;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import br.ufba.chavesime.CronogramaActivity;
import br.ufba.chavesime.R;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);


    }

    /**
     * Confere texto inserido pelo usuário nos campos Matrícula e Senha.
     * Caso os campos tenham sido preenchidos corretamente, a função login() é chamada.
     * Se o servidor confirma existência do usuário a próxima Activity é inicializada.
     *
     * @param botao O botão clicado.
     */
    public void botaoLogin(View botao) {

        // TODO: Conferir conteúdo do campo matrícula (tipo de caractere, tamanho, etc)
        if (true) {

            if (login()) {

                Intent intent = new Intent(this, HomeActivity.class);
                intent.putExtra("user", "Teste");
                startActivity(intent);

            }

        } else {

            Toast.makeText(LoginActivity.this, getString(R.string.preenchaCorretamente), Toast.LENGTH_LONG).show();

        }

    }

    /**
     * Abre a tela de cadastro
     */
    public void botaoCadastro(View botao) {

        Intent intent = new Intent(/*LoginActivity.this, CadastroActivity.class,*/); // TODO: Descomentar linha e criar 'CadastroActivity
        //startActivity(intent); // TODO: Descomentar linha
        Toast.makeText(LoginActivity.this, "Tela em desenvolvimento.", Toast.LENGTH_SHORT).show(); // TODO: Apagar linha

    }

    /**
     *
     * @return true se login foi realizado com sucesso, false caso contrário
     */
    public boolean login() {

        // TODO: Chamar API de login aqui
        return true;

    }

}
