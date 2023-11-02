package school.faang.user_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import school.faang.user_service.dto.recommendation.SkillOfferDto;
import school.faang.user_service.entity.Skill;
import school.faang.user_service.entity.recommendation.SkillOffer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
public class SkillOfferMapperImpl implements SkillOfferMapper {

    @Override
    public SkillOfferDto toDTO(SkillOffer skillOffer) {
        if ( skillOffer == null ) {
            return null;
        }

        SkillOfferDto.SkillOfferDtoBuilder skillOfferDto = SkillOfferDto.builder();

        skillOfferDto.skillId( skillOfferSkillId( skillOffer ) );
        skillOfferDto.id( skillOffer.getId() );

        return skillOfferDto.build();
    }

    @Override
    public SkillOffer toEntity(SkillOfferDto skillOfferDTO) {
        if ( skillOfferDTO == null ) {
            return null;
        }

        SkillOffer.SkillOfferBuilder skillOffer = SkillOffer.builder();

        if ( skillOfferDTO.getId() != null ) {
            skillOffer.id( skillOfferDTO.getId() );
        }

        return skillOffer.build();
    }

    @Override
    public List<SkillOfferDto> toDto(List<SkillOffer> skillOffers) {
        if ( skillOffers == null ) {
            return null;
        }

        List<SkillOfferDto> list = new ArrayList<SkillOfferDto>( skillOffers.size() );
        for ( SkillOffer skillOffer : skillOffers ) {
            list.add( toDTO( skillOffer ) );
        }

        return list;
    }

    @Override
    public List<SkillOffer> toEntity(List<SkillOfferDto> skillOffers) {
        if ( skillOffers == null ) {
            return null;
        }

        List<SkillOffer> list = new ArrayList<SkillOffer>( skillOffers.size() );
        for ( SkillOfferDto skillOfferDto : skillOffers ) {
            list.add( toEntity( skillOfferDto ) );
        }

        return list;
    }

    private Long skillOfferSkillId(SkillOffer skillOffer) {
        if ( skillOffer == null ) {
            return null;
        }
        Skill skill = skillOffer.getSkill();
        if ( skill == null ) {
            return null;
        }
        long id = skill.getId();
        return id;
    }
}
