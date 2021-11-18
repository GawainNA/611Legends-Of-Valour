
public abstract class Monster extends Character{
    Monster(String name){
        super(name);
    }
    public abstract int inflict(Hero hero);

    public int getDamage() {
        return attack_damage+ability_power;
    }

    @Override
    public int getDefense() {
        return attack_resist+magic_resist;
    }

    @Override
    public double getDodge() {
        return dodge_chance;
    }

}
