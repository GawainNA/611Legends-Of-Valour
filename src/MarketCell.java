
public class MarketCell extends RPGCell {
    Market market= new Market();

    @Override
<<<<<<< HEAD
    public void cellFunction(Character player){
        market.EnterMarket(player);
=======
    public void inCellFunction(Character NPC){
        Hero hero= (Hero) NPC;
        market.EnterMarket(hero);
    }
    public void outCellFunction(Character NPC){

>>>>>>> main
    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "M";
    }
}
