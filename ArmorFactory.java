import java.util.List;

public class ArmorFactory {

    public static Armor createArmor(String name, int price, int level_require,int attack_resist,int magic_resist){
        return new Armor(name, price, level_require, attack_resist, magic_resist);
    }

}
