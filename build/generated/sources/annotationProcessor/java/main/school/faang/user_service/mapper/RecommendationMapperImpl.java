package school.faang.user_service.mapper;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.recommendation.RecommendationDto;
import school.faang.user_service.dto.recommendation.SkillOfferDto;
import school.faang.user_service.entity.User;
import school.faang.user_service.entity.recommendation.Recommendation;
import school.faang.user_service.entity.recommendation.SkillOffer;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class RecommendationMapperImpl implements RecommendationMapper {

    @Override
    public RecommendationDto toDto(Recommendation entity) {
        if ( entity == null ) {
            return null;
        }

        RecommendationDto.RecommendationDtoBuilder recommendationDto = RecommendationDto.builder();

        recommendationDto.authorId( entityAuthorId( entity ) );
        recommendationDto.receiverId( entityReceiverId( entity ) );
        recommendationDto.id( entity.getId() );
        recommendationDto.content( entity.getContent() );
        recommendationDto.skillOffers( skillOfferListToSkillOfferDtoList( entity.getSkillOffers() ) );
        recommendationDto.createdAt( entity.getCreatedAt() );

        return recommendationDto.build();
    }

    @Override
    public Recommendation toEntity(RecommendationDto dto) {
        if ( dto == null ) {
            return null;
        }

        Recommendation.RecommendationBuilder recommendation = Recommendation.builder();

        if ( dto.getId() != null ) {
            recommendation.id( dto.getId() );
        }
        recommendation.content( dto.getContent() );
        recommendation.skillOffers( skillOfferDtoListToSkillOfferList( dto.getSkillOffers() ) );
        recommendation.createdAt( dto.getCreatedAt() );

        return recommendation.build();
    }

    @Override
    public List<Recommendation> toEntity(List<RecommendationDto> recommendations) {
        if ( recommendations == null ) {
            return null;
        }

        List<Recommendation> list = new ArrayList<Recommendation>( recommendations.size() );
        for ( RecommendationDto recommendationDto : recommendations ) {
            list.add( toEntity( recommendationDto ) );
        }

        return list;
    }

    @Override
    public List<RecommendationDto> toDto(List<Recommendation> recommendations) {
        if ( recommendations == null ) {
            return null;
        }

        List<RecommendationDto> list = new ArrayList<RecommendationDto>( recommendations.size() );
        for ( Recommendation recommendation : recommendations ) {
            list.add( toDto( recommendation ) );
        }

        return list;
    }

    private Long entityAuthorId(Recommendation recommendation) {
        if ( recommendation == null ) {
            return null;
        }
        User author = recommendation.getAuthor();
        if ( author == null ) {
            return null;
        }
        long id = author.getId();
        return id;
    }

    private Long entityReceiverId(Recommendation recommendation) {
        if ( recommendation == null ) {
            return null;
        }
        User receiver = recommendation.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        long id = receiver.getId();
        return id;
    }

    protected SkillOfferDto skillOfferToSkillOfferDto(SkillOffer skillOffer) {
        if ( skillOffer == null ) {
            return null;
        }

        SkillOfferDto.SkillOfferDtoBuilder skillOfferDto = SkillOfferDto.builder();

        skillOfferDto.id( skillOffer.getId() );

        return skillOfferDto.build();
    }

    protected List<SkillOfferDto> skillOfferListToSkillOfferDtoList(List<SkillOffer> list) {
        if ( list == null ) {
            return null;
        }

        List<SkillOfferDto> list1 = new ArrayList<SkillOfferDto>( list.size() );
        for ( SkillOffer skillOffer : list ) {
            list1.add( skillOfferToSkillOfferDto( skillOffer ) );
        }

        return list1;
    }

    protected SkillOffer skillOfferDtoToSkillOffer(SkillOfferDto skillOfferDto) {
        if ( skillOfferDto == null ) {
            return null;
        }

        SkillOffer.SkillOfferBuilder skillOffer = SkillOffer.builder();

        if ( skillOfferDto.getId() != null ) {
            skillOffer.id( skillOfferDto.getId() );
        }

        return skillOffer.build();
    }

    protected List<SkillOffer> skillOfferDtoListToSkillOfferList(List<SkillOfferDto> list) {
        if ( list == null ) {
            return null;
        }

        List<SkillOffer> list1 = new ArrayList<SkillOffer>( list.size() );
        for ( SkillOfferDto skillOfferDto : list ) {
            list1.add( skillOfferDtoToSkillOffer( skillOfferDto ) );
        }

        return list1;
    }
}
