
public class BossCell extends RPGCell {
    @Override
<<<<<<< HEAD
    public void cellFunction(Character player){
        BattleField battleField = BattleField.createABattleField(player);
        battleField.BossCome();
=======
    public void inCellFunction(Character NPC){
    }

    public void outCellFunction(Character NPC){

>>>>>>> main
    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "B";
    }
}
