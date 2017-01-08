package ohpiestudio.clicker2.screens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;

import ohpiestudio.clicker2.R;

public class SkinShop extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.supportRequestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_skin_shop);
    }

    @Override
    protected void onStart(){
        super.onStart();
    }

    @Override
    public void onBackPressed(){

    }

    @Override
    protected void onPause(){
        super.onPause();
    }
}
