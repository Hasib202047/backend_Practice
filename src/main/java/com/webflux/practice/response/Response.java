package com.webflux.practice.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Response implements Serializable {
    @JsonInclude()
    private long timestamp;
    @JsonInclude()
    private int statusCode;
    @JsonInclude()
    private String status;
    @JsonInclude()
    private String message;

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public int getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
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

    public Object getContent() {
        return content;
    }

    public void setContent(Object content) {
        this.content = content;
    }

    public long getNumberOfElement() {
        return numberOfElement;
    }

    public void setNumberOfElement(long numberOfElement) {
        this.numberOfElement = numberOfElement;
    }

    public long getRowCount() {
        return rowCount;
    }

    public void setRowCount(long rowCount) {
        this.rowCount = rowCount;
    }

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Object content;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long numberOfElement;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private long rowCount;
}
