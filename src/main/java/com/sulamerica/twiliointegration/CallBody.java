package com.sulamerica.twiliointegration;

import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

@JsonSerialize
public class CallBody {

    @JsonValue
    private String numberTo;

    @JsonValue
    private String numberFrom;

    @JsonValue
    private String messageBody;

    public String getNumberTo() {
        return numberTo;
    }

    public void setNumberTo(String numberTo) {
        this.numberTo = numberTo;
    }

    public String getNumberFrom() {
        return numberFrom;
    }

    public void setNumberFrom(String numberFrom) {
        this.numberFrom = numberFrom;
    }

    public String getMessageBody() {
        return messageBody;
    }

    public void setMessageBody(String messageBody) {
        this.messageBody = messageBody;
    }
}
