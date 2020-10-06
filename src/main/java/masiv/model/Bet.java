package masiv.model;

import java.util.Objects;

public class Bet {

    private int bettingAmount;
    private String field;

    public Bet() {
    }

    public int getBettingAmount() {
        return bettingAmount;
    }

    public void setBettingAmount(int bettingAmount) {
        this.bettingAmount = bettingAmount;
    }

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Bet bet = (Bet) o;
        return bettingAmount == bet.bettingAmount &&
                Objects.equals(field, bet.field);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bettingAmount, field);
    }

    @Override
    public String toString() {
        return "Bet{" +
                "bettingAmount=" + bettingAmount +
                ", field='" + field + '\'' +
                '}';
    }
}
