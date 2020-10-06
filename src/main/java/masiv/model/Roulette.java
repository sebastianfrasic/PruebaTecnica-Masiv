package masiv.model;

import java.util.HashMap;
import java.util.Objects;

public class Roulette {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 36;
    private int id;
    private boolean isOpen;
    private HashMap<Integer, Bet> bets;

    public Roulette() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public boolean isOpen() {
        return isOpen;
    }

    public void setOpen(boolean open) {
        isOpen = open;
    }

    public HashMap<Integer, Bet> getBets() {
        return bets;
    }

    public void setBets(HashMap<Integer, Bet> bets) {
        this.bets = bets;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roulette roulette = (Roulette) o;
        return id == roulette.id &&
                isOpen == roulette.isOpen &&
                Objects.equals(bets, roulette.bets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isOpen, bets);
    }

    @Override
    public String toString() {
        return "Roulette{" +
                "id=" + id +
                ", isOpen=" + isOpen +
                ", bets=" + bets +
                '}';
    }
}
