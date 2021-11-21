import java.util.ArrayList;

public class TeamHero extends Team{
    ArrayList<Hero> heroes=new ArrayList<Hero>();
    public void addHero(Hero hero){
        heroes.add(hero);
    }
    public int size(){
        return heroes.size();
    }

    public ArrayList<Hero> getHeroes() {
        return heroes;
    }
}
