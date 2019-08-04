package learn.avinash.bdd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Address {
    public String streetAddress;
    public float phone;
    private String email;

   }
