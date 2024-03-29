import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

enum CellType {
    NEXUS,
    PLAIN,
    KOULOU,
    CAVE,
    BUSH,
    INACCESSIBLE
}

public class PrintableValorMap {
	public static final String RESET = "\033[0m";  // Text Reset

    // Background
    public static final String BLACK_BACKGROUND = "\033[40m";  // BLACK
    public static final String RED_BACKGROUND = "\033[41m";    // RED
    public static final String GREEN_BACKGROUND = "\033[42m";  // GREEN
    public static final String YELLOW_BACKGROUND = "\033[43m"; // YELLOW
    public static final String BLUE_BACKGROUND = "\033[44m";   // BLUE
    public static final String PURPLE_BACKGROUND = "\033[45m"; // PURPLE
    public static final String CYAN_BACKGROUND = "\033[46m";   // CYAN
    public static final String WHITE_BACKGROUND = "\033[47m";  // WHITE


    // High Intensity
    public static final String BLACK_BRIGHT ="\033[0;90m";  // BLACK
    public static final String RED_BRIGHT ="\033[0;91m";    // RED
    public static final String GREEN_BRIGHT ="\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT ="\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT ="\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT ="\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT ="\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT ="\033[0;97m";  // WHITE

    //words color
    public static final String ANSI_RESET ="\u001B[0m";
    public static final String ANSI_BLACK ="\u001B[30m";
    public static final String ANSI_RED ="\u001B[31m";
    public static final String ANSI_GREEN ="\u001B[32m";
    public static final String ANSI_YELLOW ="\u001B[33m";
    public static final String ANSI_BLUE ="\u001B[34m";
    public static final String ANSI_PURPLE ="\u001B[35m";
    public static final String ANSI_CYAN ="\u001B[36m";
    public static final String ANSI_WHITE ="\u001B[37m";

    private static String getOuterCellStr(String c){
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
                heroIcon= CYAN_BRIGHT+"H"+indexH+ANSI_RESET;
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
                monsterIcon = RED_BRIGHT+"M"+indexM+ANSI_RESET;
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
            component = RED_BACKGROUND+"X X X"+RESET;
        printableMap.get(row).append(getInnerCellStr(component));
    }

    private static void createOutterCell(CellType[][] map, List<StringBuilder> printableMap, int row, int col) {
        switch (map[row/3][col]){
            case NEXUS:
                printableMap.get(row).append(getOuterCellStr(ANSI_GREEN+'N'+ANSI_RESET));
                break;
            case PLAIN:
                printableMap.get(row).append(getOuterCellStr("P"));
                break;
            case KOULOU:
                printableMap.get(row).append(getOuterCellStr(ANSI_PURPLE+'K'+ANSI_RESET));
                break;
            case CAVE:
                printableMap.get(row).append(getOuterCellStr(ANSI_YELLOW+'C'+ANSI_RESET));
                break;
            case BUSH:
                printableMap.get(row).append(getOuterCellStr(ANSI_BLUE+'B'+ANSI_RESET));
                break;
            case INACCESSIBLE:
                printableMap.get(row).append(getOuterCellStr(ANSI_RED+"I"+ANSI_RESET));
                break;
        }
    }

    public static void printMap(Map innerMap,HashMap<Hero, LegendsValor.Location> HL, HashMap<Monster, LegendsValor.Location> ML, TeamHero heroes, TeamMonster monsters) {
        int size = 8;


        CellType [][]map = new CellType[8][8];

        for(int i=0;i<innerMap.getRow();i++){
            for(int j=0;j< innerMap.getColumn();j++){
                if(innerMap.cells[i][j] instanceof NexusCell){
                    map[i][j] = CellType.NEXUS;
                } else if(innerMap.cells[i][j] instanceof InaccessibleCell){
                    map[i][j] = CellType.INACCESSIBLE;
                } else if(innerMap.cells[i][j] instanceof SafeCell){
                    map[i][j] = CellType.PLAIN;
                } else if(innerMap.cells[i][j] instanceof BushCell){
                    map[i][j] = CellType.BUSH;
                } else if(innerMap.cells[i][j] instanceof CaveCell){
                    map[i][j] = CellType.CAVE;
                } else if(innerMap.cells[i][j] instanceof KoulouCell){
                    map[i][j] = CellType.KOULOU;
                }
            }
        }

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
        	if (i%3==0) {
                System.out.print(printableMap.get(i));}
            	else if (i%3==1) {
            		System.out.print(printableMap.get(i));
            	}
            	else if (i%3==2) {
            		System.out.print(printableMap.get(i));
        }}
    }
}
