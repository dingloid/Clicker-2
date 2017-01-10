package ohpiestudio.clicker2.Upgrades;

public class Skins extends PowerUp{

    private boolean isUnlocked = false;
    private String description;

    public Skins(){

    }

    public Skins(String n, long p, String d, boolean t){
        setName(n);
        setPrice(p);
        setDescription(d);
        setUnlocked(false);
    }

    public void setDescription(String d){
        description = d;
    }

    public String getDescription(){
        return description;
    }

    public void setUnlocked(boolean t){
        isUnlocked = t;
    }
}
