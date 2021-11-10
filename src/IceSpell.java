

public class IceSpell extends Spell{
    public IceSpell(String name, int price, int level_require,int ability_power,int mana_consume){
        super(name, price, level_require, ability_power, mana_consume);
    }

    @Override
    void Effect(Character NPC) {
        NPC.setAbility_power((int)(NPC.getAbility_power()*0.7));
        NPC.setAttack_damage((int)(NPC.getAttack_damage()*0.7));
        System.out.println(NPC.getName()+"'s damage is decreased!");
    }

}
