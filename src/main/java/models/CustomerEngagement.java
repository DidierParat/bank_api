package models;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;

@JsonIgnoreProperties(ignoreUnknown = true)
public class CustomerEngagement {
    protected static final String ENGAGEMENT_ID = "engagementId";
    protected static final String ENGAGEMENT_TYPE = "engagementType";
    protected static final String ACCOUNT_NUMBER = "accountNumber";
    protected static final String FRIENDLY_NAME = "friendlyName";
    protected static final String CORPORATE = "corporate";

    @JsonProperty(ENGAGEMENT_ID)
    @Getter
    private final String engagementId;

    @JsonProperty(ENGAGEMENT_TYPE)
    @Getter
    private final String engagementType;

    @JsonProperty(ACCOUNT_NUMBER)
    @Getter
    private final String accountNumber;

    @JsonProperty(FRIENDLY_NAME)
    @Getter
    private final String friendlyName;

    @JsonProperty(CORPORATE)
    @Getter
    private final boolean corporate;

    @JsonCreator
    public CustomerEngagement(
            @JsonProperty(value = ENGAGEMENT_ID, required = true)
            final String engagementId,
            @JsonProperty(value = ENGAGEMENT_TYPE, required = true)
            final String engagementType,
            @JsonProperty(value = ACCOUNT_NUMBER, required = true)
            final String accountNumber,
            @JsonProperty(value = FRIENDLY_NAME, required = true)
            final String friendlyName,
            @JsonProperty(value = CORPORATE, required = true)
            final boolean corporate) {
        this.engagementId = engagementId;
        this.engagementType = engagementType;
        this.accountNumber = accountNumber;
        this.friendlyName = friendlyName;
        this.corporate = corporate;
    }
}
