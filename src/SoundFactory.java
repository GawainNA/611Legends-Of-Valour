import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;

public class SoundFactory implements Runnable, PlayableWithBGM
{
    private boolean running = false;
    private Thread thread;
    private Playable game;

    public SoundFactory(Playable game)
    {
        this.game=game;
        this.start();
    }

    public void start()
    {
        if(running)
            return;
        this.thread = new Thread(this);
        this.running = true;
        this.thread.start();
    }

    //
    private boolean playSong = false;
    private AudioInputStream inputStream;
    private String url;
    private Clip clip;

    @Override
    public void run()
    {
        while(running)
        {
        	
            if(inputStream == null && playSong)
            {
                this.playSong = false;
                try
                {
                    this.inputStream = AudioSystem.getAudioInputStream(SoundFactory.class.getResource(url));
                    this.clip.open(inputStream);
                    this.clip.loop(10);
    }catch(Exception e)
                {
        e.printStackTrace();
    }
                }
            }
        }

    public void playBackGround(String string) // call to play .wav file
    {
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        try
        {
        	this.clip = AudioSystem.getClip();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
        }
        url = string+".wav";
        this.playSong = true;
        this.inputStream = null; 
        run();
    }

    public void GameStartWithBGM(String string){
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        try
        {
            this.clip = AudioSystem.getClip();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
        }
        url = string+".wav";
        this.playSong = true;
        this.inputStream = null;
        try
        {
            this.inputStream = AudioSystem.getAudioInputStream(SoundFactory.class.getResource(url));
            this.clip.open(inputStream);
            this.clip.loop(10);
            game.gameStart();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void GameRunningWithBGM(String string){
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        try
        {
            this.clip = AudioSystem.getClip();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
        }
        url = string+".wav";
        this.playSong = true;
        this.inputStream = null;
        try
        {
            this.inputStream = AudioSystem.getAudioInputStream(SoundFactory.class.getResource(url));
            this.clip.open(inputStream);
            this.clip.loop(10);
            while (game.judge()) {
                game.roundStart();
                game.roundEnd();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void GameEndWithBGM(String string){
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        try
        {
            this.clip = AudioSystem.getClip();
        }
        catch(LineUnavailableException e)
        {
            e.printStackTrace();
        }
        url = string+".wav";
        this.playSong = true;
        this.inputStream = null;
        try
        {
            this.inputStream = AudioSystem.getAudioInputStream(SoundFactory.class.getResource(url));
            this.clip.open(inputStream);
            this.clip.loop(0);
            game.gameEnd();
        }catch(Exception e)
        {
            e.printStackTrace();
        }
    }

    public void disposeSound()
    {
        if(this.clip != null)
        {
            this.clip.stop();
            this.clip.close();
        }
        this.clip = null;
        this.playSong = false;
        this.inputStream = null;
    }
}
