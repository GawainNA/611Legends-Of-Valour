
public class SpellFactory {

    public static Spell createIceSpell(String name, int price, int level_require,int ability_power,int mana_consume){
        return new IceSpell(name, price, level_require, ability_power, mana_consume);
    }
    public static Spell createFireSpell(String name, int price, int level_require,int ability_power,int mana_consume){
        return new FireSpell(name, price, level_require, ability_power, mana_consume);
    }
    public static Spell createLightSpell(String name, int price, int level_require,int ability_power,int mana_consume){
        return new LightingSpell(name, price, level_require, ability_power, mana_consume);
    }

}
