import java.util.*;
import java.util.Map;

public class LegendsValor {
    class Location{
        int x;
        int y;
        public Location (int x, int y) {
            this.x = x;
            this.y = y;
        }
        public Location (int lane, int x, int y) {
            this.x = lane * 3 + x;
            this.y = y;
        }
        public int getLane() {
            return (x / 3);
        }
    }
    TeamHero heroes;
    TeamMonster monsters;
    HashMap<Hero, Location> heroLocation;
    HashMap<Monster, Location> monsterLocation;
    Scanner scan =new Scanner(System.in);

    LegendsValor(){
        heroes=new TeamHero();
        monsters=new TeamMonster();
    }

    void Create_A_Monster(){
        Random random=new Random();
        int a= random.nextInt(10);
        int b= random.nextInt(100);
        int c= random.nextInt(70);
        if(a>b&&a>c){
            List<String> wholeData=data.getDragonData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
            monsters.add(MonsterFactory.createDragon(selected));
        }else if(b>c){
            List<String> wholeData=data.getMonsterCasterData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
            monsters.add(MonsterFactory.createDragon(selected));
            monsters.add(MonsterFactory.createMonsterFighter(selected));
        }else {
            List<String> wholeData=data.getMonsterFighterData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
            monsters.add(MonsterFactory.createDragon(selected));
            monsters.add(MonsterFactory.createMonsterFighter(selected));
        }
    }


    

    public void displayHeroInformation(){
        for(Hero hero : heroes.getHeroes()){
            System.out.println(hero.getName()+"     Armor: "+hero.getArmor().getName()+"     Weapon: "+hero.getWeapon().getName());
            System.out.println("HP: "+hero.getHP_current()+"/"+hero.getHP_capacity()+"       AD:"+hero.getAttack_damage()+"    AP:"+hero.getAbility_power());
            System.out.println("MP: "+hero.getMP_current()+"/"+hero.getMP_capacity()+"       AR:"+hero.getAttack_resist()+"    MR:"+hero.getMagic_resist());
            System.out.println("Exp: "+hero.getExp_current()+"/"+hero.getExp_expectation());
            System.out.println();
        }
    }
    void pickHero(){
        Random random =new Random();
        while (true){
            System.out.println("Select your Heroes:");
            System.out.println("1.Tank   2.Warrior   3.Caster");
            System.out.println();
            int choice=Utils.safeIntInput("Select one to know more details",-1,4);
            switch (choice){
                case -1:System.out.println("Exit!");return;
                case 1:{
                    System.out.println("Tank has high HP and Defense, is a good shield.");
                    System.out.println("Do you want to add Tank to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        List<String> wholeData=data.getTankData();
                        String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero tank=HeroFactory.createTank(selected);
                        heroes.addHero(tank);
                    }
                    break;
                }

                case 2:{
                    System.out.println("Warrior has high attack damage.");
                    System.out.println("Do you want to add Warrior to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        List<String> wholeData=data.getWarriorData();
                        String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero warrior=HeroFactory.createTank(selected);
                        heroes.addHero(warrior);
                    }
                    break;
                }
                case 3:{
                    System.out.println("Caster has high Magic damage, but low HP.");
                    System.out.println("Do you want to add Caster to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        List<String> wholeData=data.getCasterData();
                        String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero caster=HeroFactory.createTank(selected);
                        heroes.addHero(caster);
                    }
                }
            }
            if(heroes.size()<3){
                System.out.println("Do you want to select more heroes?(y/n)");
                if(scan.nextLine().equals("n")){break;}
            }else {
                System.out.println("You have chosen 3 heroes! Let's begin!");
                break;
            }
        }
    }

    public void constructMap() {
        ArrayList<Hero> heroes = this.heroes.getHeroes();
        ArrayList<Monster> monsters = this.monsters.getMonsters();
        this.heroLocation = new HashMap<Hero, Location>();
        this.monsterLocation = new HashMap<Monster, Location>();
        for (int i = 0; i < 3; i++) {
            Hero h = heroes.get(i);
            Monster m = monsters.get(i);
            heroLocation.put(h, new Location(i, 1, 0));
            monsterLocation.put(m, new Location(i, 1, 7));
        }
    }
}
