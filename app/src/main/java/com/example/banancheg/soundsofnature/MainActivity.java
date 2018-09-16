package com.example.banancheg.soundsofnature;

import android.app.DialogFragment;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class MainActivity extends AppCompatActivity{
    DialogFragment dialogFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        dialogFragment = new DialogFragmentCategory();
    }

    public void onClick(View view) {
        Intent intent;
        switch (view.getId()) {
            case R.id.btnListening:
                intent = new Intent(MainActivity.this, ListeningActivity.class);
                startActivity(intent);
            break;

            case R.id.btnQuiz:
                dialogFragment.show(getFragmentManager(), "quiz");
             break;
        }
    }


}

