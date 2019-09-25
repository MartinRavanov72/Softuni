package hibernate_excr;

import javax.persistence.*;


@Entity
@DiscriminatorValue(value = "Bank Account")
public class BankAccount extends BillingDetail{

    @Basic
    private String bank_name;

    @Basic
    private String SWIFT_code;

    public BankAccount(int number, User user_id, String bank_name, String SWIFT_code) {
        super(number, user_id);
        this.bank_name = bank_name;
        this.SWIFT_code = SWIFT_code;
    }

    public BankAccount() {
    }
}