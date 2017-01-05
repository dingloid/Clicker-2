package ohpiestudio.clicker2.Upgrades;

public class Skins extends PowerUp{

    private boolean isUnlocked = false;

    public Skins(){

    }

    public Skins(String n, long p, boolean t){
        setName(n);
        setPrice(p);
        setUnlocked(false);
    }

    public void setUnlocked(boolean t){
        isUnlocked = t;
    }
}
