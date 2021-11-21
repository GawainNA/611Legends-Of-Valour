import java.io.*;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.List;

public class data {

    public static List<String> getArmorData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Armory.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getWeaponData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Weaponry.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getIceSpellData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "IceSpells.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getFireSpellData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "FireSpells.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getLightSpellData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "LightningSpells.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getWarriorData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Warriors.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getCasterData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Casters.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getTankData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Tanks.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getDragonData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "Dragons.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getMonsterFighterData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "MonsterFighters.txt";
        List<String> lines = Collections.emptyList();
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

    public static List<String> getMonsterCasterData(){
        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + "MonsterCasters.txt";
        List<String> lines = Collections.emptyList();
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



    //potion data          {name,price,level,HP,MP,AD,AP,AR,MR}
    static String[] potion={"Little_Heal_Potion 100 1 100 0 0 0 0 0","Little_Mana_Potion 100 1 0 100 0 0 0 0",
            "AD_Strength_Potion 100 1 0 0 30 0 0 0","AP_Strength_Potion 100 1 0 0 0 40 0 0"};

    public static String[] getPotion(){
        return potion;
    }
}
