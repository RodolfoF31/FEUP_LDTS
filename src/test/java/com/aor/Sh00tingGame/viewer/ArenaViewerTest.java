package com.aor.Sh00tingGame.viewer;

import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.*;
import com.aor.Sh00tingGame.viewer.game.GameViewer;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.io.IOException;
import java.util.Arrays;

class ArenaViewerTest {
    private GUI gui;
    private GameViewer viewer;
    private Arena arena;

    @BeforeEach
    void setUp() {
        arena = new Arena(10, 10);
        gui = Mockito.mock(GUI.class);
        viewer = new GameViewer(arena);

        arena.setWalls(Arrays.asList(new Wall(1, 2), new Wall(2, 3), new Wall(3, 4)));
        arena.setMonsters(Arrays.asList(new Monster(4, 5), new Monster(5, 6)));
        arena.setHero(new Hero(5, 8));
        arena.setShoot(new Shoot(5,8));
        arena.setWeapon(new Weapon(6,8));
        arena.setCoins(Arrays.asList(new Coin(4,7), new Coin(5,7)));
    }


    @Test
    void drawWalls() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(1, 2));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(2, 3));
        Mockito.verify(gui, Mockito.times(1)).drawWall(new Position(3, 4));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void drawMonsters() throws IOException {
        viewer.draw(gui);
        int monsterHealth = arena.getMonsters().get(0).getHealth();
        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(4, 5), monsterHealth);
        monsterHealth = arena.getMonsters().get(1).getHealth();
        Mockito.verify(gui, Mockito.times(1)).drawMonster(new Position(5, 6), monsterHealth);
        Mockito.verify(gui, Mockito.times(2)).drawMonster(Mockito.any(Position.class), Mockito.any(int.class));
    }

    @Test
    void drawHero() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawHero(new Position(5, 8));
        Mockito.verify(gui, Mockito.times(1)).drawHero(Mockito.any(Position.class));
    }

    @Test
    void drawWeapon() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawWeapon(new Position(6,8),0);
        Mockito.verify(gui, Mockito.times(1)).drawWeapon(Mockito.any(Position.class), Mockito.any(int.class));
    }

    @Test
    void drawShoot() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawShoot(new Position(5,8));
        Mockito.verify(gui, Mockito.times(1)).drawShoot(Mockito.any(Position.class));
    }

    @Test
    void drawCoins() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(4, 7));
        Mockito.verify(gui, Mockito.times(1)).drawCoin(new Position(5, 7));
        Mockito.verify(gui, Mockito.times(3)).drawWall(Mockito.any(Position.class));
    }

    @Test
    void refreshAndClear() throws IOException {
        viewer.draw(gui);

        Mockito.verify(gui, Mockito.times(1)).clear();
        Mockito.verify(gui, Mockito.times(1)).refresh();
    }
}