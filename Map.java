
public class Map {
	public static final String CYAN_BACKGROUND = "\033[46m";
	public static final String RESET = "\033[0m";
    int row;
    int column;
    RPGCell[][] Cells;

    Map(int row, int column){
        this.row=row;
        this.column=column;
        Cells = new RPGCell[row][column];
    }

    public void printMap(){
        String col_a="+";
        String col_b="|";
        for(int i=0;i<column;i++){
            col_a=col_a.concat("--+");
        }
        String result="";
        for(int i=0;i<row;i++){
            for(int j=0;j<column;j++){
                col_b=col_b.concat(Cells[i][j]+" |");
            }
            result=result.concat(col_a+"\n"+col_b+"\n");
            col_b="|";
        }
        result=result.concat(col_a);
        System.out.println(CYAN_BACKGROUND+result+RESET);
    }


}
