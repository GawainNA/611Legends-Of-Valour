
public class Weapon extends Equipment<Weapon>{
    int attack_damage;
    int ability_power;

    Weapon(String name, int price, int level_require, int attack_damage, int ability_power){
        super(name, price, level_require);
        this.attack_damage=attack_damage;
        this.ability_power=ability_power;
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
        System.out.println("Price:"+price+"  level requirement:"+level_require+"     Selling Price:"+selling_price);
        System.out.println("Attack Damage:"+attack_damage+"  Ability Power:"+ability_power);
    }

    public int getAttack_damage() {
        return attack_damage;
    }

    public int getAbility_power() {
        return ability_power;
    }
}
