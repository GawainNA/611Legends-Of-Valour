import java.util.ArrayList;

public class TeamMonster {
    ArrayList<Monster> monsters=new ArrayList<Monster>();

    public ArrayList<Monster> getMonsters() {
        return monsters;
    }

    public void add(Monster monster){
        monsters.add(monster);
    }
}
