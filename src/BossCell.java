
public class BossCell extends RPGCell {

    @Override

    public void inCellFunction(Character NPC){
    }

    public void outCellFunction(Character NPC){


    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "B";
    }
}
