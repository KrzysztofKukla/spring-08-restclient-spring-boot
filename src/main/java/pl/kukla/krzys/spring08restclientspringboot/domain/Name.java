
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
public class Name implements Serializable {
    private final static long serialVersionUID = 9048167977275548705L;

    private String title;
    private String first;
    private String last;
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

}
