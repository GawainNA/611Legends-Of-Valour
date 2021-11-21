import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class data {

    private static List<String> getLines(String file) {
        List<String> lines;
        try {
            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
            lines.remove(0);
            return lines;
        } catch (IOException e) {
            System.out.println("Please enter the correct filepath");
            e.printStackTrace();
        }
        return null;
    }

    public static List<String> getArmorData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "Armory.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Armory.txt";
        return getLines(file);
    }

    public static List<String> getWeaponData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "Weaponry.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Weaponry.txt";
        return getLines(file);
    }

    public static List<String> getIceSpellData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "IceSpells.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "IceSpells.txt";
        return getLines(file);
    }

    public static List<String> getFireSpellData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "FireSpells.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "FireSpells.txt";
        return getLines(file);
    }

    public static List<String> getLightSpellData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "LightningSpells.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "LightningSpells.txt";
        return getLines(file);
    }

    public static List<String> getWarriorData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "Warriors.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Warriors.txt";
        return getLines(file);
    }

    public static List<String> getCasterData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "Casters.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Casters.txt";
        return getLines(file);
    }

    public static List<String> getTankData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "Tanks.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Tanks.txt";
        return getLines(file);
    }

    public static List<String> getDragonData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "Dragons.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Dragons.txt";
        return getLines(file);
    }

    public static List<String> getMonsterFighterData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "MonsterFighters.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "MonsterFighters.txt";
        return getLines(file);
    }

    public static List<String> getMonsterCasterData(){
        String file;
        if (System.getProperty("user.dir").contains("src"))
            file = System.getProperty("user.dir") + "/ConfigFiles/" + "MonsterCasters.txt";
        else
            file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "MonsterCasters.txt";
        return getLines(file);
    }



    //potion data          {name,price,level,HP,MP,AD,AP,AR,MR}
    static String[] potion={"Little_Heal_Potion 100 1 100 0 0 0 0 0","Little_Mana_Potion 100 1 0 100 0 0 0 0",
            "AD_Strength_Potion 100 1 0 0 30 0 0 0","AP_Strength_Potion 100 1 0 0 0 40 0 0"};

    public static String[] getPotion(){
        return potion;
    }
}
