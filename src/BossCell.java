
public class BossCell extends RPGCell {
    @Override
    public void cellFunction(Player player){
        BattleField battleField = BattleField.createABattleField(player);
        battleField.BossCome();
    }
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "B";
    }
}