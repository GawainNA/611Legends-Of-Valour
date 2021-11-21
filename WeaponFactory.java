
public class WeaponFactory {
    public static Weapon createWeapon(String name, int price, int level_require, int attack_damage, int ability_power){
        return new Weapon(name, price, level_require, attack_damage, ability_power);
    }
}
