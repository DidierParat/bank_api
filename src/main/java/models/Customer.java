package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import java.math.BigDecimal;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Customer {
    protected static final String CUSTOMER_ID = "customerId";
    protected static final String CUSTOMER_TYPE = "customerType";
    protected static final String FIRST_NAME = "firstName";
    protected static final String LAST_NAME = "lastName";
    protected static final String COMPANY_NAME = "companyName";
    protected static final String ADDRESS = "address";
    protected static final String EMAIL = "email";
    protected static final String PHONE = "phone";
    protected static final String COUNTRY_OF_BIRTH = "countryOfBirth";
    protected static final String COUNTRY_CITIZENSHIPS = "countryCitizenships";
    protected static final String COUNTRY_TAX = "countryTax";
    protected static final String CUSTOMER_ENGAGEMENT = "customerEngagement";

    @JsonProperty(CUSTOMER_ID)
    @Getter
    private final String customerId;

    @JsonProperty(CUSTOMER_TYPE)
    @Getter
    private final String customerType;

    @JsonProperty(FIRST_NAME)
    @Getter
    private final String firstName;

    @JsonProperty(LAST_NAME)
    @Getter
    private final String lastName;

    @JsonProperty(COMPANY_NAME)
    @Getter
    private final String companyName;

    @JsonProperty(ADDRESS)
    @Getter
    private final Address address;

    @JsonProperty(EMAIL)
    @Getter
    private final String email;

    @JsonProperty(PHONE)
    @Getter
    private final String phone;

    @JsonProperty(COUNTRY_OF_BIRTH)
    @Getter
    private final String countryOfBirth;

    @JsonProperty(COUNTRY_CITIZENSHIPS)
    @Getter
    private final String[] countryCitizenships;

    @JsonProperty(COUNTRY_TAX)
    @Getter
    private final String[] countryTax;

    @JsonProperty(CUSTOMER_ENGAGEMENT)
    @Getter
    private final CustomerEngagement customerEngagement;

    @JsonCreator
    public Customer(
            @JsonProperty(value = CUSTOMER_ID, required = true)
            final String customerId,
            @JsonProperty(value = CUSTOMER_TYPE, required = true)
            final String customerType,
            @JsonProperty(value = FIRST_NAME, required = true)
            final String firstName,
            @JsonProperty(value = LAST_NAME, required = true)
            final String lastName,
            @JsonProperty(value = COMPANY_NAME, required = true)
            final String companyName,
            @JsonProperty(value = ADDRESS, required = true)
            final Address address,
            @JsonProperty(value = EMAIL, required = true)
            final String email,
            @JsonProperty(value = PHONE, required = true)
            final String phone,
            @JsonProperty(value = COUNTRY_OF_BIRTH, required = true)
            final String countryOfBirth,
            @JsonProperty(value = COUNTRY_CITIZENSHIPS, required = true)
            final String[] countryCitizenships,
            @JsonProperty(value = COUNTRY_TAX, required = true)
            final String[] countryTax,
            @JsonProperty(value = CUSTOMER_ENGAGEMENT, required = true)
            final CustomerEngagement customerEngagement) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.firstName = firstName;
        this.lastName = lastName;
        this.companyName = companyName;
        this.address = address;
        this.email = email;
        this.phone = phone;
        this.countryOfBirth = countryOfBirth;
        this.countryCitizenships = countryCitizenships;
        this.countryTax = countryTax;
        this.customerEngagement = customerEngagement;
    }
}
