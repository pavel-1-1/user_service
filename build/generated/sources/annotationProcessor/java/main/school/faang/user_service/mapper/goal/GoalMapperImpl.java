package school.faang.user_service.mapper.goal;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.goal.GoalDto;
import school.faang.user_service.dto.goal.UpdateGoalDto;
import school.faang.user_service.entity.goal.Goal;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class GoalMapperImpl implements GoalMapper {

    @Override
    public GoalDto toGoalDto(Goal goal) {
        if ( goal == null ) {
            return null;
        }

        GoalDto.GoalDtoBuilder goalDto = GoalDto.builder();

        goalDto.parentId( goalParentId( goal ) );
        goalDto.skillIds( skillIds( goal.getSkillsToAchieve() ) );
        goalDto.id( goal.getId() );
        goalDto.title( goal.getTitle() );
        goalDto.description( goal.getDescription() );

        return goalDto.build();
    }

    @Override
    public List<GoalDto> toDtoList(List<Goal> goals) {
        if ( goals == null ) {
            return null;
        }

        List<GoalDto> list = new ArrayList<GoalDto>( goals.size() );
        for ( Goal goal : goals ) {
            list.add( toGoalDto( goal ) );
        }

        return list;
    }

    @Override
    public UpdateGoalDto goalToUpdateGoalDto(Goal goal) {
        if ( goal == null ) {
            return null;
        }

        UpdateGoalDto.UpdateGoalDtoBuilder updateGoalDto = UpdateGoalDto.builder();

        updateGoalDto.skillDtos( skillsToSkillDtos( goal.getSkillsToAchieve() ) );
        updateGoalDto.id( goal.getId() );
        updateGoalDto.title( goal.getTitle() );
        updateGoalDto.status( goal.getStatus() );

        return updateGoalDto.build();
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
