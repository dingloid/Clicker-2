package ohpiestudio.clicker2.screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;


import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;
import com.google.gson.Gson;


import ohpiestudio.clicker2.adapter.CustomAdapter;
import ohpiestudio.clicker2.upgrades.BasePowerUp;
import ohpiestudio.clicker2.R;
import ohpiestudio.clicker2.upgrades.PowerUp;


public class Shop extends BasePowerUp {
    //UI
    private TextView donutAmountText;
    private TextView donutPerSecondText;

    //Variables
    private long donutAmount;
    private long donutPerSecond;

    //Shared Prefs
    public SharedPreferences savedClicker;
    public SharedPreferences savedBaker;
    public SharedPreferences savedFlourSack;
    public SharedPreferences savedMine;
    public SharedPreferences savedCloner;
    public SharedPreferences savedFactory;
    public SharedPreferences savedShrine;
    public SharedPreferences savedShipment;
    public SharedPreferences savedPortal;
    public SharedPreferences savedTimeMachine;

    public PowerUp clicker;
    public PowerUp baker;
    public PowerUp flourSack;
    public PowerUp mine;
    public PowerUp cloner;
    public PowerUp factory;
    public PowerUp shrine;
    public PowerUp shipment;
    public PowerUp portal;
    public PowerUp timeMachine;

    PowerUp powerUpArray[];

