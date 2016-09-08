package br.ufba.chavesime;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class CronogramaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cronograma);
        setTitle(getResources().getText(R.string.titleCronograma));
    }
}
