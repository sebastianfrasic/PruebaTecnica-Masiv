package masiv.persistence.impl;

import masiv.model.Roulette;
import masiv.persistence.RoulettePersistence;
import org.springframework.stereotype.Service;

@Service("inMemoryPersistence")
public class InMemoryPersistenceImpl implements RoulettePersistence {

    @Override
    public void createRoulette(Roulette roulette) {

    }
}
