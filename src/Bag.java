
import java.util.ArrayList;

public class Bag {
    ArrayList<Item> content = new ArrayList<Item>();

    public void add(Item item){
        content.add(item);
    }

    public void remove(Item item){
        content.remove(item);
    }

    public void printContent(){
        String result="";
        for(int i = 1; i<=content.size(); i++){
            result=result.concat(i+". "+content.get(i-1).getName()+"\n");
        }
        System.out.println(result);
    }

    public Item get(int index){
        return content.get(index);
    }

    public int size(){
        return content.size();
    }

    public void useItem(Item item, Hero hero){
        item.UseFromBag(this, hero);
    }
}
