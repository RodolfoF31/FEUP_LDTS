package com.aor.Sh00tingGame.controller;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.menu.NextMenuController;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.arena.LoaderArenaBuilder;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import com.aor.Sh00tingGame.model.game.elements.Shoot;
import com.aor.Sh00tingGame.model.menu.NextMenu;
import com.aor.Sh00tingGame.states.GameState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

public class NextMenuControllerTest {
    private Game game;
    private NextMenu nextMenu;
    private NextMenuController nextMenuController;
    private Arena arena;

    @BeforeEach
    void setUp() {
        this.game = mock(Game.class);
        this.nextMenu = mock(NextMenu.class);
        this.nextMenuController = new NextMenuController(nextMenu);
        this.arena = mock(Arena.class);

        when(nextMenu.getNumberEntries()).thenReturn(2);
        when(nextMenu.getEntry(0)).thenReturn("Continue");
        when(nextMenu.getEntry(1)).thenReturn("Quit");
        when(nextMenu.isSelectedStart()).thenReturn(true);
        when(nextMenu.isSelectedExit()).thenReturn(false);
    }

    @Test
    void testStep_shootUp() throws IOException {
        nextMenuController.step(game, GUI.ACTION.SHOOTUP, 0);

        verify(nextMenu).previousEntry();
    }

    @Test
    void testStep_shootDown() throws IOException {
        nextMenuController.step(game, GUI.ACTION.SHOOTDOWN, 0);

        verify(nextMenu).nextEntry();
    }

    @Test
    void testStep_select_exit() throws IOException {
        NextMenu nextMenu = mock(NextMenu.class);
        when(nextMenu.isSelectedExit()).thenReturn(true);
        GameState gameState = mock(GameState.class);

        NextMenuController controller = new NextMenuController(nextMenu);
        Game game = mock(Game.class);
        when(game.getGameState()).thenReturn(gameState);

        controller.step(game, GUI.ACTION.SELECT, 0);

        Assertions.assertEquals(gameState,game.getGameState());
        verify(game, times(1)).setState(game.getMenuState());
    }

    @Test
    void testStep_select_continue() throws IOException {
        NextMenu nextMenu = mock(NextMenu.class);
        when(nextMenu.isSelectedStart()).thenReturn(true);
        GameState gameState = mock(GameState.class);
        Hero hero = mock(Hero.class);
        Shoot shoot = mock(Shoot.class);

        NextMenuController controller = new NextMenuController(nextMenu);
        Game game = mock(Game.class);
        when(game.getGameState()).thenReturn(gameState);
        when(gameState.getModel()).thenReturn(arena);
        when(arena.getHero()).thenReturn(hero);
        when(game.getHero()).thenReturn(hero);
        when(game.getShoot()).thenReturn(shoot);
        when(arena.getShoot()).thenReturn(shoot);
        when(shoot.getDamage()).thenReturn(5);
        when(hero.getPosition()).thenReturn(new Position(5,5));
        when(game.getLevel()).thenReturn(2);

        controller.step(game, GUI.ACTION.SELECT, 0);

        Assertions.assertEquals(gameState,game.getGameState());
        verify(game, times(6)).setState(game.getGameState());
    }
}