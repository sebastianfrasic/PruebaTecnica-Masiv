package masiv.persistence.impl;

import masiv.model.Bet;
import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import masiv.persistence.repo.RouletteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;


@Service("RedisPersistence")
public class RedisPersistenceImpl implements RoulettePersistence {


    @Autowired
    private RouletteRepository rouletteRepository;


    private Roulette getRouletteByID(int id) throws RoulettePersistenceException {
        Roulette roulette = null;
        if (rouletteRepository.existsById(id)) {
            roulette = rouletteRepository.findById(id).get();
        }
        if (roulette == null) {
            throw new RoulettePersistenceException("The roulette with this ID does not exists");
        }
        return roulette;
    }

    @Override
    public int createRoulette(Roulette roulette) throws RoulettePersistenceException {
        Roulette roulette1 = rouletteRepository.save(roulette);
        return roulette1.getId();
    }

    @Override
    public void openRoulette(int roulette) throws RoulettePersistenceException {
        Roulette roulette1 = getRouletteByID(roulette);
        if (roulette1.isOpen()) {
            throw new RoulettePersistenceException("This roulette is already opened");
        }
        roulette1.open();
        rouletteRepository.save(roulette1);
    }

    @Override
    public void makeABet(int userId, Bet bet, int id) throws RoulettePersistenceException {
        Roulette roulette = getRouletteByID(id);
        if (!roulette.isOpen()) {
            throw new RoulettePersistenceException("This roulette is closed. You can´t bet on it");
        }
        roulette.makeBet(userId, bet);
        rouletteRepository.save(roulette);
    }

    @Override
    public HashMap<Integer, List<Double>> endOfBets(int id) throws RoulettePersistenceException {
        Roulette roulette = getRouletteByID(id);
        roulette.close();
        rouletteRepository.save(roulette);
        int result = rouletteRandomResult();
        return roulette.getResult(result);
    }

    @Override
    public List<Roulette> getAllRoulettes() throws RoulettePersistenceException {
        System.out.println((List<Roulette>) rouletteRepository.findAll());
        return (List<Roulette>) rouletteRepository.findAll();
    }


}
