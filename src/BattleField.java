
import java.util.ArrayList;
import java.util.Random;

public class BattleField {
    Player player;
    ArrayList<Monster>monsters=new ArrayList<>();
    int ExpReward=0;
    int MoneyReward=0;
    Random random=new Random();

    BattleField(Player player){
        this.player=player;
    }

    public static BattleField createABattleField(Player player){
        return new BattleField(player);
    }

    public void BossCome(){
        monsters.add(MonsterFactory.createDragon(data.getDragon()));
        monsters.add(MonsterFactory.createDragon(data.getDarkDragon()));
        monsters.add(MonsterFactory.createDragon(data.getDragon()));
        BattleBegin();
    }

    boolean isAllDied(){
        boolean result=true;
        for(Hero hero: player.heroes){
            if(hero.getHP_current()>0){
                result=false;
            }
        }
        return result;
    }

    public void BattleBegin(){
        CreateMonsters();
        while (true){
            for(Hero hero: player.heroes){
                printBattleBoard();
                if(hero.getHP_current()==0) {
                    continue;
                }
                OneHeroRound(hero);
                if(monsters.isEmpty()){
                    System.out.println("You Win this Battle!");
                    AfterBattle(true);
                    return;
                }
            }
            MonsterAutoRound();
            if(isAllDied()){
                System.out.println("All Heroes died! You Lose this Battle.");
                AfterBattle(false);
                return;
            }
        }
    }

    void AfterBattle(boolean isWin){
        if(isWin){
            player.addMoney(MoneyReward);
            System.out.println("You gain "+ MoneyReward+" money to your wallet!");
            for(Hero hero: player.heroes){
                if(hero.getHP_current()>0){
                    System.out.println(hero.getName()+" gain "+ExpReward +" Exp!");
                    if(hero.addExp(ExpReward)){
                        System.out.println(hero.getName()+" Level up! Current Level is "+hero.getLevel());
                    }
                    hero.recover();
                }else {
                    hero.setHP_current(hero.getHP_capacity()/2);
                }
            }
        }
        else {
            player.loseMoney(player.getMoney()/2);
            System.out.println("Your Heroes are recovered. But you lose half of your money.");
            for(Hero hero:player.heroes){
                hero.setHP_current(hero.getHP_capacity()/2);
            }
        }
    }

    boolean isDodged(Character NPC){
        if(random.nextInt(100)<NPC.getDodge_chance()*100){
            return true;
        }
        return false;
    }

    void MonsterAutoRound(){
        Random random=new Random();
        ArrayList<Hero> tmp=new ArrayList<>();
        for(Hero hero:player.heroes){
            if(hero.getHP_current()!=0){
                tmp.add(hero);
            }
        }

        for (Monster monster : monsters) {
            Hero target = tmp.get(random.nextInt(tmp.size()));
            if(isDodged(target)){
                System.out.println(target.getName()+" dodged "+ monster.getName()+"'s Attack!");
                continue;
            }
            int damage = monster.inflict(target);
            target.reduceHP(damage);
            System.out.println(monster.getName() + " caused " + damage + " damage to " + target.getName()+"!");
            if(target.getHP_current()==0){
                System.out.println(target.getName()+" died!");
            }
        }


    }

