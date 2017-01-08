package ohpiestudio.clicker2.Screens;

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


import ohpiestudio.clicker2.Adapter.CustomAdapter;
import ohpiestudio.clicker2.Upgrades.BasePowerUp;
import ohpiestudio.clicker2.R;
import ohpiestudio.clicker2.Upgrades.PowerUp;


public class Shop extends BasePowerUp {
    //UI
    private TextView donutAmountText;
    private TextView donutPerSecondText;

    //Variables
    private long donutAmount;
    private long donutPerSecond;
    Gson gson = new Gson();
    private final String PREFS_NAME = "powerUpDetails";
    private PowerUp powerUpArray[];

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
        SharedPreferences powerUpDetails = getSharedPreferences(PREFS_NAME ,Context.MODE_PRIVATE);
        powerUpArray = gson.fromJson(powerUpDetails.getString("powerUpDetails", ""), PowerUp[].class);

        // powerUpArray was not initialized from shared preferences, need to initialize it to default details
        if(powerUpArray == null) {
            powerUpArray = new PowerUp[] {
                new PowerUp("Clicker", 1, 0),
                new PowerUp("Baker", 2, 0),
                new PowerUp("Flour Sack", 3, 0),
                new PowerUp("Mine", 4, 0),
                new PowerUp("Cloner", 5, 0),
                new PowerUp("Factory", 6, 0),
                new PowerUp("Shrine", 7, 0),
                new PowerUp("Shipment", 8, 0),
                new PowerUp("Portal", 9, 0),
                new PowerUp("Time Machine", 10, 0)
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
                        if(donutAmount >= powerUpArray[0].getPrice()) {
                            powerUpArray[0].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[0].getPrice();
                            donutPerSecond = donutPerSecond + 1;
                            powerUpArray[0].increasePrice();
                            //saveAll(savedClicker, savedClickerOwned, "savedClickerPrice", "savedClickerOwned");
                        }
                        break;
                    }
                    case 1:{
                        if(donutAmount >= powerUpArray[1].getPrice()) {
                            powerUpArray[1].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[1].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[1].increasePrice();
                        }
                        break;
                    }
                    case 2:{
                        if(donutAmount >= powerUpArray[2].getPrice()) {
                            powerUpArray[2].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[2].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[2].increasePrice();
                        }
                        break;
                    }
                    case 3:{
                        if(donutAmount >= powerUpArray[3].getPrice()) {
                            powerUpArray[3].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[3].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[3].increasePrice();
                        }
                        break;
                    }
                    case 4:{
                        if(donutAmount >= powerUpArray[4].getPrice()) {
                            powerUpArray[4].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[4].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[4].increasePrice();
                        }
                        break;
                    }
                    case 5:{
                        if(donutAmount >= powerUpArray[5].getPrice()) {
                            powerUpArray[5].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[5].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[5].increasePrice();
                        }
                        break;
                    }
                    case 6:{
                        if(donutAmount >= powerUpArray[6].getPrice()) {
                            powerUpArray[6].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[6].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[6].increasePrice();
                        }
                        break;
                    }
                    case 7:{
                        if(donutAmount >= powerUpArray[7].getPrice()) {
                            powerUpArray[7].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[7].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[7].increasePrice();
                        }
                        break;
                    }
                    case 8:{
                        if(donutAmount >= powerUpArray[8].getPrice()) {
                            powerUpArray[8].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[8].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[8].increasePrice();
                        }
                        break;
                    }
                    case 9:{
                        if(donutAmount >= powerUpArray[9].getPrice()) {
                            powerUpArray[9].increaseAmountOwned();
                            donutAmount = donutAmount - powerUpArray[9].getPrice();
                            donutPerSecond = donutPerSecond + 4;
                            powerUpArray[9].increasePrice();
                        }
                        break;
                    }
                    default:
                        break;
                }
                saveAll("powerUpDetails");
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
        saveAll("powerUpDetails");
    }//End onPause



    public void setDonutAmountText(String output){
        donutAmountText.setText(output);
    }

    public void setDonutPerSecondText(String output){
        donutPerSecondText.setText(output);
    }

    private void saveAll(String key) {
        SharedPreferences powerUpDetails = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor powerUpDetailsEdit = powerUpDetails.edit();
        powerUpDetailsEdit.putString(key, gson.toJson(powerUpArray)).apply();
    }


}
