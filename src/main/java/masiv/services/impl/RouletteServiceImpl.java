package masiv.services.impl;

import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import masiv.persistence.RoulettePersistenceException;
import masiv.services.RouletteServices;
import masiv.services.RouletteServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

@Service("rouletteServices")
public class RouletteServiceImpl implements RouletteServices {

    @Autowired
    @Qualifier("inMemoryPersistence")
    RoulettePersistence roulettePersistence;


    @Override
    public void createRoulette(Roulette roulette) throws RouletteServicesException{
        try {
            roulettePersistence.createRoulette(roulette);
        } catch (RoulettePersistenceException e) {
            throw new RouletteServicesException(e.getMessage(), e);
        }
    }
}
