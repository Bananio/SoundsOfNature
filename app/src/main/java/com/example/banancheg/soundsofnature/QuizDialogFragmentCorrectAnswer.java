package com.example.banancheg.soundsofnature;

import android.app.DialogFragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

public class QuizDialogFragmentCorrectAnswer extends DialogFragment implements View.OnClickListener{
    private final String LOG_TAG = "myLogs";

    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(R.string.congratulations);
        View v = inflater.inflate(R.layout.quiz_dialog, null);
        v.findViewById(R.id.quizDialogButtonOk).setOnClickListener(this);
        return v;
    }

    public void onClick(View v) {
        Log.d(LOG_TAG, "Dialog 1: " + ((Button) v).getText());

        dismiss();
    }




    public void onCancel(DialogInterface dialog) {
        super.onCancel(dialog);
        Log.d(LOG_TAG, "Dialog 2: onCancel");
    }
}
