public interface Playable {
    void gameStart() throws InterruptedException;
    void gameEnd();
    void roundStart();
    void roundEnd();
    void run() throws InterruptedException;
    boolean judge();
}