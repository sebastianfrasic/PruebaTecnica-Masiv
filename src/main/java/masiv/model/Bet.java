package masiv.model;

import org.springframework.data.redis.core.RedisHash;

import java.util.Arrays;
import java.util.Objects;

@RedisHash("Bet")
public class Bet {

    public static final int MIN_VALUE = 0;
    public static final int MAX_VALUE = 36;
    public static final int MAX_AMOUNT = 10000;
    public static final String[] COLORS = {"black", "red"};
    private int bettingAmount;
    private String field;

    public Bet() {
    }

    public boolean isValid() throws RouletteException {
        boolean isValid = false;
        if (field != null) {
            if (bettingAmount > 0 && bettingAmount <= MAX_AMOUNT) {
                if (Arrays.stream(COLORS).anyMatch(field::equals)) {
                    isValid = true;
                }
                if (!isValid) {
                    int number;
                    try {
                        number = Integer.parseInt(field);
                    } catch (NumberFormatException exception) {
                        throw new RouletteException("You can´t bet to that value/field");
                    }
                    if (number >= MIN_VALUE && number <= MAX_VALUE) {
                        isValid = true;
                    }
                }
            }
        }
        return isValid;
    }

    public double getResult(int result) {
        double money;
        if (Arrays.stream(COLORS).anyMatch(getField()::equals)) {
            if ((result % 2 == 0 && getField().equals("red")) || (result % 2 == 1 && getField().equals("black"))) {
                money = 1.8 * getBettingAmount();
            } else {
                money = -1.0 * getBettingAmount();
            }
        } else {
            int number = Integer.parseInt(getField());
            if (number == result) {
                money = 5.0 * getBettingAmount();
            } else {
                money = -1.0 * getBettingAmount();
            }
        }
        return money;
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
