package br.ufba.chavesime;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.app.DialogFragment;
import android.os.Bundle;
import android.widget.EditText;

import java.util.Calendar;

/**
 * Created by Mauricio on 01/09/2016.
 */

public class DatePickerFragment extends DialogFragment {

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        // Use the current date as the default date in the picker

        String classFrom  = getArguments().getString("Class");

        EditText text = (EditText) getActivity().findViewById(R.id.editTextData);
        String teste = text.getText().toString();
        String[] parts = teste.split("/");

        int day = Integer.parseInt(parts[0]);
        int month = Integer.parseInt(parts[1]) - 1;
        int year = Integer.parseInt(parts[2]);

        // Create a new instance of DatePickerDialog and return it
        DatePickerDialog pickerDialog;
        if(classFrom.equals("Cronograma"))
            pickerDialog = new DatePickerDialog(getActivity(), (CronogramaActivity)getActivity(), year, month, day);
        else
            pickerDialog = new DatePickerDialog(getActivity(), (ReservarSalaActivity)getActivity(), year, month, day);

        pickerDialog.getDatePicker().setMinDate(System.currentTimeMillis() - 1000);
        return pickerDialog;
    }
}