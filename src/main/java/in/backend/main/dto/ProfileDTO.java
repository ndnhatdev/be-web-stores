package in.backend.main.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDTO {
    private Long profileId;
    private String address;
    private String about;
    private String phone;
    private String socialLink;
}