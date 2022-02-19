package code.buffer.department_register.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.Length;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.*;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long departmentId;

    @NotBlank(message = "Please add department name!")
    /*@Length(max = 10, min = 1)
    @Size(max= , min= )
    @Email
    @Positive
    @PositiveOrZero
    @NegativeOrZero
    @Negative*/
    private String departmentName;
    private String departmentAddress;
    private String departmentCode;

    @Override
    public String toString(){
        return "Department {" +
                "department_id = " + departmentId +
                ", department_name = '" + departmentName + '\'' +
                ", department_address = '" + departmentAddress + '\'' +
                ", department_code = '" + departmentCode + '\'' +
                '}';
    }
}
