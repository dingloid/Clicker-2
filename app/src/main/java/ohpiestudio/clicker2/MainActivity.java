package ohpiestudio.clicker2;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.CountDownTimer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import ohpiestudio.clicker2.Screens.Shop;
import ohpiestudio.clicker2.Screens.SkinShop;

public class MainActivity extends AppCompatActivity {
    //Variables
    private long donutAmount = 0;
    private double clickPower = Math.round(donutAmount * 0.02);
    private long donutPerSecond = 1;
    //GUI Widgets
    private TextView donutAmountText;
    private TextView donutPerSecondText;

    //Other stuff
    private CountDownTimer timer;
    private static final String PREFS_NAME = "DonutClickerPrefs";
    static final int INT_CODE = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
        //Load Values from shared preferences
        SharedPreferences donutDetails = getSharedPreferences(PREFS_NAME ,Context.MODE_PRIVATE);
        donutAmount = donutDetails.getLong("donutAmount", donutAmount);
        donutPerSecond = donutDetails.getLong("donutPerSecond", donutPerSecond);
    }//End onCreate

    @Override
    protected void onStart(){
        super.onStart();
        final ImageView donut = (ImageView) findViewById(R.id.donut);
        donutAmountText = (TextView) findViewById(R.id.donutAmountText);
        donutPerSecondText = (TextView) findViewById(R.id.donutPerSecondText);
        ImageView toShop = (ImageView) findViewById(R.id.toShop);
        ImageView toSkinShop = (ImageView) findViewById(R.id.toSkinShop);

        //Load Values
        setDonutPerSecond(String.valueOf(donutPerSecond) + " " + getString(R.string.dps));

        //Donuts Per Second Loop
        timer = new CountDownTimer(1000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
            }
            @Override
            public void onFinish() {
                try{
                    startLoop();
                }catch(Exception e){
                    Log.e("Error", "Error: " + e.toString());
                }
            }
            private void startLoop() {
                setDonutAmount(String.valueOf(donutAmount = donutAmount + donutPerSecond) + " " + getString(R.string.donuts));
                timer.start();
            }
        }.start();

        //Click Event for Donut Image
        donut.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent event){
                //Make donut big
                float scaleClick = 0.8f;
                //Make donut small
                float scaleRelease = 0.75f;

                if(event.getAction() == MotionEvent.ACTION_DOWN ){
                    v.setScaleX(scaleClick);
                    v.setScaleY(scaleClick);
                    if(clickPower < 1) {
                        setDonutAmount(String.valueOf(donutAmount += 1) + " " + getString(R.string.donuts));

                    } else {
                        setDonutAmount(String.valueOf(donutAmount += clickPower) + " " + getString(R.string.donuts));
                    }
                    return true;
                }
                else if(event.getAction() == MotionEvent.ACTION_UP){
                    v.setScaleX(scaleRelease);
                    v.setScaleY(scaleRelease);
                }
                return false;
            }
        });//End of Click Event

        toShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), Shop.class);
                i.putExtra("donutAmount", donutAmount);
                i.putExtra("donutPerSecond", donutPerSecond);
                timer.cancel();
                startActivityForResult(i, 1);
            }
        });

        toSkinShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(), SkinShop.class);
                i.putExtra("donutAmount", donutAmount);
                timer.cancel();
                startActivityForResult(i, 1);
            }
        });
    }//End onStart

    @Override
    protected void onPause(){
        super.onPause();
        //Save Values into shared preferences
        SharedPreferences donutDetails = getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
        SharedPreferences.Editor donutDetailsEdit = donutDetails.edit();
        donutDetailsEdit.putLong("donutAmount", donutAmount).apply();
        donutDetailsEdit.putLong("donutPerSecond", donutPerSecond).apply();

        timer.cancel();
    }//End onPause

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode == INT_CODE){
            if(resultCode == RESULT_OK){
                donutAmount = data.getLongExtra("updateDonutAmount", 0);
                donutPerSecond = data.getLongExtra("updateDonutPerSecond", 0);

                setDonutAmount(String.valueOf(donutAmount) + " " + getString(R.string.donuts));
                setDonutPerSecond(String.valueOf(donutPerSecond) + " " + getString(R.string.dps));
                //Restart Donut per second
                timer.start();
            }
        }
    }

    @Override
    protected void onStop(){
        super.onStop();
        timer.cancel();
    }//End onStop

    public void setDonutAmount(String donutAmount){
        donutAmountText.setText(donutAmount);
    }

    public void setDonutPerSecond(String dps){
        donutPerSecondText.setText(dps);
    }

}//End
