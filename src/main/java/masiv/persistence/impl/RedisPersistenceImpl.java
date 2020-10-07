package masiv.persistence.impl;

import masiv.model.Bet;
import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("RedisPersistence")
public class RedisPersistenceImpl implements RoulettePersistence {

    private Roulette getRouletteByID(int id){
        return null;
    }

    @Override
    public int createRoulette(Roulette roulette) throws RoulettePersistenceException {
        return 0;
    }

    @Override
    public void openRoulette(int roulette) throws RoulettePersistenceException {

    }

    @Override
    public void makeABet(int userId, Bet bet, int id) throws RoulettePersistenceException {

    }

    @Override
    public HashMap<Integer, List<Double>> endOfBets(int id) throws RoulettePersistenceException {
        return null;
    }

    @Override
    public List<Roulette> getAllRoulettes() throws RoulettePersistenceException {
        return null;
    }

}
