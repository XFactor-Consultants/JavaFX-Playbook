package org.xfactor;

public class Card {
    public int index;
    public int value;
    public int deltaX;
    public Card(int index, int value, int deltaX){
        this.index = index;
        this.value = value;
        this.deltaX = deltaX;
    }
    public String toString() {
        return this.index + " - " + this.value + " ("+this.deltaX+")";
    }
}
