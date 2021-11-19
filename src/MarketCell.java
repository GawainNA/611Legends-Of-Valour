
public class MarketCell extends RPGCell {
    Market market= new Market();

    @Override
    public void cellFunction(Character player){
        market.EnterMarket(player);
    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "M";
    }
}
