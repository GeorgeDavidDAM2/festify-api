package GeorgeDavidDAM2.festify_api.dto.request;

import java.util.List;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.PositiveOrZero;
import jakarta.validation.constraints.Size;

public record CreateArtistRequest(
        @NotEmpty(message = "El nombre es obligatorio") 
        @Size(max = 25, message = "La biografía no puede exceder los 25 caracteres") 
        String name,

        @NotEmpty(message = "Al menos un género es obligatorio") 
        List<String> genres,

        @NotBlank(message = "El país es obligatorio") 
        @Pattern(regexp = "^[A-Z]{2}$", message = "El país debe tener el formato de dos letras (por ejemplo, ES, US)") 
        String country,

        @NotNull(message = "El número de oyentes es obligatorio") 
        @PositiveOrZero(message = "El número de oyentes debe ser un valor positivo o cero") 
        Long listeners,

        @NotBlank(message = "El estado es obligatorio") 
        String status,

        @Size(max = 500, message = "La biografía no puede exceder los 500 caracteres") 
        String biography) {
}
