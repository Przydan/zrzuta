package pl.sda.service;

import org.springframework.stereotype.Service;
import pl.sda.model.Donation;
import pl.sda.model.WhipRound;
import pl.sda.repository.DonationRepository;
import pl.sda.repository.UserRepository;
import pl.sda.repository.WhipRoundRepository;

import java.util.HashSet;
import java.util.Set;

@Service
public class WhipRoundService {

    private final DonationRepository donationRepository;
    private final WhipRoundRepository whipRoundRepository;


    public WhipRoundService(DonationRepository donationRepository,
                            WhipRoundRepository whipRoundRepository) {
        this.donationRepository = donationRepository;
        this.whipRoundRepository = whipRoundRepository;
    }

    public Set<WhipRound> findAllWhipRounds() {
        return new HashSet<>(whipRoundRepository.findAll());
    }

    public WhipRound addWhipRound(WhipRound whipRound) {
        return whipRoundRepository.save(whipRound);
    }

    public Donation donate(Donation donation){
        return donationRepository.save(donation);
    }

    public Set<Donation> showAllDonations(Long whipRoundId) {
        return donationRepository.fetchDonationsByWhiproundId(whipRoundId);
    }
}
