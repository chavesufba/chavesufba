package br.ufba.chavesime;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;

import java.util.Calendar;

/**
 * Created by Mauricio on 08/09/2016.
 */
public class Inicializacoes {

    public static void dropDownHorarios(Context context, Spinner spinner) {
        // Preenchimento do DropDown de Horários
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.horarios_array, R.layout.spinner);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public static void dropDownSalas(Context context, Spinner spinner) {
        // Preenchimento do DropDown de Horários
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(context,
                R.array.salas_array, R.layout.spinner);

        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
    }

    public static void dateText(EditText textDate) {
        textDate.setText(R.string.selecioneData);
        textDate.setTypeface(null, Typeface.NORMAL);
        textDate.setTextSize(19);
        textDate.setTextColor(Color.DKGRAY);
    }

    public static void timeText(EditText textTime) {
        textTime.setText(R.string.selecioneHora);
        textTime.setTypeface(null, Typeface.NORMAL);
        textTime.setTextSize(19);
        textTime.setTextColor(Color.DKGRAY);
    }
}
