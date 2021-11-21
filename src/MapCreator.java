import java.util.ArrayList;
import java.util.Collections;

public class MapCreator {
    public static Map ValorMap(){
        Map map=new Map(8,8);
        map.cells= new RPGCell[][]{{new MonsterNexus(),new MonsterNexus(),new InaccessibleCell(),new MonsterNexus(),new MonsterNexus(),new InaccessibleCell(),new MonsterNexus(),new MonsterNexus()},
                                   {new SafeCell(),    new SafeCell(),    new InaccessibleCell(),new CaveCell(),    new SafeCell(),    new InaccessibleCell(),new BushCell(),    new BushCell()},
                                   {new SafeCell(),    new SafeCell(),    new InaccessibleCell(),new SafeCell(),    new SafeCell(),    new InaccessibleCell(),new SafeCell(),    new SafeCell()},
                                   {new CaveCell(),    new BushCell(),    new InaccessibleCell(),new BushCell(),    new KoulouCell(),  new InaccessibleCell(),new KoulouCell(),  new SafeCell()},
                                   {new SafeCell(),    new SafeCell(),    new InaccessibleCell(),new BushCell(),    new SafeCell(),    new InaccessibleCell(),new SafeCell(),    new BushCell()},
                                   {new KoulouCell(),  new KoulouCell(),  new InaccessibleCell(),new KoulouCell(),  new SafeCell(),    new InaccessibleCell(),new SafeCell(),    new SafeCell()},
                                   {new SafeCell(),    new SafeCell(),    new InaccessibleCell(),new SafeCell(),    new SafeCell(),    new InaccessibleCell(),new SafeCell(),    new SafeCell()},
                                   {new HeroNexus(),   new HeroNexus(),   new InaccessibleCell(),new HeroNexus(),   new HeroNexus(),   new InaccessibleCell(),new HeroNexus(),   new HeroNexus()}};
        return map;
    }

    public static Map RandomValorMap(){
        Map map = new Map(8,8);
        int cave=7;
        int bush=7;
        int koulou=7;
        int safe_num=15;

        ArrayList<RPGCell> initial=new ArrayList<RPGCell>();
        for(int i=0;i<cave;i++ ){
            initial.add(new CaveCell());
        }
        for(int i=0;i<bush;i++ ){
            initial.add(new BushCell());
        }
        for(int i=0;i<koulou;i++ ){
            initial.add(new KoulouCell());
        }
        for(int i=0;i<safe_num;i++ ){
            initial.add(new SafeCell());
        }

        Collections.shuffle(initial);

        map.cells[0] = new RPGCell[]{new MonsterNexus(),new MonsterNexus(),new InaccessibleCell(),new MonsterNexus(),new MonsterNexus(),new InaccessibleCell(),new MonsterNexus(),new MonsterNexus()};
        map.cells[7] = new RPGCell[]{new HeroNexus(),   new HeroNexus(),   new InaccessibleCell(),new HeroNexus(),   new HeroNexus(),   new InaccessibleCell(),new HeroNexus(),   new HeroNexus()};

        for(int row = 1;row< 7;row++){
            for (int column = 0;column<8;column++){
                if(column==2||column==5){
                    map.cells[row][column]= new InaccessibleCell();
                }else {
                    map.cells[row][column]= initial.get(0);
                    initial.remove(0);
                }

            }
        }
        return map;
    }


}
