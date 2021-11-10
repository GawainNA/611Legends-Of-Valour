
public class LightingSpell extends Spell{
    public LightingSpell(String name, int price, int level_require,int ability_power,int mana_consume){
        super(name, price, level_require, ability_power, mana_consume);
    }

    @Override
    void Effect(Character NPC) {
        NPC.setDodge_chance((float) (NPC.getDodge_chance()*0.5));
        System.out.println(NPC.getName()+"'s dodge chance is decreased!");
    }
}
