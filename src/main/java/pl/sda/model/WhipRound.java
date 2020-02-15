package pl.sda.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.Objects;

@Entity
public class WhipRound {

    @Id
    @GeneratedValue(generator = "whipRoundSeq")
    @SequenceGenerator(name = "whipRoundSeq",
            sequenceName = "whipround_seq", allocationSize = 1)
    private Long id;
    private String title;
    private String description;
    private LocalDate startDate;
    private LocalDate endDate;
    private BigDecimal amount;
    @ManyToOne(targetEntity = User.class)
    private User user;

    public WhipRound() {
    }

    public WhipRound(Long id, String title, String description, LocalDate startDate, LocalDate endDate, BigDecimal amount, User user) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.startDate = startDate;
        this.endDate = endDate;
        this.amount = amount;
        this.user = user;
    }

    public Long getId() {
        return id;
    }


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public BigDecimal getAmount() {
        return amount;
    }

    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    public User getUser() {
        return user;
    }

    @Override
    public String toString() {
        return "WhipRound{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                ", amount=" + amount +
                ", user=" + user +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        WhipRound whipRound = (WhipRound) o;
        return Objects.equals(id, whipRound.id) &&
                Objects.equals(title, whipRound.title) &&
                Objects.equals(description, whipRound.description) &&
                Objects.equals(startDate, whipRound.startDate) &&
                Objects.equals(endDate, whipRound.endDate) &&
                Objects.equals(amount, whipRound.amount) &&
                Objects.equals(user, whipRound.user);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, description, startDate, endDate, amount, user);
    }
}
