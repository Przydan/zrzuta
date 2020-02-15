package pl.sda.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import pl.sda.model.Donation;

import java.util.Set;

public interface DonationRepository extends JpaRepository<Donation, Long> {

    @Query("SELECT d FROM Donation d WHERE d.whipRound.id = :whipround_id")
    Set<Donation> fetchDonationsByWhiproundId(@Param("whipround_id") Long id);


}
