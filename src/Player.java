import java.util.ArrayList;

public class Player {
    Bag bag=new Bag();
    int money = 1000;
    String name;
    public ArrayList<Hero> heroes= new ArrayList<Hero>();

    Player(String name){
        this.name=name;
    }
    public static Player createPlayer(String name){
        return new Player(name);
    }

    public void addHero(Hero hero){
        heroes.add(hero);
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

    public void printHeroList(){
        for(int i=1;i<=heroes.size();i++){
            System.out.println(i+". "+heroes.get(i-1).getName());
        }
    }

    public boolean isBagEmpty(){
        return bag.content.isEmpty();
    }

    public void displayHeroInformation(){
        for(Hero hero : heroes){
            System.out.println(hero.getName()+"     Armor: "+hero.getArmor().getName()+"     Weapon: "+hero.getWeapon().getName());
            System.out.println("HP: "+hero.getHP_current()+"/"+hero.getHP_capacity()+"       AD:"+hero.getAttack_damage()+"    AP:"+hero.getAbility_power());
            System.out.println("MP: "+hero.getMP_current()+"/"+hero.getMP_capacity()+"       AR:"+hero.getAttack_resist()+"    MR:"+hero.getMagic_resist());
            System.out.println("Exp: "+hero.getExp_current()+"/"+hero.getExp_expectation());
            System.out.println();
        }
    }

    public int getBagSize(){
        return bag.size();
    }

    public Item getItemFromBag(int index){
        return bag.get(index);
    }

    public void EnterBag(){
        while (true){
            if(isBagEmpty()){
                System.out.println("Your bag is Empty!");
                break;
            }
            System.out.println("Items in Your Bag:");
            printBag();
            int things= Utils.safeIntInput("Select one Item to know more details. Input -1 to get back.",-1,getBagSize());
            if(things==-1){
                break;
            }
            Item item = getItemFromBag(things-1);
            System.out.println(item.getName()+"'s information:");
            item.printDetail();
            int subthings = Utils.safeIntInput("1. Use  2. Back", 1,2);
            if(subthings==1){
                printHeroList();
                int index=Utils.safeIntInput("Select one Hero as a target. Input -1 to cancel.",-1,heroes.size());
                if(index==-1){
                    continue;
                }
                if(item.getLevel_require()>heroes.get(index-1).getLevel()){
                    System.out.println(heroes.get(index-1).getName()+" doesn't meet the Level requirement!");
                    continue;
                }
                item.UseFromBag(getBag(),heroes.get(index-1));
                System.out.println("Use Successfully!");
            }
        }
    }
}
