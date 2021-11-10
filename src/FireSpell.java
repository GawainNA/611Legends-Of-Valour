

public class FireSpell extends Spell{

    public FireSpell(String name, int price, int level_require,int ability_power,int mana_consume){
        super(name, price, level_require, ability_power, mana_consume);
    }

    @Override
    void Effect(Character NPC) {
        NPC.setMagic_resist((int)(NPC.getMagic_resist()*0.7));
        NPC.setAttack_resist((int)(NPC.getAttack_resist()*0.7));
        System.out.println(NPC.getName()+"'s defense is decreased!");
    }
}
