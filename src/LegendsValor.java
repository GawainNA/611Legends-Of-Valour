import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class LegendsValor implements Playable {
    class Location{
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

        }
        for (Monster monster : monsters.getMonsters()) {

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
                        Hero tank=HeroFactory.createTank(data.getTank());
                        heroes.addHero(tank);
                    }
                    break;
                }

                case 2:{
                    System.out.println("Warrior has high attack damage.");
                    System.out.println("Do you want to add Warrior to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        Hero warrior=HeroFactory.createWarrior(data.getWarrior());
                        heroes.addHero(warrior);
                    }
                    break;
                }
                case 3:{
                    System.out.println("Caster has high Magic damage, but low HP.");
                    System.out.println("Do you want to add Caster to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        Hero Caster=HeroFactory.createCaster(data.getCaster());
                        heroes.addHero(Caster);
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

    public void heroAction (Hero h) {
        ArrayList<Monster> targets = detectMonster(h);

    }
    public void monsterAction (Monster m) {
        ArrayList<Hero> targets = detectHero(m);
        if (targets.size() == 0) {
            Location currentLocation = monsterLocation.get(m);
            boolean canGoForward = true;
            boolean canGoAside = true;
            for ()
        }
        else {

        }
    }

    public boolean move (Character c, Location goal) {
        if (goal.x < 0 || goal.y < 0 || goal.x >= map.column || goal.y >= map.row) {
            return false;
        }
        if (map.cells[goal.x][goal.y] instanceof InaccessibleCell) {
            return false;
        }
        if (c instanceof Hero) {
            heroLocation.put((Hero)c, goal);
        }
        else if (c instanceof Monster) {
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
}
