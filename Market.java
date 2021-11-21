
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Market {
    ArrayList<Item> market = new ArrayList<>();


    public Market(){
        String[] tmp;
        List<String> armor = data.getArmorData();
        List<String> weapon = data.getWeaponData();
        List<String> IceSpells=data.getIceSpellData();
        List<String> FireSpells=data.getFireSpellData();
        List<String> LightSpells=data.getLightSpellData();
        String[] potion = data.getPotion();

        for(String i: armor){
            tmp=i.split("\\s+");
            Armor newthings=ArmorFactory.createArmor(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(newthings);
        }
        for(String i: weapon){
            tmp=i.split("\\s+");
            Weapon newthings=WeaponFactory.createWeapon(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(newthings);
        }

        for(String i: IceSpells){
            tmp=i.split("\\s+");
            Spell spell=SpellFactory.createIceSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(spell);
        }
        for(String i: FireSpells){
            tmp=i.split("\\s+");
            Spell spell=SpellFactory.createFireSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(spell);
        }
        for(String i: LightSpells){
            tmp=i.split("\\s+");
            Spell spell=SpellFactory.createLightSpell(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(spell);
        }

        for(String i: potion){
            potion p=PotionFactory.CreatePotion(i);
            market.add(p);
        }

    }


    public void remove(Item item){
        market.remove(item);
    }

    public void add(Item item){
        market.add(item);
    }

    public int size(){
        return market.size();
    }

    public Item get(int index){
        return market.get(index);
    }

    public void printMarket(){
        String result="";
        for(int i = 1; i<=market.size(); i++){
            result=result.concat(i+". "+market.get(i-1).getName()+"\n");
        }
        System.out.println(result);
    }

    public void buyItem(Hero hero,Item item){
        if(hero.getMoney()>=item.getPrice()){
            System.out.println("Please Make sure you want to buy "+item.getName()+" (y/n)");
            Scanner scan = new Scanner(System.in);
            if(scan.next().equals("y")){
                hero.addItem(item);
                hero.loseMoney(item.getPrice());
                remove(item);
                System.out.println("Succeed!");
            }
            else System.out.println("Canceled!");
        }else {
            System.out.println("Your money is not enough!");
        }
    }

    public void EnterMarket(Hero hero){
        while (true){
            System.out.println("You are in the Market now! What do you want to do?");
            int choice;
            choice = Utils.safeIntInput("1. Buy    2. Sell    3. Exit",1,3);
            switch (choice){
                case 1: EnterBuy(hero);break;
                case 2: EnterSell(hero);break;
                case 3: return;
            }
        }
    }

    public void EnterBuy(Hero hero){
        while (true){
            System.out.println("Which one do you want to buy? ");
            printMarket();
            int choice= Utils.safeIntInput("Select one Item to know more details. Input -1 to get back.",-1,market.size());
            if(choice==-1){
                break;
            }
            Item item = market.get(choice-1);
            System.out.println(item.getName()+"'s information:");
            item.printDetail();
            int subchoice = Utils.safeIntInput("1. Buy  2. Back", 1,2);
            if(subchoice==1){
                buyItem(hero,item);
            }
        }
    }

    public void EnterSell(Hero hero){
        while (true){
            if(hero.isBagEmpty()){
                System.out.println("Your bag is Empty!");
                return;
            }
            System.out.println("Which one do you want to sell?");
            hero.printBag();
            int choice= Utils.safeIntInput("Select one Item to know more details. Input -1 to get back.",-1,hero.getBagSize());
            if(choice==-1){
                break;
            }
            Item item = hero.getItemFromBag(choice-1);
            System.out.println(item.getName()+"'s information:");
            item.printDetail();
            int subchoice = Utils.safeIntInput("1. Sell  2. Back", 1,2);
            if(subchoice==1){
                hero.removeItem(item);
                hero.addMoney(item.getSelling_price());
                market.add(item);
                System.out.println("Succeed!");
            }
        }
    }


}
