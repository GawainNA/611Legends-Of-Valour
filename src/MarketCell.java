
public class MarketCell extends RPGCell {
    Market market= new Market();

    @Override
    public void inCellFunction(Character NPC){
        Hero hero= (Hero) NPC;
        market.EnterMarket(hero);
    }
    public void outCellFunction(Character NPC){

    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "M";
    }
}
