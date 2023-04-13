package spring.web.dto;

import lombok.Builder;
import lombok.Data;

import java.util.Set;
import java.util.UUID;

@Data
@Builder
public class PersonPhotosGetResponse {

    private Set<UUID> personPhotoIds;

}
