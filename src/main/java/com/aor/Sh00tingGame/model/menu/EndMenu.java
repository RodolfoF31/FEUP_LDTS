package com.aor.Sh00tingGame.model.menu;

import java.util.Arrays;
import java.util.List;

public class EndMenu {
    private int death = 0;
    private final List<String> entries;
    private int currentEntry = 0;

    public EndMenu() {
        this.entries = Arrays.asList("Menu", "Quit");
    }

    public void nextEntry() {
        currentEntry++;
        if (currentEntry > this.entries.size() - 1)
            currentEntry = 0;
    }

    public void previousEntry() {
        currentEntry--;
        if (currentEntry < 0)
            currentEntry = this.entries.size() - 1;
    }

    public String getEntry(int i) {
        return entries.get(i);
    }

    public boolean isSelected(int i) {
        return currentEntry == i;
    }

    public boolean isSelectedMenu() { return isSelected(0);  }

    public boolean isSelectedQuit() {
        return isSelected(1);
    }

    public int getNumberEntries() {
        return this.entries.size();
    }

    public int getDeath() {
        return death;
    }

    public void setDeath(int death) {
        this.death = death;
    }
}

