package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class Address {
    protected static final String POSTAL_ADDRESS_LINE1 = "postalAddressLine1";
    protected static final String POSTAL_ADDRESS_LINE2 = "postalAddressLine2";
    protected static final String POSTAL_ADDRESS_LINE3 = "postalAddressLine3";
    protected static final String POST_CODE = "postCode";
    protected static final String POST_CITY = "postCity";
    protected static final String POST_COUNTRY = "postCountry";

    @JsonProperty(POSTAL_ADDRESS_LINE1)
    @Getter
    private final String postalAddressLine1;

    @JsonProperty(POSTAL_ADDRESS_LINE2)
    @Getter
    private final String postalAddressLine2;

    @JsonProperty(POSTAL_ADDRESS_LINE3)
    @Getter
    private final String postalAddressLine3;

    @JsonProperty(POST_CODE)
    @Getter
    private final String postCode;

    @JsonProperty(POST_CITY)
    @Getter
    private final String postCity;

    @JsonProperty(POST_COUNTRY)
    @Getter
    private final String postCountry;

    @JsonCreator
    public Address(
            @JsonProperty(value = POSTAL_ADDRESS_LINE1, required = true)
            final String postalAddressLine1,
            @JsonProperty(value = POSTAL_ADDRESS_LINE2, required = true)
            final String postalAddressLine2,
            @JsonProperty(value = POSTAL_ADDRESS_LINE3, required = true)
            final String postalAddressLine3,
            @JsonProperty(value = POST_CODE, required = true)
            final String postCode,
            @JsonProperty(value = POST_CITY, required = true)
            final String postCity,
            @JsonProperty(value = POST_COUNTRY, required = true)
            final String postCountry) {
        this.postalAddressLine1 = postalAddressLine1;
        this.postalAddressLine2 = postalAddressLine2;
        this.postalAddressLine3 = postalAddressLine3;
        this.postCode = postCode;
        this.postCity = postCity;
        this.postCountry = postCountry;
    }
}
