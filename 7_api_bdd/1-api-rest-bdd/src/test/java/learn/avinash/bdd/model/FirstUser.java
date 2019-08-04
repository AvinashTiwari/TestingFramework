package learn.avinash.bdd.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@JsonInclude(JsonInclude.Include.NON_NULL)
public class FirstUser {
    public  String firstName;
    public String lastName;
    Address address;


}
