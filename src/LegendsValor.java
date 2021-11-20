
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

    int round;
    int[] discovered;
    Map map;
    TeamHero heroes;
    TeamMonster monsters;
    HashMap<Hero, Location> heroLocation;
    HashMap<Monster, Location> monsterLocation;
    Scanner scan;
    boolean heroWin;
    boolean monsterWin;
    Random random;

    public LegendsValor () {
        scan = new Scanner(System.in);
        heroWin = false;
        monsterWin = false;
        heroes = new TeamHero();
        monsters = new TeamMonster();
        heroLocation = new HashMap<>();
        monsterLocation = new HashMap<>();
        random = new Random();
    }

    public void gameStart() {
        round = 0;
        discovered = new int[] {7, 7, 7};
        map = MapCreator.RandomValorMap();
        pickHero();
        for (int i = 0; i < 3; i++) {
            monsters.add(createMonster());
        }
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
                PrintableValorMap.printMap(map,heroLocation, monsterLocation, heroes, monsters);
                printIconMatching();
                System.out.println();
                printMonsterInfo();
                System.out.println();
                moved = heroMove(heroAction(hero), hero);
            }
        }
        for (Monster monster : monsters.getMonsters()) {
            monsterAction(monster);
        }
        if (round % 8 == 0 && round != 0) {
            System.out.print("New monsters spawned!!!");
            spawnMonster();
        }
    }
    public void roundEnd() {
        round++;
        for (Hero h : heroes.getHeroes()) {
            if (heroLocation.get(h).y == 0)
                heroWin = true;
            h.recover();
        }
        for (Monster m : monsters.getMonsters()) {
            if (monsterLocation.get(m).y == 7)
                monsterWin = true;
        }
    }
    public void run() {
        gameStart();
        while (!heroWin && !monsterWin) {
            roundStart();
            roundEnd();
        }
        gameEnd();
    }

    // Generate a monster.
    public Monster createMonster(){

        int a = random.nextInt(10);
        int b = random.nextInt(100);
        int c = random.nextInt(70);
        if (a > b && a > c) {
            List<String> wholeData=data.getDragonData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
            return MonsterFactory.createDragon(selected);
        } else if (b > c) {
            List<String> wholeData=data.getMonsterCasterData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
            return MonsterFactory.createMonsterFighter(selected);
        } else {
            List<String> wholeData=data.getMonsterFighterData();
            String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
            return MonsterFactory.createMonsterFighter(selected);
        }
    }

    // Generate 3 monsters and place them in the game.
    public void spawnMonster () {
        for (int i = 0; i < 3; i++) {
            Monster newMonster = createMonster();
            int x = i * 3;
            int y = 0;
            boolean placed = false;
            while (!placed) {
                boolean canPlace = true;
                for (Monster m : monsters.getMonsters()) {
                    Location l = monsterLocation.get(m);
                    if (l.x == x && l.y == y)
                        canPlace = false;
                }
                if (canPlace) {
                    monsterLocation.put(newMonster, new Location(x, y));
                }
                else {
                    if (x % 3 == 0)
                        x++;
                    else if (x % 3 == 1) {
                        x--;
                        y++;
                    }
                }
                placed = canPlace;
            }
            monsters.add(newMonster);
        }
    }

    private void printIconMatching(){
        String match = "";
        for(int i =1; i<=heroes.size();i++){
            match=match.concat("H"+i+" : "+heroes.getHeroes().get(i-1).getName()+"   ");
        }
        System.out.println(match);
    }

    private void printMonsterInfo(){
        String MNamList="";
        String MHPList="HP: ";
        for(int i=0;i<monsters.size();i++){
            MNamList=MNamList.concat(String.format("M"+(i+1)+": %-20s", monsters.get(i).getName()));
            MHPList=MHPList.concat(String.format("%-5d /%-5d            ",monsters.get(i).getHP_current(),monsters.get(i).getHP_capacity()));
        }
        System.out.println(MNamList);
        System.out.println(MHPList);
    }

    private void displayHeroInformation(Hero hero){
        System.out.println(hero.getName()+"     Armor: "+hero.getArmor().getName()+"     Weapon: "+hero.getWeapon().getName());
        System.out.println("HP: "+hero.getHP_current()+"/"+hero.getHP_capacity()+"       AD:"+hero.getAttack_damage()+"    AP:"+hero.getAbility_power());
        System.out.println("MP: "+hero.getMP_current()+"/"+hero.getMP_capacity()+"       AR:"+hero.getAttack_resist()+"    MR:"+hero.getMagic_resist());
        System.out.println("Exp: "+hero.getExp_current()+"/"+hero.getExp_expectation());
        System.out.println();
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
                    System.out.println("Tank has high HP and Defense, is a good shield.");
                    System.out.println("Do you want to add Tank to your team?(y/n)");

                    if(scan.nextLine().equals("y")){
                        List<String> wholeData=data.getTankData();
                        String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero tank=HeroFactory.createTank(selected);
                        heroes.addHero(tank);
                    }
                }
                case 2 -> {
                    System.out.println("Warrior has high attack damage.");
                    System.out.println("Do you want to add Warrior to your team?(y/n)");

                    if(scan.nextLine().equals("y")){
                        List<String> wholeData=data.getWarriorData();
                        String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero warrior=HeroFactory.createWarrior(selected);
                        heroes.addHero(warrior);
                    }
                }
                case 3 -> {
                    System.out.println("Caster has high Magic damage, but low HP.");
                    System.out.println("Do you want to add Caster to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        List<String> wholeData=data.getCasterData();
                        String[] selected=wholeData.get(random.nextInt(wholeData.size())).split("\\s+");
                        Hero caster=HeroFactory.createCaster(selected);
                        heroes.addHero(caster);
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

    // Place heroes and monsters in the map.
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

    // Play select hero action.
    public String heroAction (Hero h) {
        System.out.println("You are controlling H" + (heroes.getHeroes().indexOf(h) + 1));
        System.out.println("Select your action:");
        System.out.println("W: Up  A: Left  S: Down  D: Right  T: Teleport  B: Back");
        System.out.println("1: Attack  2: Cast Spell  3: View Info and Enter Bag");
        return scan.next().toLowerCase();
    }

    // Monsters move automatically.
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
                    move(m, new Location(currentLocation.x + 1, currentLocation.y), false);
                }
                else if (currentLocation.x % 3 == 1) {
                    move(m, new Location(currentLocation.x - 1, currentLocation.y), false);
                }
            }
            else if (canGoForward) {
                move(m, new Location(currentLocation.x, currentLocation.y + 1), false);
            }
        }
        else {
            Hero target = targets.get(0);
            int damage = m.inflict(target);
            target.reduceHP(damage);
            System.out.println("Monster " + m.getName() + " dealt " + damage + " damage to Hero " + target.getName());
            if (target.getHP_current() <= 0) {
                System.out.println("Hero " + target.getName() + " is dead!");
                respawn(target);
            }
        }
    }

    // Deal with selected hero action.
    public boolean heroMove (String action, Hero h) {
        ArrayList<Monster> targets = detectMonster(h);
        Location currentLocation = heroLocation.get(h);
        switch (action) {
            case "w" -> {
                Location goal = new Location(currentLocation.x, currentLocation.y - 1);
                if (move(h, goal, false)) {
                    if (goal.x < discovered[goal.getLane()]) {
                        discovered[goal.getLane()] = goal.y;
                    }
                    return true;
                }
                else {
                    System.out.println("You can't move to this cell!");
                    return false;
                }
            }
            case "a" -> {
                Location goal = new Location(currentLocation.x - 1, currentLocation.y);
                if (move(h, goal, false))
                    return true;
                else {
                    System.out.println("You can't move to this cell!");
                    return false;
                }
            }
            case "s" -> {
                Location goal = new Location(currentLocation.x, currentLocation.y + 1);
                if (move(h, goal, false))
                    return true;
                else {
                    System.out.println("You can't move to this cell!");
                    return false;
                }
            }
            case "d" -> {
                Location goal = new Location(currentLocation.x + 1, currentLocation.y);
                if (move(h, goal, false))
                    return true;
                else {
                    System.out.println("You can't move to this cell!");
                    return false;
                }
            }
            case "t" -> {
                int lane, x, y;
                Location current = heroLocation.get(h);
                lane = Utils.safeIntInput("Which lane you want to go? (1-3)", 1, 3) - 1;
                if (lane == current.getLane()) {
                    System.out.println("You can't teleport to current lane!");
                    return false;
                }
                x = Utils.safeIntInput("1 for left column, 2 for right column", 1, 2) - 1;
                y = Utils.safeIntInput("1 for top row, 8 for bottom row", 1, 8) - 1;
                Location goal = new Location(lane, x, y);
                if (goal.y < discovered[lane]) {
                    System.out.println("You can't teleport to undiscovered cell!");
                    return false;
                }
                if (move(h, goal, false))
                    return true;
                else {
                    System.out.println("You can't teleport to this cell!");
                    return false;
                }
            }
            case "b" -> {
                Location current = heroLocation.get(h);
                Location goal = new Location(current.x, 7);
                if (!move(h, goal, false)) {
                    if (current.x % 3 == 0)
                        goal = new Location(current.x + 1, 7);
                    else if (current.x % 3 == 1)
                        goal = new Location(current.x - 1, 7);
                    if (!move(h, goal, false))
                        System.out.println("Nexus is full!");
                        return false;
                }
                return true;
            }
            case "1" -> {
                Monster target = selectTarget(targets);
                if (target == null)
                    return false;

                double dodge = target.getDodge();
                if (random.nextDouble() <= dodge) {
                    System.out.println("Your attack is dodged by monster!");
                }
                else {
                    int damage = h.getDamage();
                    int defense = target.getDefense();
                    int finalDamage = Math.max(1, damage - defense);
                    target.reduceHP(finalDamage);
                    System.out.println("Hero " + h.getName() + " dealt " + finalDamage + " damage to monster!");
                }
                if (target.getHP_current() <= 0) {
                    System.out.println("Monster " + target.getName() + "is dead!");
                    monsterDead(h, target);
                }
                return true;
            }
            case "2" -> {
                Monster target = selectTarget(targets);
                if (target == null)
                    return false;
                if (!h.printSpell())
                    return false;
                int idx = Utils.safeIntInput("Select a spell:", 1, h.getSpells().size());
                h.cast(h.getSpell(idx-1), target);
                if (target.getHP_current() <= 0) {
                    monsterDead(h, target);
                }
                return true;
            }
            case "3" -> {
                displayHeroInformation(h);
                h.EnterBag();
                return false;
            }
            default -> {
                System.out.println("Illegal input.");
                return false;
            }
        }
    }

    // Place a hero or a monster into another grid.
    public boolean move (Character c, Location goal, boolean isDead) {
        Location current = heroLocation.get(c);
        if (goal.x < 0 || goal.y < 0 || goal.y >= map.row || goal.x >= map.column) {
            return false;
        }
        if (map.cells[goal.y][goal.x] instanceof InaccessibleCell) {
            return false;
        }
        if (c instanceof Hero) {
            for (Hero h : heroes.getHeroes()) {
                if (heroLocation.get(h).equals(goal))
                    return false;
            }
            for (Monster m : monsters.getMonsters()) {
                if (monsterLocation.get(m).y > goal.y
                        && monsterLocation.get(m).getLane() == goal.getLane())
                    return false;
            }
            heroLocation.put((Hero)c, goal);
            if (current != null)
                map.cells[current.y][current.x].outCellFunction(c);
            if (!isDead)
                map.cells[goal.y][goal.x].inCellFunction(c);
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

    // Detect if an enemy can be attacked.
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

    // Dead hero respawn in corresponding nexus.
    public void respawn (Hero h) {
        int lane = heroLocation.get(h).getLane();
        h.setHP_current(0);
        h.recover();
        h.loseMoney(h.getMoney() / 2);
        if (!move(h, new Location(lane, 0, 7), true))
            if (!move(h, new Location(lane, 1, 7), true))
                move(h, new Location(lane, 0, 6), true);

    }

    // Heroes gain money and exp when they kill a monster
    public void monsterDead (Hero killer, Monster victim) {
        int lv = victim.getLevel();
        monsterLocation.remove(victim);
        monsters.getMonsters().remove(victim);
        killer.addMoney(lv * 100);
        killer.addExp(2);
        System.out.println("Hero " + killer.getName() + " gain " + (lv * 100) + " money and 2 exp!");
    }

    // Select a target if there are multiple targets or return the only target.
    public Monster selectTarget (ArrayList<Monster> targets) {
        if (targets.size() == 0) {
            System.out.println("No target to attack!");
            return null;
        }
        if (targets.size() == 1) {
            return targets.get(0);
        }
        System.out.println("Select your target:");
        for (int i = 0; i < targets.size(); i++) {
            System.out.println((i+1) + ": " + targets.get(i).getName());
        }
        int idx = Utils.safeIntInput("Input:", 1, targets.size());
        return targets.get(idx-1);
    }
}
