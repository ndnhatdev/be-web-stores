package in.backend.main.entity;

import in.backend.main.utility.Constants;
import jakarta.persistence.*;
import lombok.Data;

import java.awt.*;
import java.sql.Timestamp;

@Data
@Entity
@Table(name = Constants.PROFILE_TABLE)
public class UserProfiles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = Constants.PROFILE_ID)
    private Long id;

    @Column(name = Constants.PHONE_NUMBER, length = Constants.S_PHONE_NUMBER)
    private String phone_number;

    @Column(name = Constants.IMAGE)
    private String uriImage;

    @Column(name = Constants.ADDRESS)
    private String address;

    @Column(name = Constants.ABOUT)
    private String aboutMe;

    @Column(name = Constants.SOCIAL)
    private String socialLink;

    @Column(name = Constants.CREATE_AT)
    private Timestamp createdAt;

    @Column(name = Constants.UPDATE_AT)
    private Timestamp updatedAt;

//    @OneToOne(mappedBy = "userProfiles")
//    private Users users;
}
