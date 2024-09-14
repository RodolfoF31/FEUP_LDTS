package com.aor.Sh00tingGame.controller;

import com.aor.Sh00tingGame.controller.game.HeroController;
import com.aor.Sh00tingGame.model.Position;
import com.aor.Sh00tingGame.model.game.arena.Arena;
import com.aor.Sh00tingGame.model.game.elements.Hero;
import com.aor.Sh00tingGame.model.game.elements.Monster;
import com.aor.Sh00tingGame.model.game.elements.Shoot;
import com.aor.Sh00tingGame.model.game.elements.Wall;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Arrays;


class HeroControllerTest {
    private HeroController controller;
    private Hero hero;
    private Arena arena;
    private Shoot shoot;

    @BeforeEach
    void setUp() {
        arena = new Arena(11, 11);

        hero = new Hero(5, 5);
        arena.setHero(hero);
        shoot = new Shoot(5,5);
        arena.setShoot(shoot);

        arena.setWalls(Arrays.asList());
        arena.setMonsters(Arrays.asList());
        arena.setCoins(Arrays.asList());

        controller = new HeroController(arena);
    }

    @Test
    void moveHeroRightEmpty() {
        controller.moveHeroRight();
        Assertions.assertEquals(new Position(6, 5), hero.getPosition());
    }
    @Test
    void MoveHeroUpEmpty(){
        controller.moveHeroUp();
        Assertions.assertEquals(new Position(5, 4), hero.getPosition());
    }
    @Test
    void MoveHeroDownEmpty(){
        controller.moveHeroDown();
        Assertions.assertEquals(new Position(5, 6), hero.getPosition());
    }

    @Test
    void MoveHeroLeftEmpty(){
        controller.moveHeroLeft();
        Assertions.assertEquals(new Position(4, 5), hero.getPosition());
    }


    @Test
    void moveHeroRightNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(6, 5)));
        controller.moveHeroRight();
        Assertions.assertEquals(new Position(5, 5), hero.getPosition());
    }


    @Test
    void moveHeroUpNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(5, 4)));
        controller.moveHeroUp();
        Assertions.assertEquals(new Position(5, 5), hero.getPosition());
    }


    @Test
    void moveHeroDownNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(5, 6)));
        controller.moveHeroDown();
        Assertions.assertEquals(new Position(5, 5), hero.getPosition());
    }


    @Test
    void moveHeroLeftNotEmpty() {
        arena.setWalls(Arrays.asList(new Wall(4, 5)));
        controller.moveHeroLeft();
        Assertions.assertEquals(new Position(5, 5), hero.getPosition());
    }

    @Test
    void fireShootUp(){
        controller.fireShootUp();
        Assertions.assertEquals(new Position(5, 0), shoot.getPosition());
    }

    @Test
    void fireShootDown(){
        controller.fireShootDown();
        Assertions.assertEquals(new Position(5, 10), shoot.getPosition());
    }

    @Test
    void fireShootLeft(){
        controller.fireShootLeft();
        Assertions.assertEquals(new Position(0, 5), shoot.getPosition());
    }
    @Test
    void fireShootRight(){
        controller.fireShootRight();
        Assertions.assertEquals(new Position(10, 5), shoot.getPosition());
    }

    @Test
    void fireShootUpWall(){
        arena.setWalls(Arrays.asList(new Wall(5,4)));
        controller.fireShootUp();
        Assertions.assertEquals(new Position(5, 5), shoot.getPosition());
    }
    @Test
    void fireShootDownWall(){
        arena.setWalls(Arrays.asList(new Wall(5,6)));
        controller.fireShootDown();
        Assertions.assertEquals(new Position(5, 5), shoot.getPosition());
    }
    @Test
    void fireShootLeftWall(){
        arena.setWalls(Arrays.asList(new Wall(4,5)));
        controller.fireShootLeft();
        Assertions.assertEquals(new Position(5, 5), shoot.getPosition());
    }
    @Test
    void fireShootRightWall(){
        arena.setWalls(Arrays.asList(new Wall(6,5)));
        controller.fireShootRight();
        Assertions.assertEquals(new Position(5, 5), shoot.getPosition());
    }

    @Test
    void fireShootUpMonster(){
        arena.setMonsters(Arrays.asList(new Monster(5,4)));
        int monsterHealth = controller.getModel().getMonsters().get(0).getHealth();
        controller.fireShootUp();
        Assertions.assertEquals(new Position(5,4),shoot.getPosition());
        Assertions.assertEquals(monsterHealth - 3, controller.getModel().getMonsters().get(0).getHealth());
    }
    @Test
    void fireShootDownMonster(){
        arena.setMonsters(Arrays.asList(new Monster(5,6)));
        int monsterHealth = controller.getModel().getMonsters().get(0).getHealth();
        controller.fireShootDown();
        Assertions.assertEquals(new Position(5,6),shoot.getPosition());
        Assertions.assertEquals(monsterHealth - 3, controller.getModel().getMonsters().get(0).getHealth());
    }
    @Test
    void fireShootLeftMonster(){
        arena.setMonsters(Arrays.asList(new Monster(4,5)));
        int monsterHealth = controller.getModel().getMonsters().get(0).getHealth();
        controller.fireShootLeft();
        Assertions.assertEquals(new Position(4,5),shoot.getPosition());
        Assertions.assertEquals(monsterHealth - 3, controller.getModel().getMonsters().get(0).getHealth());
    }
    @Test
    void fireShootRightMonster(){
        arena.setMonsters(Arrays.asList(new Monster(6,5)));
        int monsterHealth = controller.getModel().getMonsters().get(0).getHealth();
        controller.fireShootRight();
        Assertions.assertEquals(new Position(6,5),shoot.getPosition());
        Assertions.assertEquals(monsterHealth - 3, controller.getModel().getMonsters().get(0).getHealth());
    }
    @Test
    void changeKnife(){
        controller.change(1);
        Assertions.assertEquals(3, controller.getModel().getShoot().getDamage());
        Assertions.assertEquals(1, controller.getModel().getShoot().getRange());
        Assertions.assertEquals("Knife", controller.getModel().getHero().getWeaponUsed());
    }

    @Test
    void changePistol(){
        controller.change(2);
        Assertions.assertEquals(3, controller.getModel().getShoot().getDamage());
        Assertions.assertEquals(5, controller.getModel().getShoot().getRange());
        Assertions.assertEquals("Pistol", controller.getModel().getHero().getWeaponUsed());
    }

    @Test
    void changeRifle(){
        controller.getModel().getHero().getAk47().setCanUse(true);
        controller.change(3);
        Assertions.assertEquals(7, controller.getModel().getShoot().getDamage());
        Assertions.assertEquals(5, controller.getModel().getShoot().getRange());
        Assertions.assertEquals("Rifle", controller.getModel().getHero().getWeaponUsed());
    }

    @Test
    void changeSniper(){
        controller.getModel().getHero().getSniper().setCanUse(true);
        controller.change(4);
        Assertions.assertEquals(10, controller.getModel().getShoot().getDamage());
        Assertions.assertEquals(10, controller.getModel().getShoot().getRange());
        Assertions.assertEquals("Sniper", controller.getModel().getHero().getWeaponUsed());
    }

    @Test
    void Step(){

    }


}