package com.leadgen.app.exceptions;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
	"status",
	"errorResponse"
})
public class ErrorInfo {

    @JsonProperty("status")
    private String status;

    @JsonProperty("errorResponse")
    private ErrorResponse errorResponse;

    


    
}
