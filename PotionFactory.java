
public class PotionFactory {
    public static potion CreatePotion(String t){
        String[] data=t.split(" ");
        return new potion(data[0],Integer.parseInt(data[1]),Integer.parseInt(data[2]),Integer.parseInt(data[3]),Integer.parseInt(data[4]),Integer.parseInt(data[5]),Integer.parseInt(data[6]),Integer.parseInt(data[7]),Integer.parseInt(data[8]));
    }
}
