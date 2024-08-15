package illvent.backend.member.dto;

import illvent.backend.member.domain.MemberRole;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
public class MemberUpdateRequestDTO {

    @NotNull
    private String email;

    @NotNull
    private String name;

    @NotNull
    private String nickname;

    @NotNull
    private String location;
}
