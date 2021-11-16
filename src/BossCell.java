
public class BossCell extends RPGCell {
    @Override
    public void inCellFunction(Character NPC){
        // BattleField battleField = BattleField.createABattleField(player);
        // battleField.BossCome();
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
