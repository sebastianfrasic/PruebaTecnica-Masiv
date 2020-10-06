package masiv.persistence.impl;

import masiv.model.Bet;
import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("inMemoryPersistence")
public class InMemoryPersistenceImpl implements RoulettePersistence {

    @Override
    public void createRoulette(Roulette roulette) throws RoulettePersistenceException {

    }

    @Override
    public void openRoulette(Roulette roulette) throws RoulettePersistenceException {

    }

    @Override
    public void makeABet(Bet bet, int id) throws RoulettePersistenceException {

    }

    @Override
    public List<Bet> endOfBets(int id) throws RoulettePersistenceException {
        return null;
    }

    @Override
    public List<Roulette> getAllRoulettes() throws RoulettePersistenceException {
        return null;
    }
}
