

import java.util.Random;

public class DangerousCell extends RPGCell {
    @Override
    public void inCellFunction(Character NPC){/*
        Random random=new Random();
        int dice=random.nextInt(100);

        if(dice>50) {
            System.out.println("Monsters Find You. Battle Begins!");
            BattleField battleField = BattleField.createABattleField(player);
            battleField.BattleBegin();
        }*/

    }

    public void outCellFunction(Character NPC){}
    public String toString(){
        if(isHeroLocated){
            return "*";
        }
        return "?";
    }
}
