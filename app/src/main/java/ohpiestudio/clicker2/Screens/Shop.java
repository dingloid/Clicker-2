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


import ohpiestudio.clicker2.Adapter.CustomAdapter;
import ohpiestudio.clicker2.Upgrades.BasePowerUp;
import ohpiestudio.clicker2.R;



public class Shop extends BasePowerUp {
    //UI
    private TextView donutAmountText;
    private TextView donutPerSecondText;

    //Variables
    private long donutAmount;
    private long donutPerSecond;


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
        Intent getValue = this.getIntent();
        donutAmount = getValue.getLongExtra("donutAmount", donutAmount);
        donutPerSecond = getValue.getLongExtra("donutPerSecond", donutPerSecond);

        //Update Text Fields with donut amount
        setDonutAmountText(String.valueOf(donutAmount) + " " + getString(R.string.donuts));
        setDountPerSecondText(String.valueOf(donutPerSecond) + " " + getString(R.string.dps));

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
                setDountPerSecondText(String.valueOf(donutPerSecond) + " " + getString(R.string.dps));
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