    Gson g;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_shop);
        //Init counters
        donutAmountText = (TextView) findViewById(R.id.donutAmountText);
        donutPerSecondText = (TextView) findViewById(R.id.donutPerSecondText);




    }//End onCreate

    @Override
    protected void onStart(){
        super.onStart();
        g = new Gson();

        //BANNER AD
        MobileAds.initialize(getApplicationContext(), "ca-app-pub-3274964731359118~2273860582");

        AdView mAdView = (AdView) findViewById(R.id.adView);
        AdRequest request = new AdRequest.Builder()
                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
                .addTestDevice("5A123D239B16B42078ABB18A091B4B57")  // An example device ID
                .build();
//        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(request);

        //Get Intent from Main Activity
        Intent getValue = this.getIntent();
        donutAmount = getValue.getLongExtra("donutAmount", donutAmount);
        donutPerSecond = getValue.getLongExtra("donutPerSecond", donutPerSecond);

        //Init prefs
        savedClicker = getPreferences(Context.MODE_PRIVATE);
        savedBaker = getPreferences(Context.MODE_PRIVATE);
        savedFlourSack = getPreferences(Context.MODE_PRIVATE);
        savedCloner = getPreferences(Context.MODE_PRIVATE);
        savedMine = getPreferences(Context.MODE_PRIVATE);
        savedFactory = getPreferences(Context.MODE_PRIVATE);
        savedShrine = getPreferences(Context.MODE_PRIVATE);
        savedShipment = getPreferences(Context.MODE_PRIVATE);
        savedPortal = getPreferences(Context.MODE_PRIVATE);
        savedTimeMachine = getPreferences(Context.MODE_PRIVATE);

        String temp = savedClicker.getString("savedClicker", "");
        powerUpArray = g.fromJson( temp , PowerUp[].class);

        //Declare Objects or something

    if(powerUpArray == null){

        baker = new PowerUp("Baker", 2, 0);
        flourSack = new PowerUp("Flour Sack", 3, 0);
        mine = new PowerUp("Mine", 4, 0);
        cloner = new PowerUp("Cloner", 5, 0);
        factory = new PowerUp("Factory", 6, 0);
        shrine = new PowerUp("Shrine", 7, 0);
        shipment = new PowerUp("Shipment", 8, 0);
        portal = new PowerUp("Portal", 9, 0);
        timeMachine = new PowerUp("Time Machine", 10, 0);

        //Power Up Array
        powerUpArray = new PowerUp[]{
                clicker,
                baker,
                flourSack,
                mine,
                cloner,
                factory,
                shrine,
                //shipment,
                portal,
                timeMachine
        };
    }



        //Update Text Fields with donut amount
        setDonutAmountText(String.valueOf(donutAmount) + " " + getString(R.string.donuts));
        setDonutPerSecondText(String.valueOf(donutPerSecond) + " " + getString(R.string.dps));

        //Init List View
        final ListView listView = (ListView) findViewById(R.id.listView);

        final CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(),powerIcons, powerUpArray );
        listView.setAdapter(customAdapter);

        //On Click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l ) {
                switch (i){
                    case 0:{
                        if(donutAmount >= clicker.getPrice()) {
                            clicker.increaseAmountOwned();
                            donutAmount = donutAmount - clicker.getPrice();
                            donutPerSecond = donutPerSecond + 1;
                            clicker.increasePrice();
                        }
                        break;
                    }
                    case 1:{
                        if(donutAmount >= baker.getPrice()) {
                            baker.increaseAmountOwned();
                            donutAmount = donutAmount - baker.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            baker.increasePrice();
                        }
                        break;
                    }
                    case 2:{
                        if(donutAmount >= flourSack.getPrice()) {
                            flourSack.increaseAmountOwned();
                            donutAmount = donutAmount - flourSack.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            flourSack.increasePrice();
                        }
                        break;
                    }
                    case 3:{
                        if(donutAmount >= mine.getPrice()) {
                            mine.increaseAmountOwned();
                            donutAmount = donutAmount - mine.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            mine.increasePrice();
                        }
                        break;
                    }
                    case 4:{
                        if(donutAmount >= cloner.getPrice()) {
                            cloner.increaseAmountOwned();
                            donutAmount = donutAmount - cloner.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            cloner.increasePrice();
                        }
                        break;
                    }
                    case 5:{
                        if(donutAmount >= factory.getPrice()) {
                            factory.increaseAmountOwned();
                            donutAmount = donutAmount - factory.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            factory.increasePrice();
                        }
                        break;
                    }
                    case 6:{
                        if(donutAmount >= shrine.getPrice()) {
                            shrine.increaseAmountOwned();
                            donutAmount = donutAmount - shrine.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            shrine.increasePrice();
                        }
                        break;
                    }
                    case 7:{
                        if(donutAmount >= shipment.getPrice()) {
                            shipment.increaseAmountOwned();

                            donutAmount = donutAmount - shipment.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            shipment.increasePrice();
                        }
                        break;
                    }
                    case 8:{
                        if(donutAmount >= portal.getPrice()) {
                            portal.increaseAmountOwned();
                            donutAmount = donutAmount - portal.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            portal.increasePrice();
                        }
                        break;
                    }
                    case 9:{
                        if(donutAmount >= timeMachine.getPrice()) {
                            timeMachine.increaseAmountOwned();
                            donutAmount = donutAmount - timeMachine.getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            timeMachine.increasePrice();
                        }
                        break;
                    }
                    default:
                        break;
                }
                setDonutAmountText(String.valueOf(donutAmount) + " " + getString(R.string.donuts));
                setDonutPerSecondText(String.valueOf(donutPerSecond) + " " + getString(R.string.dps));
                customAdapter.notifyDataSetChanged();
            }
        });
    }//End onStart

    @Override
    public void onBackPressed(){

        //Send values back to main activity
        Intent sendValues = new Intent();
        sendValues.putExtra("updateDonutAmount", donutAmount);
        sendValues.putExtra("updateDonutPerSecond", donutPerSecond);
        setResult(RESULT_OK, sendValues);
        finishActivity(1);
        super.onBackPressed();
    }//End onBackPressed

    @Override
    protected void onPause(){
        super.onPause();
        //Save all values of upgrades owned
        saveAll(savedClicker, "savedClicker");
//        saveAll(savedBaker,  "savedBaker");
//        saveAll(savedFlourSack, "savedFlourSack");
//        saveAll(savedCloner, "savedCloner");
//        saveAll(savedMine, "savedMine");
//        saveAll(savedFactory,  "savedFactory");
//        saveAll(savedShrine, "savedShrinePrice");
//        saveAll(savedShipment, "savedShipmentPrice");
//        saveAll(savedPortal, "savedPortal");
//        saveAll(savedTimeMachine, "saveTimeMachine");
    }//End onPause



    public void setDonutAmountText(String output){
        donutAmountText.setText(output);
    }

    public void setDonutPerSecondText(String output){
        donutPerSecondText.setText(output);
    }

    public void saveAll(SharedPreferences sp, String key){
//        for(PowerUp p : powerUpArray) {
//            sp.edit().putString(key, g.toJson(p)).apply();
//        }
        sp.edit().putString(key, g.toJson(powerUpArray)).apply();
    }

}
