package com.aor.Sh00tingGame.model.game.arena;
import com.aor.Sh00tingGame.model.game.elements.*;

import java.util.List;

public abstract class ArenaBuilder {
    public Arena createArena() {
        Arena arena = new Arena(getWidth(), getHeight());

        arena.setShoot(createShoot());
        arena.setHero(createHero());
        arena.setMonsters(createMonsters());
        arena.setWalls(createWalls());
        arena.setCoins(createCoin());
        arena.setWeapon(createWeapon());

        return arena;
    }

    protected abstract int getWidth();

    protected abstract int getHeight();

    protected abstract List<Wall> createWalls();

    protected abstract List<Monster> createMonsters();

    protected abstract Hero createHero();

    protected abstract Weapon createWeapon();

    protected abstract Shoot createShoot();

    protected abstract List<Coin> createCoin();
}
