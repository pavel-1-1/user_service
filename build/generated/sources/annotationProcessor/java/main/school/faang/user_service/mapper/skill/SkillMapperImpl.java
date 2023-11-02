package school.faang.user_service.mapper.skill;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import school.faang.user_service.dto.skill.SkillDto;
import school.faang.user_service.entity.Skill;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class SkillMapperImpl implements SkillMapper {

    @Override
    public SkillDto toDTO(Skill skill) {
        if ( skill == null ) {
            return null;
        }

        SkillDto.SkillDtoBuilder skillDto = SkillDto.builder();

        skillDto.id( skill.getId() );
        skillDto.title( skill.getTitle() );

        return skillDto.build();
    }

    @Override
    public Skill toEntity(SkillDto skillDTO) {
        if ( skillDTO == null ) {
            return null;
        }

        Skill.SkillBuilder skill = Skill.builder();

        if ( skillDTO.getId() != null ) {
            skill.id( skillDTO.getId() );
        }
        skill.title( skillDTO.getTitle() );

        return skill.build();
    }

    @Override
    public List<SkillDto> toListSkillsDTO(List<Skill> skills) {
        if ( skills == null ) {
            return null;
        }

        List<SkillDto> list = new ArrayList<SkillDto>( skills.size() );
        for ( Skill skill : skills ) {
            list.add( toDTO( skill ) );
        }

        return list;
    }

    @Override
    public List<Skill> toListSkillsEntity(List<SkillDto> skillsDto) {
        if ( skillsDto == null ) {
            return null;
        }

        List<Skill> list = new ArrayList<Skill>( skillsDto.size() );
        for ( SkillDto skillDto : skillsDto ) {
            list.add( toEntity( skillDto ) );
        }

        return list;
    }
}
