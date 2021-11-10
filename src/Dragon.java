

public class Dragon extends Monster{
    Dragon(String name){
        super(name);
    }

    public static Monster createAMonster(String name,int HP,float dodge,int attack_damage,int ability_power,int attack_resist,int magic_resist,int level){
        Dragon dragon = new Dragon(name);
        dragon.setHP_capacity(HP);
        dragon.setHP_current(HP);
        dragon.setDodge_chance(dodge);
        dragon.setAttack_damage(attack_damage);
        dragon.setAbility_power(ability_power);
        dragon.setAttack_resist(attack_resist);
        dragon.setMagic_resist(magic_resist);

        return dragon;
    }


    public int inflict(Hero hero){
        return Math.max(getAbility_power()+getAttack_damage()-hero.getAttack_resist()-hero.getMagic_resist(),0);
    }
}
