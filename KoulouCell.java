public class KoulouCell extends RPGCell{
    @Override
    public void inCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            hero.setAttack_damage((int)(hero.getAttack_damage()*1.1));
        }
    }

    public void outCellFunction(Character NPC){
        if(NPC instanceof Hero){
            Hero hero=(Hero) NPC;
            hero.setAttack_damage((int)(hero.getAttack_damage()/1.1));
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
