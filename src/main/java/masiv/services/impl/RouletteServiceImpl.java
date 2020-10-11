package masiv.services.impl;

import masiv.model.Bet;
import masiv.model.Roulette;
import masiv.model.RouletteException;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import masiv.services.RouletteServices;
import masiv.services.RouletteServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service("rouletteServices")
public class RouletteServiceImpl implements RouletteServices {

    @Autowired
    @Qualifier("RedisPersistence")
    RoulettePersistence roulettePersistence;


    @Override
    public int createRoulette(Roulette roulette) throws RouletteServicesException {
        try {
            return roulettePersistence.createRoulette(roulette);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void openRoulette(int id) throws RouletteServicesException {
        try {
            roulettePersistence.openRoulette(id);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public void makeABet(int userId, Bet bet, int id) throws RouletteServicesException {
        boolean isValid;
        try {
            isValid = bet.isValid();
        } catch (RouletteException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
        if (!isValid) {
            throw new RouletteServicesException("Badly built bet");
        }
        try {
            roulettePersistence.makeABet(userId, bet, id);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }

    @Override
    public HashMap<Integer, List<Double>> endOfBets(int id) throws RouletteServicesException {
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
