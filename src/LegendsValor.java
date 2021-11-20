
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.*;



public class LegendsValor implements Playable {
    public class Location{
        public int x;
        public int y;
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

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Location location = (Location) o;
            return x == location.x &&
                    y == location.y;
        }
    }

    Map map;
    TeamHero heroes;
    TeamMonster monsters;
    HashMap<Hero, Location> heroLocation;
    HashMap<Monster, Location> monsterLocation;
    Scanner scan;
    boolean heroWin;
    boolean monsterWin;

    public LegendsValor () {
        scan = new Scanner(System.in);
        heroWin = false;
        monsterWin = false;
        heroes = new TeamHero();
        monsters = new TeamMonster();
        heroLocation = new HashMap<>();
        monsterLocation = new HashMap<>();
    }

    public void gameStart() {
        map = MapCreator.ValorMap();
        displayHeroInformation();
        pickHero();
        Create_A_Monster();
        Create_A_Monster();
        Create_A_Monster();
        constructLocationMapping();
    }
    public void gameEnd() {
        if (heroWin && monsterWin) {
            System.out.println("Draw!");
        }
        else if (heroWin) {
            System.out.println("You win this game!");
        }
        else if (monsterWin) {
            System.out.println("You lose this game!");
        }
    }
    public void roundStart() {
        for (Hero hero : heroes.getHeroes()) {
            boolean moved = false;
            while (!moved) {
                //TODO: display map
                PrintableValorMap.printMap(heroLocation,monsterLocation,heroes,monsters);
                moved = heroMove(heroAction(hero), hero);
            }
        }
        for (Monster monster : monsters.getMonsters()) {
            monsterAction(monster);
        }
    }
    public void roundEnd() {
        //TODO: Check if heroes or monsters win and regain health & mana.
    }
    public void run() {
        gameStart();
        while (!heroWin && !monsterWin) {
            roundStart();
            roundEnd();
        }
        gameEnd();
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
            monsters.add(MonsterFactory.createMonsterFighter(selected));
        }else {
            List<String> wholeData=data.getMonsterFighterData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
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
            switch (choice) {
                case -1 -> {
                	
                    System.out.println("Exit!");
                    return;
                }
                case 1 -> {
                	List<String> wholeData=data.getTankData();
                	int k=1;
                	System.out.println("ID\tName\t\t    Mana    Stren    Agil   Dex    Start$  Start.XP");
                	for (String element : wholeData) {
                	    System.out.println(k+"\t"+element);
                	    k++;
                	}
                    System.out.println("Tank has high HP and Defense, is a good shield.");
                    System.out.println("Do you want to add Tank to your team?(y/n)");

                    if(scan.nextLine().equals("y")){
                        //List<String> wholeData=data.getTankData();
                    	int choice1=Utils.safeIntInput("Pick you Tank (1-6)",1,6);
                    	String[] selected=wholeData.get(choice1-1).split("\\s+");
                        //String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero tank=HeroFactory.createTank(selected);
                        System.out.println("you have picked "+tank.getName());
                        heroes.addHero(tank);
                        //System.out.println(heroes.());
                    }
                }
                case 2 -> {
                	data.getWarriorData();
                	List<String> wholeData=data.getWarriorData();
                	int k1=1;
                	System.out.println("ID\tName\t\t    Mana    Stren    Agil   Dex    Start$  Start.XP");
                	for (String element : wholeData) {
                	    System.out.println(k1+"\t"+element);
                	    k1++;
                	}
                    System.out.println("Warrior has high attack damage.");
                    System.out.println("Do you want to add Warrior to your team?(y/n)");
                    

                    if(scan.nextLine().equals("y")){
                    	int choice1=Utils.safeIntInput("Pick you Warrior (1-6)",1,6);
                    	String[] selected=wholeData.get(choice1-1).split("\\s+");
                        //String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero warrior=HeroFactory.createWarrior(selected);
                        System.out.println("you have picked "+warrior.getName());
                        heroes.addHero(warrior);
                    }
                }
                case 3 -> {
                	int k2=1;
                	data.getCasterData();
                	List<String> wholeData=data.getCasterData();
                	System.out.println("ID\tName\t\t        Mana    Stren   Agil    Dex    Start$  Start.XP");
                	for (String element : wholeData) {
                	    System.out.println(k2+"\t"+element);
                	    k2++;
                	}
                    System.out.println("Caster has high Magic damage, but low HP.");
                    System.out.println("Do you want to add Caster to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        //List<String> wholeData=data.getCasterData();
                    	int choice1=Utils.safeIntInput("Pick you Caster (1-6)",1,6);
                    	String[] selected=wholeData.get(choice1-1).split("\\s+");
                        //String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero caster=HeroFactory.createCaster(selected);
                        heroes.addHero(caster);
                        System.out.println("you have picked "+caster.getName());
                    }
                }
            }
            if(heroes.size()<3){
                System.out.println("You have "+ heroes.size()+" heroes now, please continue choosing.");

            }else {
                System.out.println("You have chosen 3 heroes! Let's begin!");
                break;
            }
        }
    }

    public void constructLocationMapping() {
        ArrayList<Hero> heroes = this.heroes.getHeroes();
        ArrayList<Monster> monsters = this.monsters.getMonsters();
        for (int i = 0; i < 3; i++) {
            Hero h = heroes.get(i);
            Monster m = monsters.get(i);
            heroLocation.put(h, new Location(i, 1, 7));
            monsterLocation.put(m, new Location(i, 1, 0));
        }
    }

    public String heroAction (Hero h) {
        //TODO: hero action.
        System.out.println("Select your action:");
        System.out.println("W: Up  A: Left  S: Down  D: Right  T: Teleport B: Back");
        System.out.println("1: Attack  2: Cast Spell  3: Use Potion  4: Change Equipment");
        return scan.next().toLowerCase();
    }
    public void monsterAction (Monster m) {
        ArrayList<Hero> targets = detectHero(m);
        if (targets.size() == 0) {
            Location currentLocation = monsterLocation.get(m);
            boolean canGoForward = true;
            boolean canGoAside = true;
            for (Monster otherMonster : monsters.getMonsters()) {
                Location otherMonsterLocation = monsterLocation.get(otherMonster);
                if (otherMonsterLocation.x == currentLocation.x
                        && otherMonsterLocation.y == currentLocation.y + 1) {
                    canGoForward = false;
                }
                else if (Math.abs(otherMonsterLocation.x - currentLocation.x) == 1
                        && otherMonsterLocation.y == currentLocation.y) {
                    canGoAside = false;
                }
            }
            if (!canGoForward && canGoAside) {
                if (currentLocation.x % 3 == 0) {
                    move(m, new Location(currentLocation.x + 1, currentLocation.y));
                }
                else if (currentLocation.x % 3 == 1) {
                    move(m, new Location(currentLocation.x - 1, currentLocation.y));
                }
            }
            else if (canGoForward) {
                move(m, new Location(currentLocation.x, currentLocation.y + 1));
            }
        }
        else {
            Hero target = targets.get(0);
            target.reduceHP(m.inflict(target));
            if (target.getHP_current() <= 0) {
                respawn(target);
            }
        }
    }

    public boolean heroMove (String action, Hero h) {
        ArrayList<Monster> targets = detectMonster(h);
        Location currentLocation = heroLocation.get(h);
        switch (action) {
            case "w" -> {
                Location goal = new Location(currentLocation.x, currentLocation.y - 1);
                if (move(h, goal))
                    return true;
            }
            case "a" -> {
                Location goal = new Location(currentLocation.x - 1, currentLocation.y);
                if (move(h, goal))
                    return true;
            }
            case "s" -> {
                Location goal = new Location(currentLocation.x, currentLocation.y + 1);
                if (move(h, goal))
                    return true;
            }
            case "d" -> {
                Location goal = new Location(currentLocation.x + 1, currentLocation.y);
                if (move(h, goal))
                    return true;
            }
            //TODO: actions.
            default -> {
                System.out.println("Illegal input.");
                return false;
            }
        }
        return false;
    }

    public boolean move (Character c, Location goal) {
        if (goal.x < 0 || goal.y < 0 || goal.x >= map.column || goal.y >= map.row) {
            return false;
        }
        if (map.cells[goal.x][goal.y] instanceof InaccessibleCell) {
            return false;
        }
        if (c instanceof Hero) {
            for (Hero h : heroes.getHeroes()) {
                if (heroLocation.get(h).equals(goal))
                    return false;
            }
            heroLocation.put((Hero)c, goal);
            map.cells[goal.x][goal.y].inCellFunction(c);
        }
        else if (c instanceof Monster) {
            for (Monster m : monsters.getMonsters()) {
                if (monsterLocation.get(m).equals(goal))
                    return false;
            }
            monsterLocation.put((Monster)c, goal);
        }
        else {
            return false;
        }
        return true;
    }

    public ArrayList<Hero> detectHero (Monster m) {
        ArrayList<Hero> targets = new ArrayList<>();
        Location mLocation = monsterLocation.get(m);
        for (Hero h : heroes.getHeroes()) {
            Location hLocation = heroLocation.get(h);
            if (Math.abs(hLocation.x - mLocation.x) <= 1 &&
            Math.abs(hLocation.y - mLocation.y) <= 1) {
                targets.add(h);
            }
        }
        return targets;
    }
    public ArrayList<Monster> detectMonster (Hero h) {
        ArrayList<Monster> targets = new ArrayList<>();
        Location hLocation = heroLocation.get(h);
        for (Monster m : monsters.getMonsters()) {
            Location mLocation = monsterLocation.get(m);
            if (Math.abs(hLocation.x - mLocation.x) <= 1 &&
                    Math.abs(hLocation.y - mLocation.y) <= 1) {
                targets.add(m);
            }
        }
        return targets;
    }
    public void respawn (Hero h) {
        int lane = heroLocation.get(h).getLane();
        h.recover();
        h.loseMoney(h.getMoney() / 2);
        if (!move(h, new Location(lane, 0, 7)))
            if (!move(h, new Location(lane, 1, 7)))
                move(h, new Location(lane, 0, 6));

    }
}
