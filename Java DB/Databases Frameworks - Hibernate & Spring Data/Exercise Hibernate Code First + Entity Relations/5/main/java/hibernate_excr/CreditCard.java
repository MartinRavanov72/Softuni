package hibernate_excr;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@DiscriminatorValue(value = "Credit Card")
public class CreditCard extends BillingDetail{

    @Basic
    private String card_type;

    @Basic
    private int expiration_month;

    @Basic
    private int expiration_year;

    public CreditCard(int number, User user_id, String card_type, int expiration_month, int expiration_year) {
        super(number, user_id);
        this.card_type = card_type;
        this.expiration_month = expiration_month;
        this.expiration_year = expiration_year;
    }

    public CreditCard() {
    }
}
