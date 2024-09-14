package com.aor.Sh00tingGame.controller;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.game.*;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.gui.LanternaGUI;
import com.aor.Sh00tingGame.model.game.Pistol;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import com.aor.Sh00tingGame.model.game.elements.Shoot;
import com.aor.Sh00tingGame.states.EndMenuState;
import com.aor.Sh00tingGame.states.MenuState;
import com.aor.Sh00tingGame.states.NextMenuState;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class ArenaControllerTest {
    private Arena arena;
    private ArenaController controller;
    private Game game;
    private GUI gui;
    private Hero hero;

    @BeforeEach
    void setUp() {
        this.arena = mock(Arena.class);
        this.hero = mock(Hero.class);
        when(arena.getHero()).thenReturn(hero);
        when(arena.getShoot()).thenReturn(mock(Shoot.class));
        when(hero.getPistol()).thenReturn(mock(Pistol.class));
        this.controller = new ArenaController(arena);
        this.game = mock(Game.class);
        this.gui = mock(LanternaGUI.class);
    }

    @Test
    void testStep_quit() throws IOException {
        MenuState menuState = mock(MenuState.class);
        when(game.getMenuState()).thenReturn(menuState);

        controller.step(game, GUI.ACTION.QUIT, 0);

        verify(game).setState(menuState);
    }

    @Test
    void testStep_death() throws IOException {
        EndMenuState endMenuState = mock(EndMenuState.class);
        when(hero.getEnergy()).thenReturn(0);
        when(game.getDeath()).thenReturn(1);
        when(game.getState()).thenReturn(endMenuState);
        controller.step(game, GUI.ACTION.NONE, 0);

        Assertions.assertEquals(1, game.getDeath());
        Assertions.assertEquals(endMenuState, game.getState());

    }

    @Test
    void testStep_victory_nextLevel() throws IOException {
        NextMenuState nextMenuState = mock(NextMenuState.class);
        when(game.getLevel()).thenReturn(1);
        when(game.getLevel()).thenReturn(2);
        when(game.getState()).thenReturn(nextMenuState);
        controller.step(game, GUI.ACTION.NONE, 0);

       Assertions.assertEquals(2,game.getLevel());
        Assertions.assertEquals(nextMenuState,game.getState());
    }
}
