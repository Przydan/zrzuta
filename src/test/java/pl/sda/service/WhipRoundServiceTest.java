package pl.sda.service;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.model.Donation;
import pl.sda.model.WhipRound;
import pl.sda.repository.DonationRepository;
import pl.sda.repository.WhipRoundRepository;

import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ExtendWith(SpringExtension.class)
class WhipRoundServiceTest {

    @Autowired
    private WhipRoundService sut;
    @Autowired
    private WhipRoundRepository whipRoundRepository;
    @Autowired
    private DonationRepository donationRepository;

    @Test
    public void shouldReturnAllWhipRounds() {

        //when
        Set<WhipRound> allWhipRounds = sut.findAllWhipRounds();
        //then
        assertThat(allWhipRounds).hasSize(2);
    }

    @Test
    @Transactional
    public void shouldAddWhipRound() {
        //given
        WhipRound newWhipRound = new WhipRound("Na kota", "rudego",
                LocalDate.parse("2020-03-01"), LocalDate.parse("2020-04-01"),
                new BigDecimal(10000), null);

        //when
        WhipRound addedwhipRound = sut.addWhipRound(newWhipRound);

        //then
        assertThat(addedwhipRound.getId()).isEqualTo(3);
        assertThat(whipRoundRepository.getOne(addedwhipRound.getId())).isNotNull();
    }

    @Test
    @Transactional
    public void shouldBeDonationAdded() {
        //given
        Donation newDonation = new Donation(
                new BigDecimal(500), LocalDate.parse("2020-02-20"),
                null, null);
        //when
        Donation addedDonation = sut.donate(newDonation);
        //then
        assertThat(addedDonation.getId()).isEqualTo(4);
        assertThat(donationRepository.getOne(addedDonation.getId())).isNotNull();
    }

    @Test
    public void shouldReturnDonationsSetFoundByWhiproundId() {
        // when
        Set<Donation> actual = sut.showAllDonations(2L);
        // then
        assertThat(actual)
                .extracting(Donation::getId)
                .containsExactlyInAnyOrder(2L,3L);
    }
}