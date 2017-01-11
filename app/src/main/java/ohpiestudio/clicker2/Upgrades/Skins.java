package ohpiestudio.clicker2.Upgrades;

public class Skins extends PowerUp{

    private boolean isUnlocked = false;
    private String description;
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

    public Skins.skinType skin;

    public Skins(){

    }

    public Skins(String n, long p, String d, boolean t, Skins.skinType skin){
        setName(n);
        setPrice(p);
        setDescription(d);
        setUnlocked(t);
        setSkin(skin);
    }

    public void setSkin(Skins.skinType e){
        skin = e;
    }

    public Skins.skinType getSkin(){
        return skin;
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

    public boolean getUnlocked(){
        return isUnlocked;
    }
}
