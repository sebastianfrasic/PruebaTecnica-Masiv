package masiv.controller;

import masiv.model.Roulette;
import masiv.services.RouletteServices;
import masiv.services.RouletteServicesException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.logging.Level;
import java.util.logging.Logger;

@RestController
@RequestMapping(value = "/app")
public class RouletteAPIController {

    @Autowired
    @Qualifier("rouletteServices")
    RouletteServices rouletteService;

    @PostMapping("/roulette")
    public ResponseEntity<?> createRoulette(@RequestBody Roulette roulette) {
        try {
            rouletteService.createRoulette(roulette);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

}
