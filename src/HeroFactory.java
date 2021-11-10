
public class HeroFactory {
    public static Hero createCaster(String[] data){
        Caster hero = new Caster(data[0]);

        hero.dodge_chance=Float.parseFloat(data[1]);
        hero.DC_uprate=Float.parseFloat(data[2]);
        hero.HP_capacity=Integer.parseInt(data[3]);
        hero.HP_current=hero.HP_capacity;
        hero.attack_damage=Integer.parseInt(data[4]);
        hero.ability_power=Integer.parseInt(data[5]);
        hero.attack_resist=Integer.parseInt(data[6]);
        hero.magic_resist=Integer.parseInt(data[7]);
        hero.MP_capacity=Integer.parseInt(data[8]);
        hero.MP_current=hero.MP_capacity;
        hero.AD_uprate=Integer.parseInt(data[9]);
        hero.AP_uprate=Integer.parseInt(data[10]);
        hero.AR_uprate=Integer.parseInt(data[11]);
        hero.MR_uprate=Integer.parseInt(data[12]);
        hero.HP_uprate=Integer.parseInt(data[13]);
        hero.MP_uprate=Integer.parseInt(data[14]);

        return hero;
    }

    public static Hero createWarrior(String[] data){
        Warrior hero = new Warrior(data[0]);

        hero.dodge_chance=Float.parseFloat(data[1]);
        hero.DC_uprate=Float.parseFloat(data[2]);
        hero.HP_capacity=Integer.parseInt(data[3]);
        hero.HP_current=hero.HP_capacity;
        hero.attack_damage=Integer.parseInt(data[4]);
        hero.ability_power=Integer.parseInt(data[5]);
        hero.attack_resist=Integer.parseInt(data[6]);
        hero.magic_resist=Integer.parseInt(data[7]);
        hero.MP_capacity=Integer.parseInt(data[8]);
        hero.MP_current=hero.MP_capacity;
        hero.AD_uprate=Integer.parseInt(data[9]);
        hero.AP_uprate=Integer.parseInt(data[10]);
        hero.AR_uprate=Integer.parseInt(data[11]);
        hero.MR_uprate=Integer.parseInt(data[12]);
        hero.HP_uprate=Integer.parseInt(data[13]);
        hero.MP_uprate=Integer.parseInt(data[14]);

        return hero;
    }

    public static Hero createTank(String[] data){
        Tank hero = new Tank(data[0]);

        hero.dodge_chance=Float.parseFloat(data[1]);
        hero.DC_uprate=Float.parseFloat(data[2]);
        hero.HP_capacity=Integer.parseInt(data[3]);
        hero.HP_current=hero.HP_capacity;
        hero.attack_damage=Integer.parseInt(data[4]);
        hero.ability_power=Integer.parseInt(data[5]);
        hero.attack_resist=Integer.parseInt(data[6]);
        hero.magic_resist=Integer.parseInt(data[7]);
        hero.MP_capacity=Integer.parseInt(data[8]);
        hero.MP_current=hero.MP_capacity;
        hero.AD_uprate=Integer.parseInt(data[9]);
        hero.AP_uprate=Integer.parseInt(data[10]);
        hero.AR_uprate=Integer.parseInt(data[11]);
        hero.MR_uprate=Integer.parseInt(data[12]);
        hero.HP_uprate=Integer.parseInt(data[13]);
        hero.MP_uprate=Integer.parseInt(data[14]);

        return hero;
    }

}
