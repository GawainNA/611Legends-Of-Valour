
public class ArmorFactory {

    public Item createItem(String name, int price, int level_require, int attack_resist, int magic_resist){
        Armor armor=new Armor(name,price,level_require,attack_resist,magic_resist);
        return armor;
    }

}
