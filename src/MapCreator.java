
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


}
