
public class Weapon extends Equipment<Weapon>{
    int attack_damage;
    int ability_power;

    Weapon(String name, int price, int level_require, int attack_damage, int ability_power){
        super(name, price, level_require);
        this.attack_damage=attack_damage;
        this.ability_power=ability_power;
    }

    public static Weapon createWeapon(String name, int price, int level_require, int attack_damage, int ability_power){
        return new Weapon(name, price, level_require, attack_damage, ability_power);
    }

    @Override
    public Weapon equip(Hero hero) {
        Weapon replaced = hero.getWeapon();
        hero.setWeapon(this);
        hero.setAbility_power(hero.getAbility_power()-replaced.getAbility_power() + ability_power);
        hero.setAttack_damage(hero.getAttack_damage()-replaced.getAttack_damage() + attack_damage);
        return replaced;
    }

    public void printDetail(){

    }

    public int getAttack_damage() {
        return attack_damage;
    }

    public int getAbility_power() {
        return ability_power;
    }
}
