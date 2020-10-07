package masiv.persistence;

import masiv.model.Bet;
import masiv.model.Roulette;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface RoulettePersistence {

    int createRoulette(Roulette roulette) throws RoulettePersistenceException;

    void openRoulette(int id) throws RoulettePersistenceException;

    void makeABet(int userId, Bet bet, int id) throws RoulettePersistenceException;

    HashMap<Integer, List<Double>> endOfBets(int id) throws RoulettePersistenceException;

    List<Roulette> getAllRoulettes() throws RoulettePersistenceException;
}
