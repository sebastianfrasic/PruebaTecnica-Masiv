package masiv.services;

import masiv.model.Bet;
import masiv.model.Roulette;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;

@Service
public interface RouletteServices {

    int createRoulette(Roulette roulette) throws RouletteServicesException;

    void openRoulette(int id) throws RouletteServicesException;

    void makeABet(int userID, Bet bet, int id) throws RouletteServicesException;

    HashMap<Integer, List<Double>> endOfBets(int id) throws RouletteServicesException;

    List<Roulette> getAllRoulettes() throws RouletteServicesException;

}
