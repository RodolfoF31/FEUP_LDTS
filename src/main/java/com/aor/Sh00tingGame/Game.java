package com.aor.Sh00tingGame;

import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.game.arena.LoaderArenaBuilder;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import com.aor.Sh00tingGame.model.game.elements.Shoot;
import com.aor.Sh00tingGame.model.menu.Menu;
import com.aor.Sh00tingGame.states.GameState;
import com.aor.Sh00tingGame.states.MenuState;
import com.aor.Sh00tingGame.states.State;
import com.aor.Sh00tingGame.model.game.MusicPlayer;
import com.aor.Sh00tingGame.model.menu.Shop;
import com.aor.Sh00tingGame.states.ShopState;

import java.awt.*;
import java.io.IOException;
import java.net.URISyntaxException;

public class Game {
    private final LanternaGUI gui;
    private State state;
    private MenuState menuState;
    private GameState gameState;

    private ShopState shopState;
    private int level;
    private int death;

    private Hero hero;
    private Shoot shoot;
    private MusicPlayer musicPlayer = new MusicPlayer("doom");

    public Game() throws FontFormatException, IOException, URISyntaxException {
        this.gui = new LanternaGUI(102, 26);
        this.menuState = new MenuState(new Menu());
        this.gameState = new GameState(new LoaderArenaBuilder(1).createArena());
        this.shopState = new ShopState(new Shop(getGameState().getModel().getHero()));
        this.hero = getGameState().getModel().getHero();
        this.shoot = getGameState().getModel().getShoot();
        this.level = 1;
        this.death = 0;
        this.state = getMenuState();

    }

    public static void main(String[] args) throws IOException, FontFormatException, URISyntaxException {
        new Game().start();
    }

    public void setState(State state) {
        this.state = state;
    }

    public State getState() {
        return state;
    }


    private void start() throws IOException {
        musicPlayer.startMusic();
        int FPS = 30;
        int frameTime = 1000 / FPS ;

        while (this.state != null) {
            long startTime = System.currentTimeMillis();
            state.step(this, gui, startTime);

            long elapsedTime = System.currentTimeMillis() - startTime;
            long sleepTime = frameTime - elapsedTime;

            try {
                if (sleepTime > 0) Thread.sleep(sleepTime);
            } catch (InterruptedException e) {
            }
        }
        musicPlayer.stopMusic();
        gui.close();
    }

    public MenuState getMenuState() {
        return menuState;
    }

    public void setMenuState(MenuState menuState) {
        this.menuState = menuState;
    }

    public GameState getGameState() {
        return gameState;
    }

    public void setGameState(GameState gameState) {
        this.gameState = gameState;
    }


    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public ShopState getShopState() {
        return shopState;
    }

    public void setShopState(ShopState shopState) {
        this.shopState = shopState;
    }

    public Hero getHero() {
        return hero;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public Shoot getShoot() {
        return shoot;
    }

    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }
}
