package school.faang.user_service.mapper;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.MentorshipRequestDto;
import school.faang.user_service.entity.MentorshipRequest;
import school.faang.user_service.entity.User;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class MentorshipRequestMapperImpl implements MentorshipRequestMapper {

    @Override
    public MentorshipRequestDto toDto(MentorshipRequest mentorshipRequest) {
        if ( mentorshipRequest == null ) {
            return null;
        }

        MentorshipRequestDto.MentorshipRequestDtoBuilder mentorshipRequestDto = MentorshipRequestDto.builder();

        mentorshipRequestDto.requesterId( mentorshipRequestRequesterId( mentorshipRequest ) );
        mentorshipRequestDto.receiverId( mentorshipRequestReceiverId( mentorshipRequest ) );
        mentorshipRequestDto.id( mentorshipRequest.getId() );
        mentorshipRequestDto.description( mentorshipRequest.getDescription() );
        mentorshipRequestDto.rejectionReason( mentorshipRequest.getRejectionReason() );
        mentorshipRequestDto.status( mentorshipRequest.getStatus() );

        return mentorshipRequestDto.build();
    }

    @Override
    public MentorshipRequest toEntity(MentorshipRequestDto mentorshipRequestDto) {
        if ( mentorshipRequestDto == null ) {
            return null;
        }

        MentorshipRequest mentorshipRequest = new MentorshipRequest();

        mentorshipRequest.setRequester( mapToUser( mentorshipRequestDto.getRequesterId() ) );
        mentorshipRequest.setReceiver( mapToUser( mentorshipRequestDto.getReceiverId() ) );
        if ( mentorshipRequestDto.getId() != null ) {
            mentorshipRequest.setId( mentorshipRequestDto.getId() );
        }
        mentorshipRequest.setDescription( mentorshipRequestDto.getDescription() );
        mentorshipRequest.setStatus( mentorshipRequestDto.getStatus() );
        mentorshipRequest.setRejectionReason( mentorshipRequestDto.getRejectionReason() );

        return mentorshipRequest;
    }

    private Long mentorshipRequestRequesterId(MentorshipRequest mentorshipRequest) {
        if ( mentorshipRequest == null ) {
            return null;
        }
        User requester = mentorshipRequest.getRequester();
        if ( requester == null ) {
            return null;
        }
        long id = requester.getId();
        return id;
    }

    private Long mentorshipRequestReceiverId(MentorshipRequest mentorshipRequest) {
        if ( mentorshipRequest == null ) {
            return null;
        }
        User receiver = mentorshipRequest.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        long id = receiver.getId();
        return id;
    }
}
