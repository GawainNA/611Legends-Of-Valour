
import java.util.ArrayList;
import java.util.Scanner;

public class Market {
    ArrayList<Item> market = new ArrayList<Item>();


    public Market(){
        String[] tmp;
        String[] armor=data.getArmor();
        String[] weapon=data.getWeapon();
        String[] IceSpells=data.getIceSpell();
        String[] FireSpells=data.getFireSpell();
        String[] LightingSpells=data.getLightingSpell();
        String[] potion = data.getPotion();

        for(String i: armor){
            tmp=i.split(" ");
            Armor newthings=Armor.createArmor(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(newthings);
        }
        for(String i: weapon){
            tmp=i.split(" ");
            Weapon newthings=Weapon.createWeapon(tmp[0],Integer.parseInt(tmp[1]),Integer.parseInt(tmp[2]),Integer.parseInt(tmp[3]),Integer.parseInt(tmp[4]));
            market.add(newthings);
        }

        for(String i: IceSpells){
            Spell spell=SpellFactory.createIceSpell(i);
            market.add(spell);
        }
        for(String i: FireSpells){
            Spell spell=SpellFactory.createFireSpell(i);
            market.add(spell);
        }
        for(String i: LightingSpells){
            Spell spell=SpellFactory.createLightingSpell(i);
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

    public void buyItem(Player player,Item item){
        if(player.getMoney()>=item.getPrice()){
            System.out.println("Please Make sure you want to buy "+item.getName()+" (y/n)");
            Scanner scan = new Scanner(System.in);
            if(scan.next().equals("y")){
                player.addItem(item);
                player.loseMoney(item.getPrice());
                remove(item);
                System.out.println("Succeed!");
            }
            else return;
        }else {
            System.out.println("Your money is not enough!");
            return;
        }
    }

    public void EnterMarket(Player player){
        while (true){
            System.out.println("You are in the Market now! What do you want to do?");
            int choice= Utils.safeIntInput("1. Buy    2. Sell    3. Exit",1,3);
            switch (choice){
                case 1: EnterBuy(player);break;
                case 2: EnterSell(player);break;
                case 3: return;
            }
        }
    }

    public void EnterBuy(Player player){
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
                buyItem(player,item);
            }
        }
    }

    public void EnterSell(Player player){
        while (true){
            if(player.isBagEmpty()){
                System.out.println("Your bag is Empty!");
                return;
            }
            System.out.println("Which one do you want to sell?");
            player.printBag();
            int choice= Utils.safeIntInput("Select one Item to know more details. Input -1 to get back.",-1,player.getBagSize());
            if(choice==-1){
                break;
            }
            Item item = player.getItemFromBag(choice-1);
            System.out.println(item.getName()+"'s information:");
            item.printDetail();
            int subchoice = Utils.safeIntInput("1. Sell  2. Back", 1,2);
            if(subchoice==1){
                player.removeItem(item);
                player.addMoney(item.getSelling_price());
                market.add(item);
                System.out.println("Succeed!");
            }
        }
    }


}