    void OneHeroRound(Hero hero){
        out:while (true){
            int choice=Utils.safeIntInput(hero.getName()+" please select your action: 1.attack  2.spell  3.bag  -1. do nothing",-1,3);
            switch (choice){
                case -1:return;
                case 1:{
                    printMonsters();
                    int subchoice=Utils.safeIntInput("Select your target",1,monsters.size());
                    if(isDodged(monsters.get(subchoice-1))){
                        System.out.println(monsters.get(subchoice-1).getName()+" dodged "+hero.getName()+"'s attack!");
                        break;
                    }
                    int damage= Math.max(hero.getAttack_damage()-monsters.get(subchoice-1).getAttack_resist(),0);
                    monsters.get(subchoice-1).reduceHP(damage);
                    System.out.println(hero.getName() +" Caused "+damage+" attack damage to "+monsters.get(subchoice-1).getName());
                    if(monsters.get(subchoice-1).getHP_current()==0){
                        System.out.println(monsters.get(subchoice-1).getName()+" died!");
                        monsters.remove(subchoice-1);
                    }
                    break out;
                }
                case 2:{
                    if(hero.getSpells().isEmpty()){
                        System.out.println(hero.getName()+" doesn't have any spells now!");
                        break;
                    }
                    hero.printSpell();
                    int subChoice=Utils.safeIntInput("Select one spell. input -1 to cancel",-1,hero.getSpells().size());
                    if(subChoice==-1){
                        break;
                    }
                    if(hero.getSpell(subChoice-1).getMana_consume()>hero.getMP_current()){
                        System.out.println("mana is not enough!");
                        break;
                    }
                    printMonsters();
                    int thirdChoice=Utils.safeIntInput("Select one Monster as a target, input -1 to cancel",-1,monsters.size());
                    if(thirdChoice==-1){
                        break;
                    }
                    if(isDodged(monsters.get(thirdChoice-1))){
                        System.out.println(monsters.get(thirdChoice-1).getName()+" dodged "+hero.getName()+"'s Magic Attack!");
                    }
                    hero.cast(hero.getSpell(subChoice-1),monsters.get(thirdChoice-1));
                    if(monsters.get(thirdChoice-1).getHP_current()==0){
                        System.out.println(monsters.get(thirdChoice-1).getName()+" died!");
                        monsters.remove(thirdChoice-1);
                    }
                    break out;
                }
                case 3:{
                    if(player.isBagEmpty()){
                        System.out.println("Your bag is Empty!");
                        break;
                    }
                    player.EnterBag();
                }
            }
        }
    }

    public void printBattleBoard(){
        System.out.println("------------------------------------------------");
        System.out.println("                  BATTLE BOARD      ");
        int n= player.heroes.size();
        int m= monsters.size();
        String NameList="    ";
        String HPList="HP: ";
        String MPList="MP: ";
        for(int i=0;i<n;i++){
            NameList=NameList.concat(String.format("%-20s", player.heroes.get(i).getName()));
            HPList=HPList.concat(String.format("%-5d /%-5d        ",player.heroes.get(i).getHP_current(),player.heroes.get(i).getHP_capacity()));
            MPList=MPList.concat(String.format("%-5d /%-5d        ",player.heroes.get(i).getMP_current(),player.heroes.get(i).getMP_capacity()));
        }
        String MNamList="    ";
        String MHPList="HP: ";
        for(int i=0;i<m;i++){
            MNamList=MNamList.concat(String.format("%-20s", monsters.get(i).getName()));
            MHPList=MHPList.concat(String.format("%-5d /%-5d        ",monsters.get(i).getHP_current(),monsters.get(i).getHP_capacity()));
        }
        System.out.println(MNamList);
        System.out.println(MHPList);
        System.out.println();
        System.out.println(NameList);
        System.out.println(HPList);
        System.out.println(MPList);
        System.out.println("------------------------------------------------");
    }

    void CreateMonsters(){
        int n =player.heroes.size();
        for(int i=0;i<n;i++){
            int a= random.nextInt(10);
            int b= random.nextInt(100);
            int c= random.nextInt(70);
            if(a>b&&a>c){
                monsters.add(MonsterFactory.createDragon(data.getDragon()));
                ExpReward+=500;
                MoneyReward+=1000;
            }else if(b>c){
                monsters.add(MonsterFactory.createMonsterFighter(data.getMonsterFighter()));
                ExpReward+=20;
                MoneyReward+=50;
            }else {
                monsters.add(MonsterFactory.createMonsterCaster(data.getMonsterCaster()));
                ExpReward+=20;
                MoneyReward+=50;
            }
        }
    }

    void printMonsters(){
        String result="";
        for(int j=1;j<= monsters.size();j++){
            result=result.concat(j+". "+monsters.get(j-1).getName()+"   ");
        }
        System.out.println(result);
    }
}
