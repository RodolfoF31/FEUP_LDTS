package com.aor.Sh00tingGame.controller.game;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.MusicPlayer;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Coin;

public class HeroController extends GameController {

    private boolean hit = false;
    public HeroController(Arena arena) {
        super(arena);
        getModel().getShoot().setPosition(arena.getHero().getPosition());
        getModel().getShoot().setDamage(getModel().getHero().getPistol().getDamage());
        getModel().getShoot().setRange(getModel().getHero().getPistol().getRange());
    }

    public boolean getHit() {
        return hit;
    }

    public void setHit(boolean hit) {
        this.hit = hit;
    }

    private void verifyPosition(){
        if(getModel().getHero().getPosition() != getModel().getShoot().getPosition()){
            getModel().getShoot().setPosition(getModel().getHero().getPosition());
        }
    }

    public void soundShoot(String weapon){
        MusicPlayer musicPlayer = new MusicPlayer(weapon);
        musicPlayer.startMusicGun();
    }

    public void soundStep(){
        MusicPlayer musicPlayer = new MusicPlayer("step");
        musicPlayer.startMusicGun();
    }

    public void moveHeroLeft() {
        verifyPosition();
        soundStep();
        moveHero(getModel().getHero().getPosition().getLeft());
        moveShoot(getModel().getShoot().getPosition().getLeft());
    }

    public void moveHeroRight() {
        verifyPosition();
        soundStep();
        moveHero(getModel().getHero().getPosition().getRight());
        moveShoot(getModel().getShoot().getPosition().getRight());
    }

    public void moveHeroUp() {
        verifyPosition();
        soundStep();
        soundStep();
        moveHero(getModel().getHero().getPosition().getUp());
        moveShoot(getModel().getShoot().getPosition().getUp());
    }

    public void moveHeroDown() {
        verifyPosition();
        soundStep();
        moveHero(getModel().getHero().getPosition().getDown());
        moveShoot(getModel().getShoot().getPosition().getDown());
        verifyPosition();
    }
    public void fireShootUp(){
        soundShoot(getModel().getHero().getWeaponUsed());
        verifyPosition();
        for(int i = 0; i < getModel().getShoot().getRange(); i++){
            if(getHit()){
                break;
            }
            moveShoot(getModel().getShoot().getPosition().getUp());
        }
        setHit(false);
    }
    public void fireShootRight() {
        soundShoot(getModel().getHero().getWeaponUsed());
        verifyPosition();
        for(int i = 0; i < getModel().getShoot().getRange(); i++){
            if(getHit()){
                break;
            }
            moveShoot(getModel().getShoot().getPosition().getRight());
        }
        setHit(false);
    }
    public void fireShootDown() {
        soundShoot(getModel().getHero().getWeaponUsed());
        verifyPosition();
        for(int i = 0; i < getModel().getShoot().getRange(); i++){
            if(getHit()){
                break;
            }
            moveShoot(getModel().getShoot().getPosition().getDown());
        }
        setHit(false);
    }
    public void fireShootLeft() {
        soundShoot(getModel().getHero().getWeaponUsed());
        verifyPosition();
        for(int i = 0; i < getModel().getShoot().getRange(); i++){
            if(getHit()){
                break;
            }
            moveShoot(getModel().getShoot().getPosition().getLeft());
        }
        setHit(false);
    }

    private void moveHero(Position position) {
        if (getModel().isEmpty(position)) {
            getModel().getHero().setPosition(position);
            if (getModel().isMonster(position)) getModel().getHero().decreaseEnergy();
            for(int i = 0; i < getModel().getCoin().size(); i++){
                if(getModel().getCoin().get(i).getPosition().equals(getModel().getHero().getPosition())) {
                    getModel().getHero().addMoney();
                    getModel().getCoin().remove(i);
                }
            }
        }
    }

    private void moveShoot(Position position) {
        if (getModel().isEmpty(position)){
            getModel().getShoot().setPosition(position);
            for(int i = 0; i < getModel().getMonsters().size(); i++){
                if(getModel().getMonsters().get(i).getPosition().equals(getModel().getShoot().getPosition()) && !getModel().getMonsters().get(i).getPosition().equals(getModel().getHero().getPosition())) {
                    getModel().getMonsters().get(i).decreaseHealth(getModel().getShoot().getDamage());
                    setHit(true);
                }
                if(getModel().getMonsters().get(i).verifyDeath()){
                    getModel().getCoin().add(new Coin(getModel().getMonsters().get(i).getPosition().getX(), getModel().getMonsters().get(i).getPosition().getY()));
                    getModel().getMonsters().remove(i);
                }
            }
        }
    }

    public void change(int option) {
        switch (option){
            case 1:
                getModel().getShoot().setRange(getModel().getHero().getKnife().getRange());
                getModel().getShoot().setDamage(getModel().getHero().getKnife().getDamage());
                getModel().getHero().setWeaponUsed("Knife");
                break;
            case 2:
                getModel().getShoot().setRange(getModel().getHero().getPistol().getRange());
                getModel().getShoot().setDamage(getModel().getHero().getPistol().getDamage());
                getModel().getHero().setWeaponUsed("Pistol");
                break;
            case 3:
                if(getModel().getHero().getAk47().getCanUse()) {
                    getModel().getShoot().setRange(getModel().getHero().getAk47().getRange());
                    getModel().getShoot().setDamage(getModel().getHero().getAk47().getDamage());
                    getModel().getHero().setWeaponUsed("Rifle");
                }
                break;
            case 4:
                if(getModel().getHero().getSniper().getCanUse()) {
                    getModel().getShoot().setRange(getModel().getHero().getSniper().getRange());
                    getModel().getShoot().setDamage(getModel().getHero().getSniper().getDamage());
                    getModel().getHero().setWeaponUsed("Sniper");
                }
                break;
        }
    }

    @Override
    public void step(Game game, GUI.ACTION action, long time){
        if (action == GUI.ACTION.UP){
            if(getModel().isEmpty(getModel().getWeapon().getPosition().getUp()))
                moveHeroUp();
        }
        if (action == GUI.ACTION.RIGHT) {
            if(getModel().isEmpty(getModel().getWeapon().getPosition().getRight()))
                moveHeroRight();
        }
        if (action == GUI.ACTION.DOWN) {
            if(getModel().isEmpty(getModel().getWeapon().getPosition().getDown()))
                moveHeroDown();
        }
        if (action == GUI.ACTION.LEFT) {
            if(getModel().isEmpty(getModel().getWeapon().getPosition().getLeft()))
                moveHeroLeft();
        }
        if (action == GUI.ACTION.SHOOTUP) fireShootUp();
        if (action == GUI.ACTION.SHOOTRIGHT) fireShootRight();
        if (action == GUI.ACTION.SHOOTDOWN) fireShootDown();
        if (action == GUI.ACTION.SHOOTLEFT) fireShootLeft();
        if (action == GUI.ACTION.KNIFE) change(1);
        if (action == GUI.ACTION.PISTOL) change(2);
        if (action == GUI.ACTION.AK47) change(3);
        if (action == GUI.ACTION.SNIPER) change(4);
        if(action == GUI.ACTION.BMENU){
            game.setState(game.getShopState());
        }
    }
}
