/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author bjock1
 */
import java.applet.*;
import java.net.*;

public class SoundPlayer {
    private static AudioClip currentClip;
    
    public void play(String filename, boolean loop){
        stop();
        try{
            URL url = getClass().getResource(filename);
            currentClip = Applet.newAudioClip(url);
            if(loop){
                currentClip.loop();
            }
            else {
                currentClip.play();
            }
        }
        catch (Exception e){
            System.out.println("Sound error: "+filename);
        }
    }
    
    public static void stop(){
    if(currentClip!=null){
        currentClip.stop();
        currentClip=null;
        }
    }
}

