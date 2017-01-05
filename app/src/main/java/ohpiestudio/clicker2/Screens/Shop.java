package ohpiestudio.clicker2.Screens;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.MobileAds;


import java.util.Locale;

import ohpiestudio.clicker2.Adapter.CustomAdapter;
import ohpiestudio.clicker2.Upgrades.BasePowerUp;
import ohpiestudio.clicker2.R;

public class Shop extends BasePowerUp {
    //UI
    private TextView donutAmountText;
    private TextView donutPerSecondText;

    //Variables
    private double donutAmount;
    private double donutPerSecond;

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
//
//
        AdView mAdView = (AdView) findViewById(R.id.adView);
//        AdRequest request = new AdRequest.Builder()
//                .addTestDevice(AdRequest.DEVICE_ID_EMULATOR)        // All emulators
//                .addTestDevice("5A123D239B16B42078ABB18A091B4B57")  // An example device ID
//                .build();
        AdRequest adRequest = new AdRequest.Builder().build();
        mAdView.loadAd(adRequest);

        //Get Intent from Main Activity
        Intent getDouble = this.getIntent();
        donutAmount = getDouble.getDoubleExtra("donutAmount", donutAmount);

        //Update Text Fields with donut amount
        setDonutAmountText(String.format(Locale.getDefault(), "%.1f", donutAmount) + " " + getString(R.string.donuts));

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
                        clicker.increaseAmountOwned();
                        //clicker.increasePrice()
                        break;
                    }
                    case 1:{
                        baker.increaseAmountOwned();
                        break;
                    }
                    default:
                        break;
                }
                customAdapter.notifyDataSetChanged();
            }
        });
    }//End onStart

    @Override
    public void onBackPressed(){
        //Send values back to main activity
        Intent sendValues = new Intent();
        sendValues.putExtra("updateDonutAmount", donutAmount);
        sendValues.putExtra("updateDonutsPerSecond", donutPerSecond);
        setResult(RESULT_OK, sendValues);
        finish();
    }//End onBackPressed

    @Override
    protected void onPause(){
        super.onPause();
    }//End onPause

    public void setDonutAmountText(String output){
        donutAmountText.setText(output);
    }

    public void setDountPerSecondText(String output){
        donutPerSecondText.setText(output);
    }
}
