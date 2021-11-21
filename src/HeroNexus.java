public class HeroNexus extends NexusCell{
    Market market=new Market();
    @Override
    public void inCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            market.EnterMarket(hero);
        }else {
            System.out.println("Monster Reached Hero Nexus!!");
        }
    }

    public void outCellFunction(Character NPC){

    }

    @Override
    public String toString() {
        if(isHeroLocated){
            return "*";
        }
        return " ";
    }
}
