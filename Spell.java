


public abstract class Spell extends Item{
    int ability_power;
    int mana_consume;


    Spell(String name, int price, int level_require,int ability_power,int mana_consume){
        super(name, price, level_require);
        this.ability_power=ability_power;
        this.mana_consume=mana_consume;
    }

    public int getAbility_power(){
        return ability_power;
    }

    public int getMana_consume() {
        return mana_consume;
    }

    public void learn(Hero hero){
        hero.addSpell(this);
        System.out.println(hero.getName()+" grasped "+ name+"!");
    }

    @Override
    public void UseFromBag(Bag bag, Hero hero) {
        if(hero.getLevel()<level_require){
            System.out.println("Level doesn't meet the requirement!");
            return;
        }
        learn(hero);
        bag.remove(this);
    }

    public void printDetail(){
        System.out.println("Price:"+price+"  level requirement:"+level_require+"     Selling Price:"+selling_price);
        System.out.println("Ability_power:"+ability_power+"  mana_consume:"+mana_consume);
    }

    abstract void Effect(Character NPC);

    public void cast(Hero hero, Character NPC){
        hero.reduceMP(mana_consume);
        int damage=ability_power+hero.getAbility_power()-NPC.getMagic_resist();
        NPC.reduceHP(damage);
        System.out.println(hero.getName() +" Caused "+damage+" Magic damage to "+NPC.getName());
        Effect(NPC);
    }


}
