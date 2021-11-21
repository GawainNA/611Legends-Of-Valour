
public class MonsterFactory {

    public static Monster createDragon(String[] data){
        Dragon dragon = new Dragon(data[0]);
        dragon.setHP_capacity(Integer.parseInt(data[1])*100);
        dragon.setHP_current(Integer.parseInt(data[1])*100);
        dragon.setAttack_damage(Integer.parseInt(data[2]));
        dragon.setAbility_power(Integer.parseInt(data[3]));
        dragon.setAttack_resist(Integer.parseInt(data[4]));
        dragon.setMagic_resist(Integer.parseInt(data[5]));
        dragon.setDodge_chance(Double.parseDouble(data[6])/100);

        return dragon;
    }

    public static Monster createMonsterCaster(String[] data){
        MonsterCaster dragon = new MonsterCaster(data[0]);
        dragon.setHP_capacity(Integer.parseInt(data[1])*100);
        dragon.setHP_current(Integer.parseInt(data[1])*100);
        dragon.setAttack_damage(Integer.parseInt(data[2]));
        dragon.setAbility_power(Integer.parseInt(data[3]));
        dragon.setAttack_resist(Integer.parseInt(data[4]));
        dragon.setMagic_resist(Integer.parseInt(data[5]));
        dragon.setDodge_chance(Double.parseDouble(data[6])/100);

        return dragon;
    }

    public static Monster createMonsterFighter(String[] data){
        MonsterFighter dragon = new MonsterFighter(data[0]);
        dragon.setHP_capacity(Integer.parseInt(data[1])*100);
        dragon.setHP_current(Integer.parseInt(data[1])*100);
        dragon.setAttack_damage(Integer.parseInt(data[2]));
        dragon.setAbility_power(Integer.parseInt(data[3]));
        dragon.setAttack_resist(Integer.parseInt(data[4]));
        dragon.setMagic_resist(Integer.parseInt(data[5]));
        dragon.setDodge_chance(Double.parseDouble(data[6])/100);

        return dragon;
    }

}
