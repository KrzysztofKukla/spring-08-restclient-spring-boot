
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
public class Card implements Serializable {
    private final static long serialVersionUID = -3727608244827206552L;

    private String type;
    private String number;
    private ExpirationDate expirationDate;
    private String iban;
    private String swift;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
