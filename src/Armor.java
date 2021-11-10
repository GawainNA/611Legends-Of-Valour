
public class Armor extends Equipment<Armor> {
    int attack_resist;
    int magic_resist;

    Armor(String name, int price, int level_require,int attack_resist,int magic_resist){
        super(name,price,level_require);
        this.attack_resist=attack_resist;
        this.magic_resist=magic_resist;
    }

    public static Armor createArmor(String name, int price, int level_require,int attack_resist,int magic_resist){
        return new Armor(name, price, level_require, attack_resist, magic_resist);
    }

    public Armor equip(Hero hero){
        Armor replaced = hero.getArmor();
        hero.setArmor(this);
        hero.setMagic_resist(hero.getMagic_resist() - replaced.getMagic_resist() + magic_resist);
        hero.setAttack_resist(hero.getAttack_resist() - replaced.getAttack_resist() + attack_resist);
        return replaced;
    }

    public void printDetail(){
        System.out.println("Price:"+price+"  level requirement:"+level_require+"     Selling Price:"+selling_price);
        System.out.println("Attack Resist:"+attack_resist+"  Magic Resist:"+magic_resist);
    }

    public int getAttack_resist() {
        return attack_resist;
    }

    public int getMagic_resist() {
        return magic_resist;
    }
}
