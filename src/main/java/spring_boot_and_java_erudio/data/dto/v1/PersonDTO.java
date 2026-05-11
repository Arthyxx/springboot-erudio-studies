package spring_boot_and_java_erudio.data.dto.v1;

//import com.fasterxml.jackson.annotation.JsonProperty;
//import com.fasterxml.jackson.annotation.JsonPropertyOrder;

//import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import org.springframework.hateoas.RepresentationModel;
import spring_boot_and_java_erudio.serializer.GenderSerializer;

import java.io.Serializable;
import java.util.Objects;

//@JsonPropertyOrder({"id", "address", "first_name", "last_name", "gender"})
public class PersonDTO extends RepresentationModel<PersonDTO> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;

//    @JsonProperty("first_name")
    private String firstName;

//    @JsonProperty("last_name")
    private String lastName;
    private String address;

    @JsonSerialize(using = GenderSerializer.class)
    private String gender;

    private Boolean enabled;

    public PersonDTO() {
    }

    public Boolean getEnabled() {
        return enabled;
    }

    public void setEnabled(Boolean enabled) {
        this.enabled = enabled;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object object) {
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        PersonDTO dto = (PersonDTO) object;
        return Objects.equals(getId(), dto.getId()) && Objects.equals(getFirstName(), dto.getFirstName()) && Objects.equals(getLastName(), dto.getLastName()) && Objects.equals(getAddress(), dto.getAddress()) && Objects.equals(getGender(), dto.getGender()) && Objects.equals(getEnabled(), dto.getEnabled());
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), getId(), getFirstName(), getLastName(), getAddress(), getGender(), getEnabled());
    }
}
