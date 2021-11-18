import java.util.ArrayList;
import java.util.List;

enum CellType {
    NEXUS,
    PLAIN,
    KOULOU,
    CAVE,
    BUSH,
    INACCESSIBLE
}

public class Test {
	public static final String RESET = "\033[0m";  // Text Reset

    // Regular Colors
    public static final String BLACK = "\033[0;30m";   // BLACK
    public static final String RED = "\033[0;31m";     // RED
    public static final String GREEN = "\033[0;32m";   // GREEN
    public static final String YELLOW = "\033[0;33m";  // YELLOW
    public static final String BLUE = "\033[0;34m";    // BLUE
    public static final String PURPLE = "\033[0;35m";  // PURPLE
    public static final String CYAN = "\033[0;36m";    // CYAN
    public static final String WHITE = "\033[0;37m";   // WHITE

    // Bold
    public static final String BLACK_BOLD = "\033[1;30m";  // BLACK
    public static final String RED_BOLD = "\033[1;31m";    // RED
    public static final String GREEN_BOLD = "\033[1;32m";  // GREEN
    public static final String YELLOW_BOLD = "\033[1;33m"; // YELLOW
    public static final String BLUE_BOLD = "\033[1;34m";   // BLUE
    public static final String PURPLE_BOLD = "\033[1;35m"; // PURPLE
    public static final String CYAN_BOLD = "\033[1;36m";   // CYAN
    public static final String WHITE_BOLD = "\033[1;37m";  // WHITE

    // Underline
    public static final String BLACK_UNDERLINED = "\033[4;30m";  // BLACK
    public static final String RED_UNDERLINED = "\033[4;31m";    // RED
    public static final String GREEN_UNDERLINED = "\033[4;32m";  // GREEN
    public static final String YELLOW_UNDERLINED = "\033[4;33m"; // YELLOW
    public static final String BLUE_UNDERLINED = "\033[4;34m";   // BLUE
    public static final String PURPLE_UNDERLINED = "\033[4;35m"; // PURPLE
    public static final String CYAN_UNDERLINED = "\033[4;36m";   // CYAN
    public static final String WHITE_UNDERLINED = "\033[4;37m";  // WHITE

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
    public static final String BLACK_BRIGHT = "\033[0;90m";  // BLACK
    public static final String RED_BRIGHT = "\033[0;91m";    // RED
    public static final String GREEN_BRIGHT = "\033[0;92m";  // GREEN
    public static final String YELLOW_BRIGHT = "\033[0;93m"; // YELLOW
    public static final String BLUE_BRIGHT = "\033[0;94m";   // BLUE
    public static final String PURPLE_BRIGHT = "\033[0;95m"; // PURPLE
    public static final String CYAN_BRIGHT = "\033[0;96m";   // CYAN
    public static final String WHITE_BRIGHT = "\033[0;97m";  // WHITE

    // Bold High Intensity
    public static final String BLACK_BOLD_BRIGHT = "\033[1;90m"; // BLACK
    public static final String RED_BOLD_BRIGHT = "\033[1;91m";   // RED
    public static final String GREEN_BOLD_BRIGHT = "\033[1;92m"; // GREEN
    public static final String YELLOW_BOLD_BRIGHT = "\033[1;93m";// YELLOW
    public static final String BLUE_BOLD_BRIGHT = "\033[1;94m";  // BLUE
    public static final String PURPLE_BOLD_BRIGHT = "\033[1;95m";// PURPLE
    public static final String CYAN_BOLD_BRIGHT = "\033[1;96m";  // CYAN
    public static final String WHITE_BOLD_BRIGHT = "\033[1;97m"; // WHITE

    // High Intensity backgrounds
    public static final String BLACK_BACKGROUND_BRIGHT = "\033[0;100m";// BLACK
    public static final String RED_BACKGROUND_BRIGHT = "\033[0;101m";// RED
    public static final String GREEN_BACKGROUND_BRIGHT = "\033[0;102m";// GREEN
    public static final String YELLOW_BACKGROUND_BRIGHT = "\033[0;103m";// YELLOW
    public static final String BLUE_BACKGROUND_BRIGHT = "\033[0;104m";// BLUE
    public static final String PURPLE_BACKGROUND_BRIGHT = "\033[0;105m"; // PURPLE
    public static final String CYAN_BACKGROUND_BRIGHT = "\033[0;106m";  // CYAN
    public static final String WHITE_BACKGROUND_BRIGHT = "\033[0;107m";   // WHITE

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

    private static String getCellComponent(int row, int col){
        if (row == 6 && col == 1){
            return GREEN_BACKGROUND_BRIGHT+"H1   "+ CYAN_BACKGROUND;
        }else if (row == 1 && col == 3){
            return GREEN_BACKGROUND_BRIGHT+"H2   "+ CYAN_BACKGROUND;
        }else if (row == 3 && col == 1){
            return RED_BACKGROUND_BRIGHT+"   M1"+ CYAN_BACKGROUND;
        }else if (row == 1 && col == 4){
            return RED_BACKGROUND_BRIGHT+"   M2"+ CYAN_BACKGROUND;
        }else if (row == 3 && col == 6){
            return GREEN_BACKGROUND_BRIGHT+"H3 M3" + CYAN_BACKGROUND;
        }else{
            return "     ";
        }
    }

    private static void createInnerCell(CellType[][] map, List<StringBuilder> printableMap, int row, int col) {
        String component = getCellComponent(row/3, col);
        if (map[row/3][col] == CellType.INACCESSIBLE)
            component = RED_BACKGROUND+"X X X"+CYAN_BACKGROUND;
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

    public static void main(String[] args) {
        int size = 8;

        // Indicative information of what is shown on the grid
        // THe implementation is not dynamic thus changing the following values will not change the map projection
        final int nexus = 0;
        final int plain = 1;
        final int koulou = 2;
        final int cave = 3;
        final int bush = 4;
        final int nonacc = 5;

        int hero1row = 7;
        int hero1col = 1;

        int hero2row = 1;
        int hero2col = 3;

        int hero3row = 3;
        int hero3col = 6;


        int monster1row = 3;
        int monster1col = 1;

        int monster2row = 1;
        int monster2col = 4;

        int monster3row = 3;
        int monster3col = 6;

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
                        createInnerCell(map, printableMap, row, col);
                    }

                    if (col == size - 1)
                        printableMap.get(row).append("\n");
                }
            }else{
                for (int col = 0; col < size; col++) {
                    if (row % 2 == 1){
                        createOutterCell(map, printableMap, row, col);
                    }else{
                        createInnerCell(map, printableMap, row, col);
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
            System.out.print(CYAN_BACKGROUND_BRIGHT+printableMap.get(i));}
        	else if (i%3==1) {
        		System.out.print(CYAN_BACKGROUND +printableMap.get(i));
        	}
        	else if (i%3==2) {
        		System.out.print(WHITE_BACKGROUND+printableMap.get(i));
        	}
        }
    }
}
