package com.aor.Sh00tingGame.model.game.arena;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.elements.*;

import java.util.List;

public class Arena {
    private final int width;
    private final int height;

    private Hero hero;
    private Shoot shoot;

    private List<Monster> monsters;
    private List<Wall> walls;

    private List<Coin> coins;

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }

    private Weapon weapon;


    public Arena(int width, int height) {
        this.width = width;
        this.height = height;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Hero getHero() {
        return hero;
    }

    public Shoot getShoot() {
        return shoot;
    }

    public void setHero(Hero hero) {
        this.hero = hero;
    }

    public void setShoot(Shoot shoot) {
        this.shoot = shoot;
    }

    public List<Monster> getMonsters() {
        return monsters;
    }

    public void setMonsters(List<Monster> monsters) {
        this.monsters = monsters;
    }

    public List<Coin> getCoin(){ return coins; }

    public void setCoins(List<Coin> coins){ this.coins = coins; }

    public List<Wall> getWalls() {
        return walls;
    }

    public void setWalls(List<Wall> walls) {
        this.walls = walls;
    }

    public boolean isEmpty(Position position) {
        for (Wall wall : walls)
            if (wall.getPosition().equals(position))
                return false;
        return true;
    }

    public boolean isMonster(Position position) {
        for (Monster monster : monsters)
            if (monster.getPosition().equals(position))
                return true;
        return false;
    }
}
