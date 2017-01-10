package ohpiestudio.clicker2.Screens;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
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

import ohpiestudio.clicker2.Adapter.SkinsAdapter;
import ohpiestudio.clicker2.R;
import ohpiestudio.clicker2.Upgrades.Skins;

public class SkinShop extends AppCompatActivity {

    //UI
    private TextView donutAmountText;

    private final String PREFS_NAME = "skinDetails";

    Gson gson = new Gson();
    private long donutAmount;
    private long donutPerSecond;
    private Skins skinArray[];

    public enum skinType {DEFAULT(0) , PINK_DONUT(1), COOKIE(2);
        private final int i;
        skinType(int i) {
            this.i = i;
        }

        public int getValue(){
            return i;
        }

        public static skinType fromInt(int i){
            switch (i){
                case 0:{
                    return DEFAULT;
                }
                case 1: {
                    return PINK_DONUT;
                }
                case 3:{
                    return COOKIE;
                }
            }
            return null;
        }
    }

    private skinType selectedSkin = skinType.DEFAULT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_skin_shop);
        donutAmountText = (TextView) findViewById(R.id.donutAmountText);
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

        Intent getValue = this.getIntent();
        donutAmount = getValue.getLongExtra("donutAmount", donutAmount);
        donutPerSecond = getValue.getLongExtra("donutPerSecond", donutPerSecond);

        setDonutAmountText(String.valueOf(donutAmount + " " + getString(R.string.donuts)));

        int skinIcons[] = {
                R.drawable.defaultdonutico,
                R.drawable.pinkdonutico,
                R.drawable.cookieico
        };

        final SharedPreferences skinDetails = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        skinArray = gson.fromJson(skinDetails.getString("skinDetails", ""), Skins[].class);
        if(skinArray == null){
            skinArray = new Skins[] {
                    new Skins("Donut", 0, "Default Skin", true),
                    new Skins("Pink Donut", 100, "", false),
                    new Skins("Cookie", 10000000, "The original clicker", false)
            };
        }

        //Init list view
        final ListView listView = (ListView) findViewById(R.id.listView);

        final SkinsAdapter skinsAdapter = new SkinsAdapter(getApplicationContext(), skinIcons, skinArray );
        listView.setAdapter(skinsAdapter);

        //On click
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0: {
                        selectedSkin = skinType.DEFAULT;
                        break;
                    }
                    case 1: {
                        if(!skinArray[i].getUnlocked()){
                            if(donutAmount >= skinArray[i].getPrice()) {
                                donutAmount = donutAmount - skinArray[i].getPrice();
                                skinArray[i].setUnlocked(true);
                            }
                        }
                        if(skinArray[i].getUnlocked()){
                            selectedSkin = skinType.PINK_DONUT;
                        }
                        break;
                    }
                    default:
                        break;
                }
                saveAll("skinDetails");
                setDonutAmountText(String.valueOf(donutAmount) + " " + getString(R.string.donuts));
            }
        });
    }//End onStart

    @Override
    public void onBackPressed(){
        Intent sendValues = new Intent();
        sendValues.putExtra("updateDonutAmount", donutAmount);
        sendValues.putExtra("updateDonutPerSecond", donutPerSecond);
        sendValues.putExtra("skinSelected", selectedSkin );
        setResult(RESULT_OK, sendValues);
        finishActivity(2);
        super.onBackPressed();
    }//End onBackPressed

    @Override
    protected void onPause(){
        saveAll("skinDetails");
        super.onPause();
    }//End onPause

    public void setDonutAmountText(String output){
        donutAmountText.setText(output);
    }

    public void saveAll(String key) {
        SharedPreferences skinDetails = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor skinDetailsEdit = skinDetails.edit();
        skinDetailsEdit.putString(key, gson.toJson(skinArray)).apply();
    }
}//End

