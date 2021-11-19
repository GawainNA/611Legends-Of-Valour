import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

enum CellType {
    NEXUS,
    PLAIN,
    KOULOU,
    CAVE,
    BUSH,
    INACCESSIBLE
}

public class PrintableValorMap {

    private static String getOuterCellStr(char c){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < 2; i++) {
            str.append(c).append(" - ");
        }
        str.append(c).append("   ");
        return str.toString();
    }

    private static String getInnerCellStr(String component){
        return "| " + component + " |   ";
    }

    private static String getCellComponent(int row, int col,HashMap<Hero, LegendsValor.Location> HL, HashMap<Monster, LegendsValor.Location> ML, TeamHero heroes,TeamMonster monsters){
        int indexH = 1;
        String heroIcon=null;
        for(Hero hero :heroes.getHeroes()){
            if(col == HL.get(hero).x && row == HL.get(hero).y){
                heroIcon="H"+indexH;
                break;
            }
            indexH++;
        }
        if(heroIcon==null){
            heroIcon="  ";
        }

        int indexM=1;
        String monsterIcon=null;
        for(Monster monster: monsters.getMonsters()){
            if(col == ML.get(monster).x && row == ML.get(monster).y){
                monsterIcon = "M"+indexM;
            }
            indexM++;
        }
        if(monsterIcon==null){
            monsterIcon="  ";
        }

        return heroIcon+" "+monsterIcon;
    }

    private static void createInnerCell(CellType[][] map, List<StringBuilder> printableMap, int row, int col,HashMap<Hero, LegendsValor.Location> HL, HashMap<Monster, LegendsValor.Location> ML, TeamHero heroes,TeamMonster monsters) {
        String component = getCellComponent(row/3, col,HL,ML,heroes,monsters);
        if (map[row/3][col] == CellType.INACCESSIBLE)
            component = "X X X";
        printableMap.get(row).append(getInnerCellStr(component));
    }

    private static void createOutterCell(CellType[][] map, List<StringBuilder> printableMap, int row, int col) {
        switch (map[row/3][col]){
            case NEXUS:
                printableMap.get(row).append(getOuterCellStr('N'));
                break;
            case PLAIN:
                printableMap.get(row).append(getOuterCellStr('P'));
                break;
            case KOULOU:
                printableMap.get(row).append(getOuterCellStr('K'));
                break;
            case CAVE:
                printableMap.get(row).append(getOuterCellStr('C'));
                break;
            case BUSH:
                printableMap.get(row).append(getOuterCellStr('B'));
                break;
            case INACCESSIBLE:
                printableMap.get(row).append(getOuterCellStr('I'));
                break;
        }
    }

    public static void printMap(HashMap<Hero, LegendsValor.Location> HL, HashMap<Monster, LegendsValor.Location> ML, TeamHero heroes,TeamMonster monsters) {
        int size = 8;


        CellType [][]map = {
                {CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS},
                {CellType.PLAIN, CellType.PLAIN, CellType.INACCESSIBLE, CellType.CAVE, CellType.PLAIN, CellType.INACCESSIBLE, CellType.BUSH, CellType.BUSH},
                {CellType.PLAIN, CellType.PLAIN, CellType.INACCESSIBLE, CellType.PLAIN, CellType.PLAIN, CellType.INACCESSIBLE, CellType.PLAIN, CellType.PLAIN},
                {CellType.CAVE, CellType.BUSH, CellType.INACCESSIBLE, CellType.BUSH, CellType.KOULOU, CellType.INACCESSIBLE, CellType.KOULOU, CellType.PLAIN},
                {CellType.PLAIN, CellType.PLAIN, CellType.INACCESSIBLE, CellType.BUSH, CellType.PLAIN, CellType.INACCESSIBLE, CellType.PLAIN, CellType.BUSH},
                {CellType.KOULOU, CellType.KOULOU, CellType.INACCESSIBLE, CellType.KOULOU, CellType.PLAIN, CellType.INACCESSIBLE, CellType.PLAIN, CellType.PLAIN},
                {CellType.PLAIN, CellType.PLAIN, CellType.INACCESSIBLE, CellType.PLAIN, CellType.PLAIN, CellType.INACCESSIBLE, CellType.PLAIN, CellType.PLAIN},
                {CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS, CellType.INACCESSIBLE, CellType.NEXUS, CellType.NEXUS}
        };

        List<StringBuilder> printableMap = new ArrayList<StringBuilder>();

        for (int row = 0; row < size * 3; row++) {
            printableMap.add(new StringBuilder());
            if ((row / 3) % 2 == 0){
                for (int col = 0; col < size; col++) {
                    if (row % 2 == 0){
                        createOutterCell(map, printableMap, row, col);
                    }else{
                        createInnerCell(map, printableMap, row, col, HL ,ML,heroes,monsters);
                    }

                    if (col == size - 1)
                        printableMap.get(row).append("\n");
                }
            }else{
                for (int col = 0; col < size; col++) {
                    if (row % 2 == 1){
                        createOutterCell(map, printableMap, row, col);
                    }else{
                        createInnerCell(map, printableMap, row, col, HL,ML,heroes,monsters);
                    }

                    if (col == size - 1)
                        printableMap.get(row).append("\n");
                }
            }

            if (row % 3 == 2)
                printableMap.get(row).append("\n");
        }

        for (int i = 0; i < size * 3; i++) {
            System.out.print(printableMap.get(i));
        }
    }
}