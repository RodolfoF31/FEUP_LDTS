package com.aor.Sh00tingGame.gui;

import com.aor.Sh00tingGame.model.Position;
import com.googlecode.lanterna.Symbols;
import com.googlecode.lanterna.TerminalSize;
import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.graphics.TextGraphics;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.input.KeyType;
import com.googlecode.lanterna.screen.Screen;
import com.googlecode.lanterna.screen.TerminalScreen;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import com.googlecode.lanterna.terminal.swing.AWTTerminalFontConfiguration;

import java.awt.*;
import java.io.File;
import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;

public class LanternaGUI implements GUI {

    private final Screen screen;
    public LanternaGUI(Screen screen) {
        this.screen = screen;
    }

    public LanternaGUI(int width, int height) throws IOException, FontFormatException, URISyntaxException {
        AWTTerminalFontConfiguration fontConfig = loadFont();
        Terminal terminal = createTerminal(width, height, fontConfig);
        this.screen = createScreen(terminal);
    }

    private Screen createScreen(Terminal terminal) throws IOException {
        final Screen screen;
        screen = new TerminalScreen(terminal);

        screen.setCursorPosition(null);
        screen.startScreen();
        screen.doResizeIfNecessary();
        return screen;
    }

    private Terminal createTerminal(int width, int height, AWTTerminalFontConfiguration fontConfig) throws IOException {
        TerminalSize terminalSize = new TerminalSize(width, height + 1);
        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory().setInitialTerminalSize(terminalSize);
        terminalFactory.setForceAWTOverSwing(true);
        terminalFactory.setTerminalEmulatorFontConfiguration(fontConfig);
        Terminal terminal = terminalFactory.createTerminal();
        return terminal;
    }

    private AWTTerminalFontConfiguration loadFont() throws URISyntaxException, FontFormatException, IOException {
        URL resource = getClass().getClassLoader().getResource("fonts/Hack-Bold-test.ttf");
        File fontFile = new File(resource.toURI());
        Font font = Font.createFont(Font.TRUETYPE_FONT, fontFile);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();
        ge.registerFont(font);


        Font loadedFont = font.deriveFont(Font.PLAIN, 25);

        AWTTerminalFontConfiguration fontConfig = AWTTerminalFontConfiguration.newInstance(loadedFont);
        return fontConfig;
    }

    public ACTION getNextAction() throws IOException {
        KeyStroke keyStroke = screen.pollInput();
        if (keyStroke == null) return ACTION.NONE;

        if (keyStroke.getKeyType() == KeyType.EOF) return ACTION.QUIT;
        if (keyStroke.getKeyType() == KeyType.Escape) return ACTION.QUIT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'w') return ACTION.UP;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'd') return ACTION.RIGHT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 's') return ACTION.DOWN;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'a') return ACTION.LEFT;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '1') return ACTION.KNIFE;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '2') return ACTION.PISTOL;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '3') return ACTION.AK47;
        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == '4') return ACTION.SNIPER;
        if (keyStroke.getKeyType() == KeyType.ArrowUp) return ACTION.SHOOTUP;
        if (keyStroke.getKeyType() == KeyType.ArrowRight) return ACTION.SHOOTRIGHT;
        if (keyStroke.getKeyType() == KeyType.ArrowDown) return ACTION.SHOOTDOWN;
        if (keyStroke.getKeyType() == KeyType.ArrowLeft) return ACTION.SHOOTLEFT;

        if (keyStroke.getKeyType() == KeyType.Character && keyStroke.getCharacter() == 'b') return ACTION.BMENU;
        if (keyStroke.getKeyType() == KeyType.Enter) return ACTION.SELECT;

        return ACTION.NONE;
    }

    @Override
    public void drawHero(Position position) {

        drawCharacter(position.getX(), position.getY(), '*', "#00FF00");
    }
    @Override
    public void drawWeapon(Position position, int side) {
        if(side==0) drawCharacter(position.getX(), position.getY(), ';', "#FFC0CB");
        else drawCharacter(position.getX(), position.getY(), '/', "#FFC0CB");
    }
    @Override
    public void drawShoot(Position position) {
        drawCharacter(position.getX(), position.getY(), 'O', "#FFFFFF");
    }

    @Override
    public void drawWall(Position position) {
        drawCharacter(position.getX(), position.getY(), Symbols.BLOCK_SOLID, "#3333FF");
    }

    @Override
    public void drawMonster(Position position, int health) {
        if(health>20) drawCharacter(position.getX(), position.getY(), '%', "#B91C02");
        else if(health<=20 && health>10) drawCharacter(position.getX(), position.getY(), '%', "#EB9C0D");
        else if(health<=10) drawCharacter(position.getX(), position.getY(), '%', "#FFD500");
    }
    @Override
    public void drawCoin(Position position){
        drawCharacter(position.getX(), position.getY(), '$', "#FFFF00");
    }

    @Override
    public void drawText(Position position, String text, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(position.getX(), position.getY(), text);
    }

    private void drawCharacter(int x, int y, char c, String color) {
        TextGraphics tg = screen.newTextGraphics();
        tg.setForegroundColor(TextColor.Factory.fromString(color));
        tg.putString(x, y + 1, "" + c);
    }

    @Override
    public void clear() {
        screen.clear();
    }

    @Override
    public void refresh() throws IOException {
        screen.refresh();
    }

    @Override
    public void close() throws IOException {
        screen.close();
    }

}
