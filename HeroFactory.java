
public class HeroFactory {
    public static Hero createCaster(String[] data){
        Caster hero = new Caster(data[0]);

        hero.MP_capacity=Integer.parseInt(data[1]);
        hero.MP_current=hero.MP_capacity;
        hero.attack_damage=Integer.parseInt(data[2]);
        hero.ability_power=Integer.parseInt(data[3]);
        hero.dodge_chance=Double.parseDouble(data[4])/100;
        hero.money=Integer.parseInt(data[5]);
        hero.HP_capacity=Integer.parseInt(data[6])*100;
        hero.HP_current=hero.HP_capacity;

        return hero;
    }

    public static Hero createWarrior(String[] data){
        Warrior hero = new Warrior(data[0]);

        hero.MP_capacity=Integer.parseInt(data[1]);
        hero.MP_current=hero.MP_capacity;
        hero.attack_damage=Integer.parseInt(data[2]);
        hero.ability_power=Integer.parseInt(data[3]);
        hero.dodge_chance=Double.parseDouble(data[4])/100;
        hero.money=Integer.parseInt(data[5]);
        hero.HP_capacity=Integer.parseInt(data[6])*100;
        hero.HP_current=hero.HP_capacity;

        return hero;
    }

    public static Hero createTank(String[] data){
        Tank hero = new Tank(data[0]);

        hero.MP_capacity=Integer.parseInt(data[1]);
        hero.MP_current=hero.MP_capacity;
        hero.attack_damage=Integer.parseInt(data[2]);
        hero.ability_power=Integer.parseInt(data[3]);
        hero.dodge_chance=Double.parseDouble(data[4])/100;
        hero.money=Integer.parseInt(data[5]);
        hero.HP_capacity=Integer.parseInt(data[6])*100;
        hero.HP_current=hero.HP_capacity;

        return hero;
    }

}
