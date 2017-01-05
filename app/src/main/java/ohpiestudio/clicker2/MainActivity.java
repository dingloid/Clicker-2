package ohpiestudio.clicker2;

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
import java.util.Locale;
import ohpiestudio.clicker2.Screens.Shop;


public class MainActivity extends AppCompatActivity {
    //Variables
    private double donutAmount = 0.0;
    private double clickPower = 1.0;
    private double donutPerSecond = 0.1;
    //GUI Widgets
    private TextView donutAmountText;
    private TextView donutPerSecondText;

    //Other stuff
    private CountDownTimer timer;
    SharedPreferences savedAmount;
    SharedPreferences savedDPS;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart(){
        super.onStart();
        final ImageView donut = (ImageView) findViewById(R.id.donut);
        donutAmountText = (TextView) findViewById(R.id.donutAmountText);
        donutPerSecondText = (TextView) findViewById(R.id.donutPerSecondText);
        Button toShop = (Button) findViewById(R.id.button);

        //Load Values
        setDonutPerSecond(String.format(Locale.getDefault(), "%.1f", donutPerSecond) + " " + getString(R.string.dps));

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
                setDonutAmount(String.format(Locale.getDefault(), "%.1f", donutAmount = donutAmount + donutPerSecond) + " " + getString(R.string.donuts));
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
                    setDonutAmount(String.format(Locale.getDefault(), "%.1f", donutAmount += clickPower) + " " + getString(R.string.donuts));
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
                startActivity(i);
            }
        });
    }//End onStart

    @Override
    protected void onPause(){
        super.onPause();
    }//End onPause

    public void setDonutAmount(String donutAmount){
        donutAmountText.setText(donutAmount);
    }

    public void setDonutPerSecond(String dps){
        donutPerSecondText.setText(dps);
    }
}//End
