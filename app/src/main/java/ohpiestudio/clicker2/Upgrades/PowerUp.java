package ohpiestudio.clicker2.Upgrades;


public class PowerUp {

    private String name;
    private long price;
    private long baseCost;
    private long amountOwned;

    public PowerUp(){

    }

    public PowerUp(String n, long p, long o){
        setName(n);
        setPrice(p);
        setAmountOwned(o);
    }

    public void setName(String n){
        name = n;
    }

    public void setPrice(long p){
        price = p;
    }

    public void setAmountOwned(long o){
        amountOwned = o;
    }

    public void increaseAmountOwned(){
        setAmountOwned(++amountOwned);
    }

    public void increasePrice(){

    }

    public String getName(){
        return name;
    }

    public long getPrice(){
        return price;
    }

    public long getAmountOwned(){
        return amountOwned;
    }



}
