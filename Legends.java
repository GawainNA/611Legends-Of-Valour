
import java.util.Scanner;


public class Legends {
	
	public static final String ANSI_RESET = "\u001B[0m";
	public static final String ANSI_BLACK = "\u001B[30m";
	public static final String ANSI_RED = "\u001B[31m";
	public static final String ANSI_GREEN = "\u001B[32m";
	public static final String ANSI_YELLOW = "\u001B[33m";
	public static final String ANSI_BLUE = "\u001B[34m";
	public static final String ANSI_PURPLE = "\u001B[35m";
	public static final String ANSI_CYAN = "\u001B[36m";
	public static final String ANSI_WHITE = "\u001B[37m";
    Player player;
    Map map;
    Scanner scan =new Scanner(System.in);
    int HeroX = 0;
    int HeroY = 0;
    int row=10;
    int column=10;

    public void startGame() throws InterruptedException{
    	String welcome = "WELCOME TO LEGENDS...BUCKLE UP TO FLY.....";
        for (int i = 0; i < welcome.length(); i++) {
            System.out.print( ANSI_RED + welcome.charAt(i)+ ANSI_RESET);
            Thread.sleep(150L); // in milliseconds
        }

        AsciiartFactory.printHelicopter();
        System.out.println(ANSI_GREEN+"Please input your name:"+ ANSI_RESET);
        player=Player.createPlayer(scan.nextLine());
        System.out.println("You can input -1 to Exit anytime.");

        pickHero();
        System.out.println("Do you want to design the map size? Default is 10 by 10 (y/n)");
        if(scan.nextLine().equals("y")){
            row=Utils.safeIntInput("Input row (5-10):",5,10);
            column=Utils.safeIntInput("Input column(5-10):",5,10);
        }
        map=MapCreator.RandomCreateMap(row,column);
        map.Cells[0][0].setHeroLocated(true);
        System.out.println("Game Start!");
        out:while (true){
            map.printMap();
            System.out.println("w:up  s:down  a:left  d:right  b:Bag  i:Information e:Exit");
            switch (scan.nextLine()){
                case "w":{
                    if(HeroX-1>=0){
                        if(map.Cells[HeroX-1][HeroY].isAccessible()){
                            map.Cells[HeroX-1][HeroY].setHeroLocated(true);
                            map.Cells[HeroX][HeroY].setHeroLocated(false);
                            HeroX=HeroX-1;
                        }
                    }
                    break;
                }

                case "s":{
                    if(HeroX+1<5){
                        if(map.Cells[HeroX+1][HeroY].isAccessible()){
                            map.Cells[HeroX+1][HeroY].setHeroLocated(true);
                            map.Cells[HeroX][HeroY].setHeroLocated(false);
                            HeroX=HeroX+1;
                        }
                    }
                    break;
                }


                case "a":{
                    if(HeroY-1>=0){
                        if(map.Cells[HeroX][HeroY-1].isAccessible()){
                            map.Cells[HeroX][HeroY-1].setHeroLocated(true);
                            map.Cells[HeroX][HeroY].setHeroLocated(false);
                            HeroY=HeroY-1;
                        }
                    }
                    break;
                }

                case "d":{
                    if(HeroY+1<5){
                        if(map.Cells[HeroX][HeroY+1].isAccessible()){
                            map.Cells[HeroX][HeroY+1].setHeroLocated(true);
                            map.Cells[HeroX][HeroY].setHeroLocated(false);
                            HeroY=HeroY+1;
                        }
                    }
                    break;
                }
                case "i":displayInformation();break;
                case "b":{
                    player.EnterBag();
                    break;
                }
                case "e":break out;
            }
            map.Cells[HeroX][HeroY].cellFunction(player);
        }
    }

    void displayInformation(){
        player.displayHeroInformation();
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
                        player.addHero(tank);
                    }
                    break;
                }

                case 2:{
                    System.out.println("Warrior has high attack damage.");
                    System.out.println("Do you want to add Warrior to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        Hero warrior=HeroFactory.createWarrior(data.getWarrior());
                        player.addHero(warrior);
                    }
                    break;
                }
                case 3:{
                    System.out.println("Caster has high Magic damage, but low HP.");
                    System.out.println("Do you want to add Caster to your team?(y/n)");
                    if(scan.nextLine().equals("y")){
                        Hero Caster=HeroFactory.createCaster(data.getCaster());
                        player.addHero(Caster);
                    }
                }
            }
            if(player.heroes.size()<3){
                System.out.println("Do you want to select more heroes?(y/n)");
                if(scan.nextLine().equals("n")){break;}
            }else {
                System.out.println("You have chosen 3 heroes! Let's begin!");
                break;
            }
        }
    }
}