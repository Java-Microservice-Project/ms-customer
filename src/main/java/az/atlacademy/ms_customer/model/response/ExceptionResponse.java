package az.atlacademy.ms_customer.model.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.*;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;
import java.util.Map;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@FieldDefaults(level = AccessLevel.PRIVATE)
public class ExceptionResponse {

    Integer status;
    String error;
    String message;
    String path;
    LocalDateTime timestamp;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    Map<String, String> validationErrors;
}
