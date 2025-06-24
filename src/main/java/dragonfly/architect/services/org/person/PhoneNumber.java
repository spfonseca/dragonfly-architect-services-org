package dragonfly.architect.services.org.person;

import java.util.UUID;

import com.fasterxml.jackson.annotation.JsonIgnore;

import jakarta.persistence.*;

@Entity
@Table(name = "phone_number")
public class PhoneNumber {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    @JsonIgnore
    private UUID id;

    @Column(name = "type", length = 32, nullable = false)
    private String type;

    @Column(name = "country_code", length = 8, nullable = false)
    private String countryCode;

    @Column(name = "digit_sequence", length = 32, nullable = false)
    private String digitSequence;
    
    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getDigitSequence() {
        return digitSequence;
    }

    public void setDigitSequence(String digitSequence) {
        this.digitSequence = digitSequence;
    }
}
