
public class MonsterFighter extends Monster{
    MonsterFighter(String name){
        super(name);
    }

    public static Monster createAMonster(String name,int HP,float dodge,int attack_damage,int ability_power,int attack_resist,int magic_resist,int level){
        MonsterFighter MF = new MonsterFighter(name);
        MF.setHP_capacity(HP);
        MF.setHP_current(HP);
        MF.setDodge_chance(dodge);
        MF.setAttack_damage(attack_damage);
        MF.setAbility_power(ability_power);
        MF.setAttack_resist(attack_resist);
        MF.setMagic_resist(magic_resist);

        return MF;
    }

    public int inflict(Hero hero){
        return Math.max(getAttack_damage()-hero.getAttack_resist(),0);
    }
}
