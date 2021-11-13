import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class LegendsValor {
    class location{
        int x;
        int y;
    }
    TeamHero heroes;
    TeamMonster monsters;
    Scanner scan =new Scanner(System.in);

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
}
