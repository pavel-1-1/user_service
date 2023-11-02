package school.faang.user_service.mapper.goal;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.goal.GoalInvitationDto;
import school.faang.user_service.entity.User;
import school.faang.user_service.entity.goal.Goal;
import school.faang.user_service.entity.goal.GoalInvitation;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class GoalInvitationMapperImpl implements GoalInvitationMapper {

    @Override
    public GoalInvitationDto toDto(GoalInvitation goalInvitation) {
        if ( goalInvitation == null ) {
            return null;
        }

        GoalInvitationDto.GoalInvitationDtoBuilder goalInvitationDto = GoalInvitationDto.builder();

        goalInvitationDto.goalId( goalInvitationGoalId( goalInvitation ) );
        goalInvitationDto.inviterId( goalInvitationInviterId( goalInvitation ) );
        goalInvitationDto.invitedUserId( goalInvitationInvitedId( goalInvitation ) );
        goalInvitationDto.id( goalInvitation.getId() );
        goalInvitationDto.status( goalInvitation.getStatus() );

        return goalInvitationDto.build();
    }

    @Override
    public GoalInvitation toEntity(GoalInvitationDto goalInvitationDto) {
        if ( goalInvitationDto == null ) {
            return null;
        }

        GoalInvitation goalInvitation = new GoalInvitation();

        goalInvitation.setGoal( goalInvitationDtoToGoal( goalInvitationDto ) );
        goalInvitation.setInviter( goalInvitationDtoToUser( goalInvitationDto ) );
        goalInvitation.setInvited( goalInvitationDtoToUser1( goalInvitationDto ) );
        if ( goalInvitationDto.getId() != null ) {
            goalInvitation.setId( goalInvitationDto.getId() );
        }
        goalInvitation.setStatus( goalInvitationDto.getStatus() );

        return goalInvitation;
    }

    @Override
    public List<GoalInvitationDto> toDtoList(List<GoalInvitation> goalInvitations) {
        if ( goalInvitations == null ) {
            return null;
        }

        List<GoalInvitationDto> list = new ArrayList<GoalInvitationDto>( goalInvitations.size() );
        for ( GoalInvitation goalInvitation : goalInvitations ) {
            list.add( toDto( goalInvitation ) );
        }

        return list;
    }

    private Long goalInvitationGoalId(GoalInvitation goalInvitation) {
        if ( goalInvitation == null ) {
            return null;
        }
        Goal goal = goalInvitation.getGoal();
        if ( goal == null ) {
            return null;
        }
        Long id = goal.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }

    private Long goalInvitationInviterId(GoalInvitation goalInvitation) {
        if ( goalInvitation == null ) {
            return null;
        }
        User inviter = goalInvitation.getInviter();
        if ( inviter == null ) {
            return null;
        }
        long id = inviter.getId();
        return id;
    }

    private Long goalInvitationInvitedId(GoalInvitation goalInvitation) {
        if ( goalInvitation == null ) {
            return null;
        }
        User invited = goalInvitation.getInvited();
        if ( invited == null ) {
            return null;
        }
        long id = invited.getId();
        return id;
    }

    protected Goal goalInvitationDtoToGoal(GoalInvitationDto goalInvitationDto) {
        if ( goalInvitationDto == null ) {
            return null;
        }

        Goal.GoalBuilder goal = Goal.builder();

        goal.id( goalInvitationDto.getGoalId() );

        return goal.build();
    }

    protected User goalInvitationDtoToUser(GoalInvitationDto goalInvitationDto) {
        if ( goalInvitationDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( goalInvitationDto.getInviterId() != null ) {
            user.id( goalInvitationDto.getInviterId() );
        }

        return user.build();
    }

    protected User goalInvitationDtoToUser1(GoalInvitationDto goalInvitationDto) {
        if ( goalInvitationDto == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        if ( goalInvitationDto.getInvitedUserId() != null ) {
            user.id( goalInvitationDto.getInvitedUserId() );
        }

        return user.build();
    }
}
