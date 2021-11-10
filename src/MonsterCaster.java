
public class MonsterCaster extends Monster{
    MonsterCaster(String name){
        super(name);
    }

    public static Monster createAMonster(String name,int HP,float dodge,int attack_damage,int ability_power,int attack_resist,int magic_resist,int level){
        MonsterCaster MC = new MonsterCaster(name);
        MC.setHP_capacity(HP);
        MC.setHP_current(HP);
        MC.setDodge_chance(dodge);
        MC.setAttack_damage(attack_damage);
        MC.setAbility_power(ability_power);
        MC.setAttack_resist(attack_resist);
        MC.setMagic_resist(magic_resist);

        return MC;
    }
    public int inflict(Hero hero){
        return Math.max(getAbility_power()-hero.getMagic_resist(),0);
    }
}
