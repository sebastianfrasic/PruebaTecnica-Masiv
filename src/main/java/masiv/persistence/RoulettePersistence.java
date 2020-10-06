package masiv.persistence;

import masiv.model.Bet;
import masiv.model.Roulette;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RoulettePersistence {

    void createRoulette(Roulette roulette) throws RoulettePersistenceException;

    void openRoulette(Roulette roulette) throws RoulettePersistenceException;

    void makeABet(Bet bet, int id) throws RoulettePersistenceException;

    List<Bet> endOfBets(int id) throws RoulettePersistenceException;

    List<Roulette> getAllRoulettes() throws RoulettePersistenceException;
}
