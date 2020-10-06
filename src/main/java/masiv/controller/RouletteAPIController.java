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
            rouletteService.createRoulette(roulette);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @PutMapping("/roulettes/{id}")
    public ResponseEntity<?> openRoulette(@RequestBody Roulette roulette, @PathVariable int id) {
        try {
            rouletteService.openRoulette(roulette, id);
            return new ResponseEntity<>(HttpStatus.ACCEPTED);
        } catch (RouletteServicesException ex) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, null, ex);
            return new ResponseEntity<>(ex.getMessage(), HttpStatus.BAD_REQUEST);
        }
    }

    @PostMapping("/roulettes/bets")
    public ResponseEntity<?> makeABet(@RequestBody Bet bet, @PathVariable int id) {
        try {
            rouletteService.makeABet(bet, id);
            return new ResponseEntity<>(HttpStatus.CREATED);
        } catch (RouletteServicesException e) {
            Logger.getLogger(RouletteAPIController.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            return new ResponseEntity<>(e.getMessage(), HttpStatus.CONFLICT);
        }
    }

    @GetMapping("/roulettes/bets/{id]")
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
