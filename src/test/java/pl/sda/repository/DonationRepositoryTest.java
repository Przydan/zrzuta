package pl.sda.repository;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import pl.sda.model.Donation;

import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
@ExtendWith(SpringExtension.class)
public class DonationRepositoryTest {

    @Autowired
    private DonationRepository sut;

    @Test
    public void shouldReturnDonationsSetFoundByWhiproundId() {
        // when
        Set<Donation> actual = sut.fetchDonationsByWhiproundId(2L);
        // then
        assertThat(actual)
                .extracting(Donation::getId)
                .containsExactlyInAnyOrder(2L,3L);
    }
}