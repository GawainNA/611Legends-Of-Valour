

public abstract class ConsumableItem extends Item implements Consumable{

    ConsumableItem(String name, int price, int level_require){
        super(name, price, level_require);
    }

    @Override
    public void UseFromBag(Bag bag, Hero hero) {
        if(hero.getLevel()<level_require){
            System.out.println("Level doesn't meet the requirement!");
            return;
        }
        consume(hero);
        bag.remove(this);
    }
}
