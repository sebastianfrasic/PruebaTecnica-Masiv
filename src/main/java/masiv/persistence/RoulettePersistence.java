package masiv.persistence;

import masiv.model.Roulette;
import org.springframework.stereotype.Service;

@Service
public interface RoulettePersistence {

    void createRoulette(Roulette roulette) throws RoulettePersistenceException;
}
