
import java.util.ArrayList;

public class Hero extends Character {

    int money=100;
    Bag bag=new Bag();
    Armor armor;
    Weapon weapon;
    ArrayList<Spell> spells=new ArrayList<>();

    int obvious=10;
    int MP_capacity;
    int MP_current;
    int exp_expectation=100;
    int exp_current=0;

    int AD_uprate;
    int AP_uprate;
    float DC_uprate;
    int AR_uprate;
    int MR_uprate;
    int HP_uprate;
    int MP_uprate;

    Hero(String name){
        super(name);
        level=1;
        armor=Armor.createArmor("Usual Coat",0,0,1,1);
        weapon=Weapon.createWeapon("Stick",0,0,1,1);
    }

    public static Hero createHero(String[] data){
        Hero hero = new Hero(data[0]);

        hero.dodge_chance=Float.parseFloat(data[1]);
        hero.DC_uprate=Float.parseFloat(data[2]);
        hero.HP_capacity=Integer.parseInt(data[3]);
        hero.HP_current=hero.HP_capacity;
        hero.attack_damage=Integer.parseInt(data[4]);
        hero.ability_power=Integer.parseInt(data[5]);
        hero.attack_resist=Integer.parseInt(data[6]);
        hero.magic_resist=Integer.parseInt(data[7]);
        hero.MP_capacity=Integer.parseInt(data[8]);
        hero.MP_current=hero.MP_capacity;
        hero.AD_uprate=Integer.parseInt(data[9]);
        hero.AP_uprate=Integer.parseInt(data[10]);
        hero.AR_uprate=Integer.parseInt(data[11]);
        hero.MR_uprate=Integer.parseInt(data[12]);
        hero.HP_uprate=Integer.parseInt(data[13]);
        hero.MP_uprate=Integer.parseInt(data[14]);

        return hero;
    }

    public void setWeapon(Weapon weapon){this.weapon=weapon;}
    public Weapon getWeapon(){return weapon;}

    public void setArmor(Armor armor){this.armor=armor;}
    public Armor getArmor(){return armor;}

    public int getMP_capacity(){
        return MP_capacity;
    }

    public int getMP_current() {
        return MP_current;
    }

    public int getExp_current() {
        return exp_current;
    }

    public int getExp_expectation() {
        return exp_expectation;
    }

    public boolean addExp(int exp){
        exp_current+=exp;
        if( exp_current >= exp_expectation ){
            exp_current -= exp_expectation;
            exp_expectation+=100;
            levelUP();
            return true;
        }
        else return false;
    }

    void levelUP(){
        level+=1;
        attack_damage += AD_uprate;
        ability_power += AP_uprate;
        attack_resist += AR_uprate;
        magic_resist += MR_uprate;
        dodge_chance += DC_uprate;
        HP_capacity += HP_uprate;
        MP_capacity += MP_uprate;
        if(HP_current < HP_capacity){
            HP_current = HP_capacity;
        }
        if(MP_current < MP_capacity){
            MP_current = MP_capacity;
        }
    }

    public void recover(){
        HP_current+=(int)(HP_capacity*0.1);
        MP_current+=(int)(MP_capacity*0.1);
        if(HP_current>HP_capacity){
            HP_current=HP_capacity;
        }
        if(MP_current>MP_capacity){
            MP_current=MP_capacity;
        }
    }

    public Spell getSpell(int index){
        return spells.get(index);
    }

    public ArrayList<Spell> getSpells(){
        return spells;
    }

    public void printSpell(){
        if(spells.isEmpty()){
            System.out.println("You don't have any Spells now!");
            return;
        }
        String result="";
        for(int i=1;i<=spells.size();i++){
            result=result.concat(i+". "+spells.get(i-1).getName()+"   ");
        }
        System.out.println(result);
    }

    public void cast(Spell spell,Character NPC){
        spell.cast(this,NPC);
    }

    public void addSpell(Spell spell){
        spells.add(spell);
    }

    public void reduceMP(int reduce){
        MP_current-=reduce;
    }

    public void recoverMP(int amount){
        MP_current+=amount;
    }

    public int getMoney(){
        return money;
    }

    public void addMoney(int add){
        money+=add;
    }

    public void loseMoney(int lose){
        money-=lose;
    }

    public void addItem(Item item){
        bag.add(item);
    }

    public void removeItem(Item item){
        bag.remove(item);
    }

    public void printBag(){
        bag.printContent();
    }

    public Bag getBag(){
        return bag;
    }

    public boolean isBagEmpty(){
        return bag.content.isEmpty();
    }

    public Item getItemFromBag(int index){
        return bag.get(index);
    }

    public int getBagSize(){
        return bag.size();
    }

}
