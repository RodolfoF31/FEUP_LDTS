package com.aor.Sh00tingGame.controller;

import com.aor.Sh00tingGame.Game;
import com.aor.Sh00tingGame.controller.game.WeaponController;
import com.aor.Sh00tingGame.gui.GUI;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import com.aor.Sh00tingGame.model.game.elements.Weapon;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.mockito.Mockito.*;

public class WeaponControllerTest {
    private Arena arena;
    private WeaponController controller;
    private Hero hero;
    private Weapon weapon;
    private Position heroPos;
    private Position weaponPos;
    private Position rightPos;
    private Position leftPos;
    private Game game;

    @BeforeEach
    void setUp() {
        arena = mock(Arena.class);
        controller = new WeaponController(arena);
        game = mock(Game.class);

        hero = mock(Hero.class);
        when(arena.getHero()).thenReturn(hero);
        weapon = mock(Weapon.class);
        when(arena.getWeapon()).thenReturn(weapon);

        heroPos = mock(Position.class);
        when(hero.getPosition()).thenReturn(heroPos);
        weaponPos = mock(Position.class);
        when(weapon.getPosition()).thenReturn(weaponPos);
        rightPos = mock(Position.class);
        when(heroPos.getRight()).thenReturn(rightPos);
        leftPos = mock(Position.class);
        when(heroPos.getLeft()).thenReturn(leftPos);
    }

    @Test
    void testRevWeaponRight_emptyPosition() {
        when(arena.isEmpty(rightPos)).thenReturn(true);

        controller.revWeaponRight();

        verify(weapon).setPosition(rightPos);
    }

    @Test
    void testRevWeaponRight_occupiedPosition() {
        when(arena.isEmpty(rightPos)).thenReturn(false);

        // Call the revWeaponRight() method on the controller
        controller.revWeaponRight();

        // Verify that the weapon's position was not set to the right position
        verify(weapon, never()).setPosition(rightPos);
    }

    @Test
    void testRevWeaponLeft_emptyPosition() {
        when(arena.isEmpty(leftPos)).thenReturn(true);

        controller.revWeaponLeft();

        verify(weapon).setPosition(leftPos);
    }

    @Test
    void testRevWeaponLeft_occupiedPosition() {
        when(arena.isEmpty(leftPos)).thenReturn(false);

        // Call the revWeaponRight() method on the controller
        controller.revWeaponLeft();

        // Verify that the weapon's position was not set to the right position
        verify(weapon, never()).setPosition(leftPos);
    }

    @Test
    void testStep_moveRight() throws IOException {
        when(arena.isEmpty(rightPos)).thenReturn(true);
        when(weapon.getSide()).thenReturn(0);
        controller.step(game, GUI.ACTION.RIGHT, 0);
        verify(weapon, times(1)).setPosition(rightPos);
    }
    @Test
    void testStep_moveLeft() throws IOException {
        when(arena.isEmpty(leftPos)).thenReturn(true);
        when(weapon.getSide()).thenReturn(1);
        controller.step(game, GUI.ACTION.LEFT, 0);
        verify(weapon, times(1)).setPosition(leftPos);
    }
    @Test
    void testStep_moveDown() throws IOException {
        when(arena.isEmpty(leftPos)).thenReturn(true);
        when(weapon.getSide()).thenReturn(1);
        controller.step(game, GUI.ACTION.DOWN, 0);
        verify(weapon, times(1)).setPosition(leftPos);
    }
    @Test
    void testStep_moveUp() throws IOException {
        when(arena.isEmpty(leftPos)).thenReturn(true);
        when(weapon.getSide()).thenReturn(1);
        controller.step(game, GUI.ACTION.UP, 0);
        verify(weapon, times(1)).setPosition(leftPos);
    }
    @Test
    void testShootRight() throws IOException{
        when(arena.isEmpty(rightPos)).thenReturn(true);
        controller.step(game, GUI.ACTION.SHOOTRIGHT, 0);
        verify(weapon,times(1)).setPosition(rightPos);
    }
    @Test
    void testShootLeft() throws IOException{
        when(arena.isEmpty(leftPos)).thenReturn(true);
        controller.step(game, GUI.ACTION.SHOOTLEFT, 0);
        verify(weapon,times(1)).setPosition(leftPos);
    }

}