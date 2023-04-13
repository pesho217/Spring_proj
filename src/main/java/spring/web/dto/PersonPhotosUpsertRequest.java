package spring.web.dto;

import jakarta.validation.constraints.NotNull;
import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class PersonPhotosUpsertRequest {

    @NotNull
    private Set<UUID> personPhotoIds;

}