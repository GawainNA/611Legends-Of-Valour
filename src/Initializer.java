//// Read files and initialize the game database.
//
//import java.io.IOException;
//import java.nio.charset.StandardCharsets;
//import java.nio.file.Files;
//import java.nio.file.Paths;
//import java.util.ArrayList;
//import java.util.Arrays;
//import java.util.Collections;
//import java.util.List;
//
//public class Initializer {
//    public static ArrayList<Monster> initializeMonster (List<String> lines, ArrayList<Monster> list, String type) {
//        lines.remove(0);
//        lines.removeIf(o -> o.equals(""));
//        switch(type) {
//            case "dragon":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    Dragon o = new Dragon(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)));
//                    list.add(o);
//                }
//                break;
//            case "exoskeleton":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    Exoskeleton o = new Exoskeleton(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)));
//                    list.add(o);
//                }
//                break;
//            case "spirit":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    Spirit o = new Spirit(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)));
//                    list.add(o);
//                }
//                break;
//        }
//
//        return list;
//    }
//
//    public static ArrayList<Hero> initializeHero (List<String> lines, ArrayList<Hero> list, String type) {
//        lines.remove(0);
//        lines.removeIf(o -> o.equals(""));
//        switch(type) {
//            case "warrior":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    Warrior o = new Warrior(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)), Integer.parseInt(att.get(5)),
//                            Integer.parseInt(att.get(6)));
//                    list.add(o);
//                }
//                break;
//            case "paladin":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    Paladin o = new Paladin(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)), Integer.parseInt(att.get(5)),
//                            Integer.parseInt(att.get(6)));
//                    list.add(o);
//                }
//                break;
//            case "sorcerer":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    Sorcerer o = new Sorcerer(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)), Integer.parseInt(att.get(5)),
//                            Integer.parseInt(att.get(6)));
//                    list.add(o);
//                }
//                break;
//        }
//
//        return list;
//    }
//
//    public static ArrayList<Spell> initializeSpell (List<String> lines, ArrayList<Spell> list, String type) {
//        lines.remove(0);
//        lines.removeIf(o -> o.equals(""));
//        switch(type) {
//            case "fire":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    FireSpell o = new FireSpell(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)));
//                    list.add(o);
//                }
//                break;
//            case "ice":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    IceSpell o = new IceSpell(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)));
//                    list.add(o);
//                }
//                break;
//            case "lightning":
//                for (String line : lines) {
//                    List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//                    att.removeAll(Arrays.asList("\t", "", null));
//                    LightningSpell o = new LightningSpell(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                            Integer.parseInt(att.get(3)), Integer.parseInt(att.get(4)));
//                    list.add(o);
//                }
//                break;
//        }
//
//        return list;
//    }
//
//    public static ArrayList<Armor> initializeArmor (List<String> lines, ArrayList<Armor> list) {
//        lines.remove(0);
//        lines.removeIf(o -> o.equals(""));
//        for (String line : lines) {
//            List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//            att.removeAll(Arrays.asList("\t", "", null));
//            Armor o = new Armor(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                    Integer.parseInt(att.get(3)));
//            list.add(o);
//        }
//
//        return list;
//    }
//
//    public static ArrayList<Weapon> initializeWeapon (List<String> lines, ArrayList<Weapon> list) {
//        lines.remove(0);
//        lines.removeIf(o -> o.equals(""));
//        for (String line : lines) {
//            List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//            att.removeAll(Arrays.asList("\t", "", null));
//            Weapon o = new Weapon(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                    Integer.parseInt(att.get(3)));
//            list.add(o);
//        }
//
//        return list;
//    }
//
//    public static ArrayList<Potion> initializePotion (List<String> lines, ArrayList<Potion> list) {
//        lines.remove(0);
//        lines.removeIf(o -> o.equals(""));
//        for (String line : lines) {
//            List<String> att = new ArrayList<String>(Arrays.asList(line.split("\\s+")));
//            att.removeAll(Arrays.asList("\t", "", null));
//            Potion o = new Potion(att.get(0), Integer.parseInt(att.get(1)), Integer.parseInt(att.get(2)),
//                    Integer.parseInt(att.get(3)), att.get(att.size() - 1));
//            list.add(o);
//        }
//
//        return list;
//    }
//
//    // This method is used in my main Game class, the variables represent corresponding ArrayLists.
//    public static void loadGame () {
//        String[] files = new String[]{"Armory.txt", "Dragons.txt", "Exoskeletons.txt", "FireSpells.txt", "IceSpells.txt",
//                "LightningSpells.txt", "Paladins.txt", "Potions.txt", "Sorcerers.txt", "Spirits.txt", "Warriors.txt", "Weaponry.txt"};
//
//        for (String fileName : files) {
//            List<String> lines = loadConfig(fileName);
//            switch(fileName) {
//                case "Armory.txt":
//                    armors = Initializer.initializeArmor(lines, armors);
//                    break;
//                case "Weaponry.txt":
//                    weapons = Initializer.initializeWeapon(lines, weapons);
//                    break;
//                case "Potions.txt":
//                    potions = Initializer.initializePotion(lines, potions);
//                    break;
//                case "Dragons.txt":
//                    monsters = Initializer.initializeMonster(lines, monsters, "dragon");
//                    break;
//                case "Exoskeletons.txt":
//                    monsters = Initializer.initializeMonster(lines, monsters, "exoskeleton");
//                    break;
//                case "Spirits.txt":
//                    monsters = Initializer.initializeMonster(lines, monsters, "spirit");
//                    break;
//                case "Warriors.txt":
//                    heroes = Initializer.initializeHero(lines, heroes, "warrior");
//                    break;
//                case "Paladins.txt":
//                    heroes = Initializer.initializeHero(lines, heroes, "paladin");
//                    break;
//                case "Sorcerers.txt":
//                    heroes = Initializer.initializeHero(lines, heroes, "sorcerer");
//                    break;
//                case "FireSpells.txt":
//                    spells = Initializer.initializeSpell(lines, spells, "fire");
//                    break;
//                case "IceSpells.txt":
//                    spells = Initializer.initializeSpell(lines, spells, "ice");
//                    break;
//                case "LightningSpells.txt":
//                    spells = Initializer.initializeSpell(lines, spells, "lightning");
//                    break;
//            }
//        }
//    }
//
//    public static List<String> loadConfig (String fileName) {
//        String file = System.getProperty("user.dir") + "/src/ConfigFiles/" + fileName;
//        List<String> lines = Collections.emptyList();
//        try {
//            lines = Files.readAllLines(Paths.get(file), StandardCharsets.UTF_8);
//        } catch (IOException e) {
//            System.out.println("Please enter the correct filepath");
//            e.printStackTrace();
//        }
//        return lines;
//    }
//}
