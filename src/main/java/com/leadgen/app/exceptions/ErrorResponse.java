package com.leadgen.app.exceptions;

import java.util.ArrayList;
import java.util.List;

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
	"code",
	"messages"
})
public class ErrorResponse {

    @JsonProperty("code")
    private String code;

    @JsonProperty("messages")
    private List<String> messages=new ArrayList<>();
    
}
