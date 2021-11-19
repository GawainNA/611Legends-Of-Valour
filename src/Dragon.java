

public class Dragon extends Monster{
    Dragon(String name){
        super(name);
    }



    public int inflict(Hero hero){
        return Math.max(getAbility_power()+getAttack_damage()-hero.getAttack_resist()-hero.getMagic_resist(),0);
    }
}
