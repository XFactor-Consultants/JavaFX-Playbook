package org.xfactor;

public class Card {
    public int index;
    public int value;
    public Card(int index, int value){
        this.index = index;
        this.value = value;
    }
    public String toString() {
        return this.index + " - " + this.value;
    }
}
