
import java.util.ArrayList;
import java.util.Collections;


public class MapCreator {

    static Map RandomCreateMap(int m,int n){
        Map map = new Map(m,n);
        int num=m*n;
        int market_num=num/10;
        int x_num=(int)(num*0.2);
        int danger_num=(int)(num*0.4);
        int safe_num=num-market_num-x_num-danger_num;

        ArrayList<RPGCell> initial=new ArrayList<RPGCell>();
        for(int i=0;i<market_num;i++ ){
            initial.add(new MarketCell());
        }
        for(int i=0;i<x_num;i++ ){
            initial.add(new InaccessibleCell());
        }
        for(int i=0;i<danger_num;i++ ){
            initial.add(new DangerousCell());
        }
        for(int i=0;i<safe_num;i++ ){
            initial.add(new SafeCell());
        }

        Collections.shuffle(initial);

        for (int i =0;i<m;i++){
            for(int j=0;j<n;j++){
                map.Cells[i][j]=initial.get(0);
                initial.remove(0);
            }
        }
        map.Cells[0][0]=new SafeCell();
        map.Cells[0][1]=new SafeCell();
        map.Cells[1][0]=new SafeCell();
        map.Cells[m-1][n-1]=new BossCell();
        map.Cells[m-1][n-2]=new DangerousCell();
        map.Cells[m-2][n-1]=new DangerousCell();

        return map;
    }

    public static Map ValorMap(){
        Map map=new Map(8,8);
        map.Cells= new RPGCell[][]{{new MonsterNexus(),new MonsterNexus(),new InaccessibleCell(),new MonsterNexus(),new MonsterNexus(),new InaccessibleCell(),new MonsterNexus(),new MonsterNexus()},
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
