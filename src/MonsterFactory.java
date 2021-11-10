
public class MonsterFactory {

    public static Monster createDragon(String[] d){
        return Dragon.createAMonster(d[0],Integer.parseInt(d[1]),Float.parseFloat(d[2]),Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5]),Integer.parseInt(d[6]),Integer.parseInt(d[7]));
    }

    public static Monster createMonsterCaster(String[] d){
        return MonsterCaster.createAMonster(d[0],Integer.parseInt(d[1]),Float.parseFloat(d[2]),Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5]),Integer.parseInt(d[6]),Integer.parseInt(d[7]));
    }

    public static Monster createMonsterFighter(String[] d){
        return MonsterFighter.createAMonster(d[0],Integer.parseInt(d[1]),Float.parseFloat(d[2]),Integer.parseInt(d[3]),Integer.parseInt(d[4]),Integer.parseInt(d[5]),Integer.parseInt(d[6]),Integer.parseInt(d[7]));
    }

}
