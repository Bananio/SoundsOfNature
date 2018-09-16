package com.example.banancheg.soundsofnature;

import android.media.AudioAttributes;
import android.media.AudioManager;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TabHost;
import android.widget.TextView;
import android.widget.Toast;
import android.media.SoundPool;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

public class ListeningActivity extends AppCompatActivity implements View.OnClickListener {

    int sAirplane;
    private SoundPool soundPool;
    private Map<Integer, Integer> hashMapIdSounds;
    private ImageButton catImageBtn, tigerImageBtn, chickenImageBtn, cowImageBtn, dogImageBtn, elephantImageBtn, frogImageBtn, horseImageBtn, lionImageBtn, pigImageBtn, monkeyImageBtn, sheepImageBtn, airplaneImageBtn, ambulanceImageBtn, bicycleImageBtn, busImageBtn, carImageBtn, fireEngineImageBtn, helicopterImageBtn, motorcycleImageBtn, policeCarImageBtn, rocketImageBtn, shipImageBtn, trainImageBtn;
    private ScrollView scrollView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_listening);


        createSoundpool();

        scrollView = (ScrollView) findViewById(R.id.scrollView);

        catImageBtn = (ImageButton) findViewById(R.id.imageBtnCat);
        tigerImageBtn =(ImageButton) findViewById(R.id.imageBtnTiger);
        chickenImageBtn =(ImageButton) findViewById(R.id.imageBtnChicken);
        cowImageBtn =(ImageButton) findViewById(R.id.imageBtnCow);
        dogImageBtn =(ImageButton) findViewById(R.id.imageBtnDog);
        elephantImageBtn =(ImageButton) findViewById(R.id.imageBtnElephant);
        frogImageBtn =(ImageButton) findViewById(R.id.imageBtnFrog);
        horseImageBtn =(ImageButton) findViewById(R.id.imageBtnHorse);
        lionImageBtn =(ImageButton) findViewById(R.id.imageBtnLion);
        pigImageBtn =(ImageButton) findViewById(R.id.imageBtnPig);
        monkeyImageBtn =(ImageButton) findViewById(R.id.imageBtnMonkey);
        sheepImageBtn =(ImageButton) findViewById(R.id.imageBtnSheep);
        airplaneImageBtn =(ImageButton) findViewById(R.id.imageBtnAirplane);
        ambulanceImageBtn = (ImageButton) findViewById(R.id.imageBtnAmbulance);
        bicycleImageBtn =(ImageButton) findViewById(R.id.imageBtnBicycle);
        busImageBtn = (ImageButton) findViewById(R.id.imageBtnBus);
        carImageBtn =(ImageButton) findViewById(R.id.imageBtnCar);
        fireEngineImageBtn =(ImageButton) findViewById(R.id.imageBtnFireEngine);
        helicopterImageBtn =(ImageButton) findViewById(R.id.imageBtnHelicopter);
        motorcycleImageBtn =  (ImageButton) findViewById(R.id.imageBtnMotorcycle);
        policeCarImageBtn =(ImageButton) findViewById(R.id.imageBtnPoliceCar);
        rocketImageBtn =(ImageButton) findViewById(R.id.imageBtnRocket);
        shipImageBtn = (ImageButton) findViewById(R.id.imageBtnShip);
        trainImageBtn =   (ImageButton) findViewById(R.id.imageBtnTrain);


        List<ImageButton> listImgBtn = new ArrayList<ImageButton>();
        listImgBtn.add(catImageBtn);
        listImgBtn.add(tigerImageBtn);
        listImgBtn.add(chickenImageBtn);
        listImgBtn.add(cowImageBtn);
        listImgBtn.add(dogImageBtn);
        listImgBtn.add(elephantImageBtn);
        listImgBtn.add(frogImageBtn);
        listImgBtn.add(horseImageBtn);
        listImgBtn.add(lionImageBtn);
        listImgBtn.add(pigImageBtn);
        listImgBtn.add(monkeyImageBtn);
        listImgBtn.add(sheepImageBtn);
        listImgBtn.add(airplaneImageBtn);
        listImgBtn.add(ambulanceImageBtn);
        listImgBtn.add(bicycleImageBtn);
        listImgBtn.add(busImageBtn);
        listImgBtn.add(carImageBtn);
        listImgBtn.add(fireEngineImageBtn);
        listImgBtn.add(helicopterImageBtn);
        listImgBtn.add(motorcycleImageBtn);
        listImgBtn.add(policeCarImageBtn);
        listImgBtn.add(rocketImageBtn);
        listImgBtn.add(shipImageBtn);
        listImgBtn.add(trainImageBtn);

        for (int i=0; i<listImgBtn.size(); i++){
            listImgBtn.get(i).setOnClickListener(this);
        }

        hashMapIdSounds = new LinkedHashMap<Integer, Integer>();
        hashMapIdSounds.put(R.id.imageBtnCat,R.raw.cat);
        hashMapIdSounds.put(R.id.imageBtnTiger,R.raw.tiger);
        hashMapIdSounds.put(R.id.imageBtnChicken,R.raw.chicken);
        hashMapIdSounds.put(R.id.imageBtnCow,R.raw.cow);
        hashMapIdSounds.put(R.id.imageBtnDog,R.raw.dog);
        hashMapIdSounds.put(R.id.imageBtnElephant,R.raw.elephant);
        hashMapIdSounds.put(R.id.imageBtnFrog,R.raw.frog);
        hashMapIdSounds.put(R.id.imageBtnHorse,R.raw.horse);
        hashMapIdSounds.put(R.id.imageBtnLion,R.raw.lion);
        hashMapIdSounds.put( R.id.imageBtnPig,R.raw.pig);
        hashMapIdSounds.put(R.id.imageBtnMonkey,R.raw.monkey);
        hashMapIdSounds.put(R.id.imageBtnSheep,R.raw.sheep);
        hashMapIdSounds.put(R.id.imageBtnAirplane , R.raw.airplane);
        hashMapIdSounds.put(R.id.imageBtnAmbulance, R.raw.ambulance);
        hashMapIdSounds.put(R.id.imageBtnBicycle , R.raw.bicycle);
        hashMapIdSounds.put(R.id.imageBtnBus , R.raw.bus);
        hashMapIdSounds.put(R.id.imageBtnCar , R.raw.car);
        hashMapIdSounds.put(R.id.imageBtnFireEngine , R.raw.fire_engine);
        hashMapIdSounds.put(R.id.imageBtnHelicopter , R.raw.helicopter);
        hashMapIdSounds.put(R.id.imageBtnMotorcycle , R.raw.motorcycle);
        hashMapIdSounds.put(R.id.imageBtnPoliceCar , R.raw.police_car);
        hashMapIdSounds.put(R.id.imageBtnRocket , R.raw.rocket);
        hashMapIdSounds.put(R.id.imageBtnShip , R.raw.ship);
        hashMapIdSounds.put(R.id.imageBtnTrain , R.raw.train);

        TabHost tabHost = (TabHost) findViewById(android.R.id.tabhost);
        tabHost.setup();
        tabSpecSettings(tabHost,"tagAnimals", getResources().getString(R.string.animals), R.id.tabAnimals);
        tabSpecSettings(tabHost,"tagTransport", getResources().getString(R.string.transport), R.id.tabTransport);


        tabHost.setCurrentTabByTag("tag1");

        tabHost.setOnTabChangedListener(new TabHost.OnTabChangeListener() {
            @Override
            public void onTabChanged(String tabId) {
                scrollView.scrollTo(0,0);
            }
        });

        //soundPool = new SoundPool(1, AudioManager.STREAM_MUSIC,0);
         //sAirplane = soundPool.load(this,R.raw.airplane,1);
       // soundPool.play(sAirplane,1,1,1,0,1);
    }

    @Override
    public void onClick(View v) {
        soundPool.load(this, hashMapIdSounds.get(v.getId()), 1);
    }


    public void tabSpecSettings(TabHost tabHost, String tabSpecTag, String indicator, int content){
        TabHost.TabSpec tabSpec = tabHost.newTabSpec(tabSpecTag);
        tabSpec.setIndicator(indicator);
        tabSpec.setContent(content);
        tabHost.addTab(tabSpec);
    }
    @Override
    protected void onPause() {
        super.onPause();
        Log.d("Ravi","Main Pause");
        soundPool.release();
        soundPool = null;
    }

    @Override
    protected void onResume() {
        super.onResume();
        createSoundpool();
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
    }

