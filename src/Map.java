
public class Map {
    int row;
    int column;
    RPGCell[][] cells;

    Map(int row, int column){
        this.row=row;
        this.column=column;
        cells = new RPGCell[row][column];
    }

    public Map() {
        this(8, 8);
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
                col_b=col_b.concat(cells[i][j]+" |");
            }
            result=result.concat(col_a+"\n"+col_b+"\n");
            col_b="|";
        }
        result=result.concat(col_a);
        System.out.println(result);
    }

}
