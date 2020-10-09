package masiv.model;

import org.springframework.data.redis.core.RedisHash;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

@RedisHash("Roulette")
public class Roulette {

    private int id;
    private boolean isOpen;
    private ConcurrentHashMap<Integer, List<Bet>> bets;
    private int result;

    public Roulette() {
        bets = new ConcurrentHashMap<Integer, List<Bet>>();
    }

    public Roulette(int id) {
        bets = new ConcurrentHashMap<Integer, List<Bet>>();
        this.id = id;
    }

    public void open() {
        isOpen = true;
    }

    public void close() {
        isOpen = false;
    }

    public void makeBet(int userId, Bet bet) {
        if (bets.containsKey(userId)) {
            List<Bet> bets1 = bets.get(userId);
            bets1.add(bet);
        } else {
            List<Bet> bets2 = new ArrayList<>();
            bets2.add(bet);
            bets.put(userId, bets2);
        }
    }

    public HashMap<Integer, List<Double>> getResult(int result) {
        HashMap<Integer, List<Double>> results = new HashMap<>();
        ConcurrentHashMap<Integer, List<Bet>> bets = getBets();
        setResult(result);
        for (Map.Entry<Integer, List<Bet>> entry : bets.entrySet()) {
            List<Double> userResults = new ArrayList<>();
            List<Bet> userBets = entry.getValue();
            for (Bet b : userBets) {
                userResults.add(b.getResult(result));
            }
            results.put(entry.getKey(), userResults);
        }
        return results;
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

    public ConcurrentHashMap<Integer, List<Bet>> getBets() {
        return bets;
    }

    public void setBets(ConcurrentHashMap<Integer, List<Bet>> bets) {
        this.bets = bets;
    }

    public int getResult() {
        return result;
    }

    public void setResult(int result) {
        this.result = result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Roulette roulette = (Roulette) o;
        return id == roulette.id &&
                isOpen == roulette.isOpen &&
                result == roulette.result &&
                Objects.equals(bets, roulette.bets);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, isOpen, bets, result);
    }

    @Override
    public String toString() {
        return "Roulette{" +
                "id=" + id +
                ", isOpen=" + isOpen +
                ", bets=" + bets +
                ", result=" + result +
                '}';
    }
}
