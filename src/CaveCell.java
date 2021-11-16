public class CaveCell extends RPGCell{
    @Override
    public void inCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            hero.setDodge_chance((float) (hero.getDodge_chance()*1.1));
        }
    }

    public void outCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            hero.setDodge_chance((float)(hero.getDodge_chance()/1.1));
        }
    }

    @Override
    public String toString() {
        if(isHeroLocated){
            return "*";
        }
        return " ";
    }
}
