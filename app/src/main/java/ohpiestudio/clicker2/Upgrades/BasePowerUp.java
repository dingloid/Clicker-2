package ohpiestudio.clicker2.upgrades;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;

import com.google.gson.Gson;

import ohpiestudio.clicker2.R;


public class BasePowerUp extends AppCompatActivity {

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
    public SharedPreferences savedClickerOwned;
    public SharedPreferences savedBakerOwned;
    public SharedPreferences savedFlourSackOwned;
    public SharedPreferences savedMineOwned;
    public SharedPreferences savedClonerOwned;
    public SharedPreferences savedFactoryOwned;
    public SharedPreferences savedShrineOwned;
    public SharedPreferences savedShipmentOwned;
    public SharedPreferences savedPortalOwned;
    public SharedPreferences savedTimeMachineOwned;

    public PowerUp clicker = new PowerUp("Clicker", getSavedPrice(savedClicker, "savedClickerPrice"), getSavedOwned(savedClickerOwned, "savedClickerOwned"));
    public PowerUp baker = new PowerUp("Baker", 2, 0);
    public PowerUp flourSack = new PowerUp("Flour Sack", 3, 0);
    public PowerUp mine = new PowerUp("Mine", 4, 0);
    public PowerUp cloner = new PowerUp("Cloner", 5, 0);
    public PowerUp factory = new PowerUp("Factory", 6, 0);
    public PowerUp shrine = new PowerUp("Shrine", 7, 0);
    public PowerUp shipment = new PowerUp("Shipment", 8, 0);
    public PowerUp portal = new PowerUp("Portal", 9, 0);
    public PowerUp timeMachine = new PowerUp("Time Machine", 10, 0);

    public long getSavedPrice(SharedPreferences sp, String key){
        return sp.getLong(key, 0);
    }

    public long getSavedOwned(SharedPreferences sp, String key){
        return sp.getLong(key, 0);
    }



    Gson gson = new Gson();

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

    public String shinerBock(Gson g, PowerUp p){
        return g.toJson(p);
    }

    public PowerUp shinerBockNoMore(Gson g, String json){
        return g.fromJson(json, PowerUp.class);
    }

    public long saveObjectOwned(PowerUp p){
        return Long.valueOf(gson.toJson(p.getAmountOwned()));
    }

    public long savedObjectPrice(PowerUp p){
        return Long.valueOf(gson.toJson(p.getPrice()));
    }

    public void saveAll(SharedPreferences sp, SharedPreferences sp2, String key, String key2){
        for(PowerUp p : powerUpArray) {
            sp.edit().putLong(key, savedObjectPrice(p)).apply();
            sp2.edit().putLong(key2,saveObjectOwned(p)).apply();
        }
    }

//              __
//            <(o )___
//             ( ._> /
//              `---'
//    RUBBER DUCKY BLESS ME PLEASE
}
