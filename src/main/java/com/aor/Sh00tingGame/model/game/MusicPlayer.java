package com.aor.Sh00tingGame.model.game;

import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.FloatControl;
import java.io.File;

public class MusicPlayer {
    private final Clip backgroundMusic;

    public MusicPlayer(String name) {
        this.backgroundMusic = loadMusic(name);
    }

    private Clip loadMusic(String name) throws NullPointerException{
        try {
            File musicFile = new File(MusicPlayer.class.getResource("/music/"+name+".wav").getFile());
            AudioInputStream audioInput = AudioSystem.getAudioInputStream(musicFile);
            Clip musicClip = AudioSystem.getClip();
            musicClip.open(audioInput);
            FloatControl gainControl = (FloatControl) musicClip.getControl(FloatControl.Type.MASTER_GAIN);
            gainControl.setValue(-20f);
            if(name == "background"){
                gainControl.setValue(-25f);
            }
            else{
                gainControl.setValue(-10f);
            }
            return musicClip;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void startMusic() {
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
        backgroundMusic.loop(Clip.LOOP_CONTINUOUSLY);
    }

    public void startMusicGun() {
        backgroundMusic.setMicrosecondPosition(0);
        backgroundMusic.start();
    }
    public void stopMusic() {
        backgroundMusic.stop();
    }
}