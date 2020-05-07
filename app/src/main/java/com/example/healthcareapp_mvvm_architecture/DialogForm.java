package com.example.healthcareapp_mvvm_architecture;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatDialogFragment;


public class DialogForm extends AppCompatDialogFragment {
    private EditText editTextDialog_name;
    private EditText editTextDialog_gender;
    private EditText editTextDialog_appointmentdate;
    private EditText editTextDialog_birthdate;
    private TextView textView_errorprompt;

    private DialogFormListener listener;

    private String name;
    private String gender;
    private String appointmentDate;
    private String birthDate;

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());

        LayoutInflater inflater = getActivity().getLayoutInflater();
        View view = inflater.inflate(R.layout.layout_dialog, null);
        editTextDialog_name = view.findViewById(R.id.edit_name);
        editTextDialog_gender = view.findViewById(R.id.edit_gender);
        editTextDialog_appointmentdate = view.findViewById(R.id.edit_appointmentdate);
        editTextDialog_birthdate = view.findViewById(R.id.edit_birthdate);
        textView_errorprompt = view.findViewById(R.id.text_view_errorPrompt);

        builder.setView(view)
                .setTitle("New Note")
                .setNegativeButton("cancel", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        //Leave blank here
                    }
                })
                .setPositiveButton("ok", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {

                        name = editTextDialog_name.getText().toString();
                        gender = editTextDialog_gender.getText().toString();
                        appointmentDate = editTextDialog_appointmentdate.getText().toString();
                        birthDate = editTextDialog_birthdate.getText().toString();

                        if (name.trim().isEmpty() || gender.trim().isEmpty() || appointmentDate.trim().isEmpty() || birthDate.trim().isEmpty()) {
                            //Leave blank here
                        } else {
                            listener.applyTexts(name, gender, appointmentDate, birthDate);
                        }

                    }
                });
        return builder.create();
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try {
            listener = (DialogFormListener) context;
        } catch (ClassCastException e) {
            throw new ClassCastException(context.toString() +
                    "must implement DialogFormListener");
        }
    }

    public interface DialogFormListener {
        void applyTexts(String name, String gender, String appointmentDate, String birthDate);
    }
}
