package kz.msovet.springmicroservice2.exceptions;

import java.util.Date;

public class ErrorMessage {
    private Date timestamp;
    private String desc;

    public ErrorMessage(Date timestamp, String localizedMessage) {
        this.timestamp = timestamp;
        this.desc = localizedMessage;
    }
}
