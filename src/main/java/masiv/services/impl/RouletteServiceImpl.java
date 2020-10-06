package masiv.services.impl;

import masiv.model.Bet;
import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import masiv.services.RouletteServices;
import masiv.services.RouletteServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service("rouletteServices")
public class RouletteServiceImpl implements RouletteServices {

    @Autowired
    @Qualifier("inMemoryPersistence")
    RoulettePersistence roulettePersistence;


    @Override
    public void createRoulette(Roulette roulette) throws RouletteServicesException {
        try {
            roulettePersistence.createRoulette(roulette);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void openRoulette(Roulette roulette, int id) throws RouletteServicesException {
        try {
            roulettePersistence.openRoulette(roulette);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void makeABet(Bet bet, int id) throws RouletteServicesException {
        try {
            roulettePersistence.makeABet(bet, id);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Bet> endOfBets(int id) throws RouletteServicesException {
        try {
            return roulettePersistence.endOfBets(id);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public List<Roulette> getAllRoulettes() throws RouletteServicesException {
        try {
            return roulettePersistence.getAllRoulettes();
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }
}
