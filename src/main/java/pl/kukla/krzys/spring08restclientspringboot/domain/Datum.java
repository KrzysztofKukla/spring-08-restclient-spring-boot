
package pl.kukla.krzys.spring08restclientspringboot.domain;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Datum implements Serializable {
    private final static long serialVersionUID = -7374562201577884949L;

    private String gender;
    private Name name;
    private Location location;
    private String email;
    private Login login;
    private String phone;
    private Job job;
    private Billing billing;
    private String language;
    private String currency;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
