package masiv.controller;

import masiv.model.Bet;
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

    @PostMapping("/roulettes")
    public ResponseEntity<?> createRoulette(@RequestBody Roulette roulette) {
        try {
            int id = rouletteService.createRoulette(roulette);
            return new ResponseEntity<>(id, HttpStatus.CREATED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/roulettes/{id}")
    public ResponseEntity<?> openRoulette(@PathVariable int id) {
        try {
            rouletteService.openRoulette(id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RouletteServicesException ex) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/roulettes/{id}/bets")
    public ResponseEntity<?> makeABet(@RequestHeader("x-userID") int userID, @RequestBody Bet bet, @PathVariable int id) {
        try {
            rouletteService.makeABet(userID, bet, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            if (e.getMessage().equals("You can´t bet to that value/field") || e.getMessage().equals("Badly built bet")) {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.BAD_REQUEST);
            } else {
                return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
            }

        }
    }

    @PutMapping("/roulettes/bets/{id}")
    public ResponseEntity<?> endOfBets(@PathVariable int id) {
        try {
            return new ResponseEntity<>(rouletteService.endOfBets(id), HttpStatus.ACCEPTED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }

    @GetMapping("/roulettes")
    public ResponseEntity<?> getAllRoulettes() {
        try {
            return new ResponseEntity<>(rouletteService.getAllRoulettes(), HttpStatus.ACCEPTED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
    }


}
