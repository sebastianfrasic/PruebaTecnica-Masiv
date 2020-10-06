package masiv.services;

import masiv.model.Roulette;
import org.springframework.stereotype.Service;

@Service
public interface RouletteServices {

    void createRoulette(Roulette roulette) throws RouletteServicesException;
}
