package com.example.banancheg.soundsofnature;

import android.app.DialogFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import org.w3c.dom.Text;

public class DialogFragmentCategory extends DialogFragment implements View.OnClickListener {

    private Intent intent;
    private TextView bestResultTextView;
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        getDialog().setTitle(R.string.quiz);
        View v = inflater.inflate(R.layout.dialog_category, null);
        v.findViewById(R.id.btnAnimals).setOnClickListener(this);
        v.findViewById(R.id.btnTransport).setOnClickListener(this);
        return v;
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btnAnimals:
                intent = new Intent(getActivity(), QuizActivity.class);
                intent.putExtra("category", "animal");
                startActivity(intent);
                break;
            case R.id.btnTransport:
                intent = new Intent(getActivity(), QuizActivity.class);
                intent.putExtra("category", "transport");
                startActivity(intent);
                break;
        }
    }
}
