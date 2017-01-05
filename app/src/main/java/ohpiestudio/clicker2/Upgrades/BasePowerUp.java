package ohpiestudio.clicker2.Upgrades;

import android.support.v7.app.AppCompatActivity;

import ohpiestudio.clicker2.R;


abstract class BasePowerUp extends AppCompatActivity {

    public PowerUp clicker = new PowerUp("Clicker", 1, 0);
    public PowerUp baker = new PowerUp("Baker", 2, 0);
    public PowerUp flourSack = new PowerUp("Flour Sack", 3, 0);
    public PowerUp mine = new PowerUp("Mine", 4, 0);
    public PowerUp cloner = new PowerUp("Cloner", 5, 0);
    public PowerUp factory = new PowerUp("Factory", 6, 0);
    public PowerUp shrine = new PowerUp("Shrine", 7, 0);
    public PowerUp shipment = new PowerUp("Shipment", 8, 0);
    public PowerUp portal = new PowerUp("Portal", 9, 0);
    public PowerUp timeMachine = new PowerUp("Time Machine", 10, 0);

    public PowerUp powerUpArray[] ={
            clicker,
            baker,
            flourSack,
            mine,
            cloner,
            factory,
            shrine,
            shipment,
            portal,
            timeMachine
    };

    //Icon Array
    public int powerIcons[] = {
            R.drawable.handico ,
            R.drawable.bakerico,
            R.drawable.sackico,
            R.drawable.mineico,
            R.drawable.clonerico,
            R.drawable.factoryico,
            R.drawable.templeico,
            R.drawable.shipmentico,
            R.drawable.portalico,
            R.drawable.timemachineico
    };

}
