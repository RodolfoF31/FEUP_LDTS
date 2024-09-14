package com.aor.Sh00tingGame.controller;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.game.HeroController;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.arena.RandomArenaBuilder;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import net.jqwik.api.*;
import net.jqwik.api.constraints.IntRange;
import org.mockito.Mockito;

import java.util.List;

import static org.mockito.Mockito.mock;

public class ArenaIsClosedTest {
    @Property
    void allArenasAreClosed(@ForAll @IntRange(min = 3, max = 50) int width, @ForAll @IntRange(min = 3, max = 50) int height, @ForAll List<GUI.@From("moveActions") ACTION> actions) {
        RandomArenaBuilder rab = new RandomArenaBuilder(width, height, 0);
        Arena arena = rab.createArena();
        HeroController controller = mock(HeroController.class);
        Mockito.doNothing().when(controller).soundStep();
        Mockito.when(controller.getModel()).thenReturn(arena);
        for (GUI.ACTION action : actions) {
            controller.step(null, action, 100);
            assert (controller.getModel().getHero().getPosition().getX() > 0);
            assert (controller.getModel().getHero().getPosition().getY() > 0);
            assert (controller.getModel().getHero().getPosition().getX() < width - 1);
            assert (controller.getModel().getHero().getPosition().getY() < height - 1);
        }
    }

    @Provide
    Arbitrary<GUI.ACTION> moveActions() {
        return Arbitraries.of(GUI.ACTION.UP, GUI.ACTION.RIGHT, GUI.ACTION.DOWN, GUI.ACTION.LEFT);
    }
}
