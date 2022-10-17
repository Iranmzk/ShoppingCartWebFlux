package exceptions.errorresponse;

import com.fasterxml.jackson.annotation.JsonFormat;
import exceptions.errorobject.ErrorObject;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;

@Data
@Builder
public class ErrorResponse {
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime timestamp;
    private List<ErrorObject> error;
}
