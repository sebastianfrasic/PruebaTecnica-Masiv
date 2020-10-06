package masiv.services;

import masiv.model.Bet;
import masiv.model.Roulette;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RouletteServices {

    void createRoulette(Roulette roulette) throws RouletteServicesException;

    void openRoulette(Roulette roulette, int id) throws RouletteServicesException;

    void makeABet(Bet bet, int id) throws RouletteServicesException;

    List<Bet> endOfBets(int id) throws RouletteServicesException;

    List<Roulette> getAllRoulettes() throws RouletteServicesException;

}
