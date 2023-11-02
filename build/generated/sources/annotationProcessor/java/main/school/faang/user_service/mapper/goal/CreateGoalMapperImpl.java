package school.faang.user_service.mapper.goal;

import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.goal.CreateGoalDto;
import school.faang.user_service.dto.goal.ResponseGoalDto;
import school.faang.user_service.entity.goal.Goal;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:52:59+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class CreateGoalMapperImpl implements CreateGoalMapper {

    @Override
    public Goal toGoalFromCreateGoalDto(CreateGoalDto createGoalDto) {
        if ( createGoalDto == null ) {
            return null;
        }

        Goal.GoalBuilder goal = Goal.builder();

        goal.skillsToAchieve( skillDtosToSkills( createGoalDto.getSkillsToAchieve() ) );
        goal.title( createGoalDto.getTitle() );
        goal.description( createGoalDto.getDescription() );
        goal.status( createGoalDto.getStatus() );

        return goal.build();
    }

    @Override
    public ResponseGoalDto toResponseGoalDtoFromGoal(Goal goal) {
        if ( goal == null ) {
            return null;
        }

        ResponseGoalDto responseGoalDto = new ResponseGoalDto();

        responseGoalDto.setSkillsToAchieve( skillsToSkillDtos( goal.getSkillsToAchieve() ) );
        responseGoalDto.setParentId( goalParentId( goal ) );
        responseGoalDto.setId( goal.getId() );
        responseGoalDto.setTitle( goal.getTitle() );
        responseGoalDto.setDescription( goal.getDescription() );

        return responseGoalDto;
    }

    private Long goalParentId(Goal goal) {
        if ( goal == null ) {
            return null;
        }
        Goal parent = goal.getParent();
        if ( parent == null ) {
            return null;
        }
        Long id = parent.getId();
        if ( id == null ) {
            return null;
        }
        return id;
    }
}
