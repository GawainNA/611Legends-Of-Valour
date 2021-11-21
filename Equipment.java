

public abstract class Equipment<T extends Item> extends Item implements Equipable<T>{
    Equipment(String name, int price, int level_require){
        super(name, price, level_require);
    }

    @Override
    public void UseFromBag(Bag bag, Hero hero) {
        T replaced = equip(hero);
        bag.remove(this);
        bag.add(replaced);
    }
}
