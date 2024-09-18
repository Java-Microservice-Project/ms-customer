package az.atlacademy.ms_customer.model.request;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.FieldDefaults;

import java.math.BigDecimal;

@Data
@NoArgsConstructor
@AllArgsConstructor
@FieldDefaults(level = AccessLevel.PRIVATE)


public class SaveCustomerDto {

    @Size(min = 3, max = 50, message = "Name Required - The name must be between 3 and 50 characters.")
    String fullName;

    @NotNull(message = "Age Required")
    Integer age;

    @NotBlank(message = "Pin Required")
    String pin;

    @NotNull(message = "Balance Required")
    BigDecimal balance;
}
