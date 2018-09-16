package com.example.banancheg.soundsofnature;


import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.media.AudioAttributes;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.util.TimeUtils;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import java.security.SecureRandom;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;


public class QuizActivity extends AppCompatActivity {

    private String choices;
    private static final String CHOICES = "pref_numberOfChoices";
    private SecureRandom random;
    private QuizDialogFragmentCorrectAnswer quizDialogFragmentCorrectAnswer;
    private Animation shakeAnimation;
    private TextView textView,correctAnswerTextView,currentQuestionTextView;
    private  ArrayList<ImageButton> referencesCurrentImageButtons;
    private LinearLayout row1, row2, parentRow1;
    private  ArrayList<Integer> workList,animalList,transportList, allCurrentImages;
    private LinkedHashSet<Integer> currentQuestionImagesIds;
    private HashMap<Integer, Integer> hashMapWork,hashMapAnimals, hashMapTransport;
    private SoundPool soundPool;
    private int correctAnswerImage, correctAnswerSound;
    private SharedPreferences sharedPreferences;
    private ImageButton imageButton1, imageButton2, imageButton3, imageButton4;
    private int correctAnswers, currentQuestion;
    private final int totalQuestions=20;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quiz);

        createSoundpool();
        sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        choices = sharedPreferences.getString(CHOICES,"4");

        row1 = (LinearLayout) findViewById(R.id.row1);
        parentRow1 = (LinearLayout) findViewById(R.id.parentRow1);
        row2 = (LinearLayout) findViewById(R.id.row2);
        textView = (TextView) findViewById(R.id.textTitle);

        shakeAnimation = AnimationUtils.loadAnimation(this,R.anim.incorrect_shake);
        shakeAnimation.setRepeatCount(3);

        correctAnswerTextView = (TextView) findViewById(R.id.correctAnswerTextView);
        currentQuestionTextView = (TextView) findViewById(R.id.currentQuestionTextView);


        quizDialogFragmentCorrectAnswer = new QuizDialogFragmentCorrectAnswer();

        animalList = new ArrayList<Integer>();
        animalList.add(R.drawable.cat);
        animalList.add(R.drawable.tiger);
        animalList.add(R.drawable.chicken);
        animalList.add(R.drawable.cow);
        animalList.add(R.drawable.dog);
        animalList.add(R.drawable.elephant);
        animalList.add(R.drawable.frog);
        animalList.add(R.drawable.horse);
        animalList.add(R.drawable.lion);
        animalList.add(R.drawable.pig);
        animalList.add(R.drawable.monkey);
        animalList.add(R.drawable.sheep);

        transportList = new ArrayList<Integer>();
        transportList.add(R.drawable.airplane);
        transportList.add(R.drawable.ambulance);
        transportList.add(R.drawable.bicycle);
        transportList.add(R.drawable.bus);
        transportList.add(R.drawable.car);
        transportList.add(R.drawable.fire_engine);
        transportList.add(R.drawable.helicopter);
        transportList.add(R.drawable.motorcycle);
        transportList.add(R.drawable.police_car);
        transportList.add(R.drawable.rocket);
        transportList.add(R.drawable.ship);
        transportList.add(R.drawable.train);



        hashMapAnimals = new LinkedHashMap<Integer, Integer>();
        hashMapAnimals.put(R.drawable.cat,R.raw.cat);
        hashMapAnimals.put(R.drawable.tiger,R.raw.tiger);
        hashMapAnimals.put(R.drawable.chicken,R.raw.chicken);
        hashMapAnimals.put(R.drawable.cow,R.raw.cow);
        hashMapAnimals.put(R.drawable.dog,R.raw.dog);
        hashMapAnimals.put(R.drawable.elephant,R.raw.elephant);
        hashMapAnimals.put(R.drawable.frog,R.raw.frog);
        hashMapAnimals.put(R.drawable.horse,R.raw.horse);
        hashMapAnimals.put(R.drawable.lion,R.raw.lion);
        hashMapAnimals.put( R.drawable.pig,R.raw.pig);
        hashMapAnimals.put(R.drawable.monkey,R.raw.monkey);
        hashMapAnimals.put(R.drawable.sheep,R.raw.sheep);

        hashMapTransport = new LinkedHashMap<Integer, Integer>();
        hashMapTransport.put(R.drawable.airplane,R.raw.airplane);
        hashMapTransport.put(R.drawable.ambulance,R.raw.ambulance);
        hashMapTransport.put(R.drawable.bicycle,R.raw.bicycle);
        hashMapTransport.put(R.drawable.bus,R.raw.bus);
        hashMapTransport.put(R.drawable.car,R.raw.car);
        hashMapTransport.put(R.drawable.fire_engine,R.raw.fire_engine);
        hashMapTransport.put(R.drawable.helicopter,R.raw.helicopter);
        hashMapTransport.put(R.drawable.motorcycle,R.raw.motorcycle);
        hashMapTransport.put(R.drawable.police_car,R.raw.police_car);
        hashMapTransport.put( R.drawable.rocket,R.raw.rocket);
        hashMapTransport.put(R.drawable.ship,R.raw.ship);
        hashMapTransport.put(R.drawable.train,R.raw.train);



        Intent intent = getIntent();
        String category = intent.getStringExtra("category");
        if (category.equals("animal")){
            workList = animalList;
            hashMapWork = hashMapAnimals;
        }
        else{
            workList = transportList;
            hashMapWork = hashMapTransport;
        }


        if (choices.equals("2")){
            referencesCurrentImageButtons = new ArrayList<>();
            imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
            imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
            referencesCurrentImageButtons.add(imageButton1);
            referencesCurrentImageButtons.add(imageButton2);
            if (row2 != null)
            row2.setVisibility(View.GONE);

        }else{
            referencesCurrentImageButtons = new ArrayList<>();
            imageButton1 = (ImageButton) findViewById(R.id.imageButton1);
            imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
            if (row2 != null)
                row2.setVisibility(View.VISIBLE);
            imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
            imageButton4 = (ImageButton) findViewById(R.id.imageButton4);

            referencesCurrentImageButtons.add(imageButton1);
            referencesCurrentImageButtons.add(imageButton2);
            referencesCurrentImageButtons.add(imageButton3);
            referencesCurrentImageButtons.add(imageButton4);

        }


        currentQuestionImagesIds = new LinkedHashSet<>();
        random = new SecureRandom();

        startNewQuestion();


    }



    private View.OnClickListener quizButtonListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            ImageButton currentButton = (ImageButton) v;
            int currentImage = R.drawable.airplane;
            switch (v.getId()){
                case R.id.imageButton1:
                    currentImage = allCurrentImages.get(0);
                    break;
                case R.id.imageButton2:
                    currentImage = allCurrentImages.get(1);
                    break;
                case R.id.imageButton3:
                    currentImage = allCurrentImages.get(2);
                    break;
                case R.id.imageButton4:
                    currentImage = allCurrentImages.get(3);
                    break;
            }
            if (correctAnswerImage == currentImage){
                correctAnswers++;

                quizDialogFragmentCorrectAnswer.show(getFragmentManager(),"quizDialog");

                startNewQuestion();
            }else{
                currentButton.startAnimation(shakeAnimation);



                startNewQuestion();
            }

        }
    };

    @Override
    protected void onPause() {
        super.onPause();
        soundPool.release();
        soundPool = null;
    }

    @Override
    protected void onResume() {
        super.onResume();

        createSoundpool();

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_quiz, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent preferencesIntent = new Intent(this, SettingsActivity.class);
        startActivity(preferencesIntent);
        return super.onOptionsItemSelected(item);
    }


    public void createSoundpool(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            AudioAttributes attributes = new AudioAttributes.Builder()
                    .setUsage(AudioAttributes.USAGE_GAME)
                    .setContentType(AudioAttributes.CONTENT_TYPE_SONIFICATION)
                    .build();

            soundPool = new SoundPool.Builder()
                    .setAudioAttributes(attributes)
                    .build();
        }
        else {
            soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC, 0);
        }
        soundPool.setOnLoadCompleteListener(new SoundPool.OnLoadCompleteListener() {
            @Override
            public void onLoadComplete(SoundPool soundPool, int sampleId, int status) {
                soundPool.play(sampleId, 1.0f, 1.0f, 0, 0, 1.0f);
            }
        });
    }

    void startNewQuestion(){
        currentQuestion++;
        if (currentQuestion<=20) {
            currentQuestionTextView.setText(String.format(getResources().getString(R.string.current_question), currentQuestion, totalQuestions));
            correctAnswerTextView.setText(String.format(getResources().getString(R.string.total_correct_answer), correctAnswers));
            currentQuestionImagesIds.clear();
            while (currentQuestionImagesIds.size() < Integer.parseInt(choices)) {
                currentQuestionImagesIds.add(workList.get(random.nextInt(workList.size())));
            }


            allCurrentImages = new ArrayList<>();

            Iterator<Integer> iterator = currentQuestionImagesIds.iterator();
            Iterator<ImageButton> iterator2 = referencesCurrentImageButtons.iterator();
            while (iterator.hasNext()) {
                ImageButton imageButton = iterator2.next();
                int currentImage = iterator.next();
                imageButton.setOnClickListener(quizButtonListener);
                allCurrentImages.add(currentImage);
                imageButton.setBackgroundResource(currentImage);
            }

            iterator = currentQuestionImagesIds.iterator();
            for (int i = 0; i <= random.nextInt(currentQuestionImagesIds.size()); i++) {
                correctAnswerImage = iterator.next();
            }

            correctAnswerSound = hashMapWork.get(correctAnswerImage);

            soundPool.load(this, correctAnswerSound, 1);
        }else{
            Intent intent= new Intent(this, MainActivity.class);
            startActivity(intent);
        }
    }
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        Log.d("myLogs", "onSaveInstanceState");
    }
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        Log.d("myLogs", "onRestoreInstanceState");
    }
}
