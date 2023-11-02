package school.faang.user_service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.user.person_dto.AddressDto;
import school.faang.user_service.dto.user.person_dto.ContactInfoDto;
import school.faang.user_service.dto.user.person_dto.UserPersonDto;
import school.faang.user_service.entity.Country;
import school.faang.user_service.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class PersonToUserMapperImpl implements PersonToUserMapper {

    @Override
    public User toUser(UserPersonDto personDto) {
        if ( personDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.country( contactInfoDtoToCountry( personDto.getContactInfo() ) );
        user.email( personDtoContactInfoEmail( personDto ) );
        user.phone( personDtoContactInfoPhone( personDto ) );
        user.city( personDtoContactInfoAddressCity( personDto ) );

        user.username( personDto.getFirstName() + personDto.getLastName() );

        return user.build();
    }

    @Override
    public UserPersonDto toUserPersonDto(User user) {
        if ( user == null ) {
            return null;
        }

        UserPersonDto userPersonDto = new UserPersonDto();

        userPersonDto.setContactInfo( userToContactInfoDto( user ) );
        userPersonDto.setUsername( user.getUsername() );

        return userPersonDto;
    }

    private String contactInfoDtoAddressCountry(ContactInfoDto contactInfoDto) {
        if ( contactInfoDto == null ) {
            return null;
        }
        AddressDto address = contactInfoDto.getAddress();
        if ( address == null ) {
            return null;
        }
        String country = address.getCountry();
        if ( country == null ) {
            return null;
        }
        return country;
    }

    protected Country contactInfoDtoToCountry(ContactInfoDto contactInfoDto) {
        if ( contactInfoDto == null ) {
            return null;
        }

        Country.CountryBuilder country1 = Country.builder();

        country1.title( contactInfoDtoAddressCountry( contactInfoDto ) );

        return country1.build();
    }

    private String personDtoContactInfoEmail(UserPersonDto userPersonDto) {
        if ( userPersonDto == null ) {
            return null;
        }
        ContactInfoDto contactInfo = userPersonDto.getContactInfo();
        if ( contactInfo == null ) {
            return null;
        }
        String email = contactInfo.getEmail();
        if ( email == null ) {
            return null;
        }
        return email;
    }

    private String personDtoContactInfoPhone(UserPersonDto userPersonDto) {
        if ( userPersonDto == null ) {
            return null;
        }
        ContactInfoDto contactInfo = userPersonDto.getContactInfo();
        if ( contactInfo == null ) {
            return null;
        }
        String phone = contactInfo.getPhone();
        if ( phone == null ) {
            return null;
        }
        return phone;
    }

    private String personDtoContactInfoAddressCity(UserPersonDto userPersonDto) {
        if ( userPersonDto == null ) {
            return null;
        }
        ContactInfoDto contactInfo = userPersonDto.getContactInfo();
        if ( contactInfo == null ) {
            return null;
        }
        AddressDto address = contactInfo.getAddress();
        if ( address == null ) {
            return null;
        }
        String city = address.getCity();
        if ( city == null ) {
            return null;
        }
        return city;
    }

    protected ContactInfoDto userToContactInfoDto(User user) {
        if ( user == null ) {
            return null;
        }

        ContactInfoDto contactInfoDto = new ContactInfoDto();

        contactInfoDto.setEmail( user.getEmail() );
        contactInfoDto.setPhone( user.getPhone() );

        return contactInfoDto;
    }
}
