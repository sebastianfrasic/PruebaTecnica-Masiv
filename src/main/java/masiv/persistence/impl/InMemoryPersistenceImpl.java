package masiv.persistence.impl;

import masiv.model.Bet;
import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import org.springframework.stereotype.Service;

import java.util.*;

@Service("inMemoryPersistence")
public class InMemoryPersistenceImpl implements RoulettePersistence {

    private final List<Roulette> roulettes = new ArrayList<>();

    public InMemoryPersistenceImpl() {
        roulettes.add(new Roulette(1));
        roulettes.add(new Roulette(2));
        roulettes.add(new Roulette(3));
    }

    @Override
    public int createRoulette(Roulette roulette) throws RoulettePersistenceException {
        int listSize = roulettes.size();
        int id = listSize + 1;
        roulette.setId(id);
        roulettes.add(roulette);
        return id;
    }

    @Override
    public void openRoulette(int id) throws RoulettePersistenceException {
        Roulette roulette = roulettes.get(id - 1);
        if (roulette.isOpen()) {
            throw new RoulettePersistenceException("This roulette is already opened");
        }
        roulette.open();
    }

    @Override
    public void makeABet(int userId, Bet bet, int id) throws RoulettePersistenceException {
        Roulette roulette = roulettes.get(id - 1);
        if (!roulette.isOpen()) {
            throw new RoulettePersistenceException("This roulette is closed. You can´t bet on it");
        }
        roulette.makeBet(userId, bet);
    }

    @Override
    public HashMap<Integer, List<Double>> endOfBets(int id) throws RoulettePersistenceException {
        Roulette roulette = roulettes.get(id - 1);
        roulette.close();
        int result = rouletteRandomResult();
        return roulette.getResult(result);
    }



    @Override
    public List<Roulette> getAllRoulettes() throws RoulettePersistenceException {
        return roulettes;
    }
}
