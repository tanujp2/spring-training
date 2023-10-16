package live.tanujdevops.rest.exception;

import java.sql.Timestamp;

public class StudentErrorResponse {
    private String status;
    private String message;
    private Timestamp timestamp;

    public StudentErrorResponse() {
    }

    public StudentErrorResponse(String status, String message, Timestamp timestamp) {
        this.status = status;
        this.message = message;
        this.timestamp = timestamp;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }
}
