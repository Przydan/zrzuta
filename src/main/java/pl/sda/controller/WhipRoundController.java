package pl.sda.controller;

import org.springframework.web.bind.annotation.*;
import pl.sda.model.Donation;
import pl.sda.model.WhipRound;
import pl.sda.repository.DonationRepository;
import pl.sda.service.WhipRoundService;

import java.util.Set;

@RestController
public class WhipRoundController {

    private final WhipRoundService whipRoundService;

    public WhipRoundController(WhipRoundService whipRoundService) {
        this.whipRoundService = whipRoundService;
    }

    @GetMapping("/whiprounds")
    public Set<WhipRound> getAllWhipRounds() {
        return whipRoundService.findAllWhipRounds();
    }

    // Should return status 201
    @PostMapping("/whipround/add")
    public WhipRound addWhipRound(@RequestBody WhipRound whipRound) {
        return whipRoundService.addWhipRound(whipRound);
    }

    @PostMapping("/donation/add")
    public Donation donate(@RequestBody Donation donation) {
        return whipRoundService.donate(donation);
    }

    @GetMapping("/whiprounds/{id}/donations")
    public Set<Donation> getDonationsByWhipRoundId(@PathVariable Long id) {
        return whipRoundService.showAllDonations(id);
    }
}
