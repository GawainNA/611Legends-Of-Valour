

public abstract class Character {
    String name;
    int HP_capacity;
    int HP_current;
    float dodge_chance;
    int attack_damage;
    int ability_power;
    int attack_resist;
    int magic_resist;
    int level;

    Character(String name){
        this.name=name;
    }

    public void getHeal(int heal){
        HP_current+=heal;
    }

    //Get and Set method
    public int getAbility_power() {return ability_power;}

    public int getMagic_resist() {return magic_resist;}

    public String getName() {return name;}

    public float getDodge_chance() {return dodge_chance;}

    public int getHP_capacity() {return HP_capacity;}

    public int getHP_current() {return HP_current;}

    public int getAttack_damage() {return attack_damage;}

    public int getAttack_resist() {return attack_resist;}

    public int getLevel() {return level;}

    public void setMagic_resist(int magic_resist) {this.magic_resist = magic_resist;}

    public void setAbility_power(int ability_power) {this.ability_power = ability_power;}

    public void setAttack_resist(int attack_resist) {this.attack_resist = attack_resist;}

    public void setAttack_damage(int attack_damage) {this.attack_damage = attack_damage;}

    public void setDodge_chance(float dodge_chance) {this.dodge_chance = dodge_chance;}

    public void setHP_capacity(int HP_capacity) {this.HP_capacity = HP_capacity;}

    public void setHP_current(int HP_current) {this.HP_current = HP_current;}

    public void reduceHP(int damage){
        if(HP_current<damage){
            HP_current=0;
        }else {
            HP_current-=damage;
        }
    }

}
