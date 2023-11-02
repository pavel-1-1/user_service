package school.faang.user_service.mapper.event;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import school.faang.user_service.dto.event.EventDto;
import school.faang.user_service.entity.User;
import school.faang.user_service.entity.event.Event;
import school.faang.user_service.mapper.skill.SkillMapper;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class EventMapperImpl implements EventMapper {

    private final SkillMapper skillMapper = SkillMapper.INSTANCE;

    @Override
    public EventDto toDto(Event event) {
        if ( event == null ) {
            return null;
        }

        EventDto eventDto = new EventDto();

        eventDto.setOwnerId( eventOwnerId( event ) );
        eventDto.setId( event.getId() );
        eventDto.setTitle( event.getTitle() );
        eventDto.setStartDate( event.getStartDate() );
        eventDto.setEndDate( event.getEndDate() );
        eventDto.setDescription( event.getDescription() );
        eventDto.setRelatedSkills( skillMapper.toListSkillsDTO( event.getRelatedSkills() ) );
        eventDto.setLocation( event.getLocation() );
        eventDto.setMaxAttendees( event.getMaxAttendees() );
        eventDto.setType( event.getType() );

        return eventDto;
    }

    @Override
    public Event toEntity(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        Event.EventBuilder event = Event.builder();

        event.owner( eventDtoToUser( eventDto ) );
        if ( eventDto.getId() != null ) {
            event.id( eventDto.getId() );
        }
        event.title( eventDto.getTitle() );
        event.description( eventDto.getDescription() );
        event.startDate( eventDto.getStartDate() );
        event.endDate( eventDto.getEndDate() );
        event.location( eventDto.getLocation() );
        event.maxAttendees( eventDto.getMaxAttendees() );
        event.relatedSkills( skillMapper.toListSkillsEntity( eventDto.getRelatedSkills() ) );
        event.type( eventDto.getType() );

        return event.build();
    }

    @Override
    public List<EventDto> toListDto(List<Event> events) {
        if ( events == null ) {
            return null;
        }

        List<EventDto> list = new ArrayList<EventDto>( events.size() );
        for ( Event event : events ) {
            list.add( toDto( event ) );
        }

        return list;
    }

    private Long eventOwnerId(Event event) {
        if ( event == null ) {
            return null;
        }
        User owner = event.getOwner();
        if ( owner == null ) {
            return null;
        }
        long id = owner.getId();
        return id;
    }

    protected User eventDtoToUser(EventDto eventDto) {
        if ( eventDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( eventDto.getOwnerId() != null ) {
            user.id( eventDto.getOwnerId() );
        }

        return user.build();
    }
}
