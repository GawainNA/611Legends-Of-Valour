public class BushCell extends RPGCell{
    @Override
    public void inCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            hero.setAbility_power((int)(hero.getAbility_power()*1.1));
        }
    }

    public void outCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            hero.setAbility_power((int)(hero.getAbility_power()/1.1));
        }
    }

    @Override
    public String toString() {
        return " ";
    }
}
