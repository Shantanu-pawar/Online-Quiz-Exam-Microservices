package com.app.questionservice.Model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
public class Response {
    private int id;
    private String ansResponse;

    public Response(int id, String ansResponse) {
        this.id = id;
        this.ansResponse = ansResponse;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAnsResponse() {
        return ansResponse;
    }

    public void setAnsResponse(String ansResponse) {
        this.ansResponse = ansResponse;
    }
}
