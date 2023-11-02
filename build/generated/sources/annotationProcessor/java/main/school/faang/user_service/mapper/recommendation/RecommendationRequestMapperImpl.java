package school.faang.user_service.mapper.recommendation;

import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;
import school.faang.user_service.dto.recommendation.RecommendationRequestDto;
import school.faang.user_service.entity.User;
import school.faang.user_service.entity.recommendation.Recommendation;
import school.faang.user_service.entity.recommendation.RecommendationRequest;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-09-30T12:53:00+0700",
    comments = "version: 1.5.3.Final, compiler: IncrementalProcessingEnvironment from gradle-language-java-7.6.1.jar, environment: Java 17.0.8 (Amazon.com Inc.)"
)
@Component
public class RecommendationRequestMapperImpl implements RecommendationRequestMapper {

    @Override
    public RecommendationRequestDto toDto(RecommendationRequest recommendationRequest) {
        if ( recommendationRequest == null ) {
            return null;
        }

        RecommendationRequestDto recommendationRequestDto = new RecommendationRequestDto();

        recommendationRequestDto.setRequesterId( recommendationRequestRequesterId( recommendationRequest ) );
        recommendationRequestDto.setReceiverId( recommendationRequestReceiverId( recommendationRequest ) );
        recommendationRequestDto.setRecommendationId( recommendationRequestRecommendationId( recommendationRequest ) );
        recommendationRequestDto.setSkillsId( skillsToIds( recommendationRequest.getSkills() ) );
        recommendationRequestDto.setId( recommendationRequest.getId() );
        recommendationRequestDto.setMessage( recommendationRequest.getMessage() );
        recommendationRequestDto.setStatus( recommendationRequest.getStatus() );
        recommendationRequestDto.setRejectionReason( recommendationRequest.getRejectionReason() );
        recommendationRequestDto.setCreatedAt( recommendationRequest.getCreatedAt() );
        recommendationRequestDto.setUpdatedAt( recommendationRequest.getUpdatedAt() );

        return recommendationRequestDto;
    }

    @Override
    public List<RecommendationRequestDto> toDtoList(List<RecommendationRequest> recommendationRequestDto) {
        if ( recommendationRequestDto == null ) {
            return null;
        }

        List<RecommendationRequestDto> list = new ArrayList<RecommendationRequestDto>( recommendationRequestDto.size() );
        for ( RecommendationRequest recommendationRequest : recommendationRequestDto ) {
            list.add( toDto( recommendationRequest ) );
        }

        return list;
    }

    @Override
    public RecommendationRequest toEntity(RecommendationRequestDto recommendationRequestDto) {
        if ( recommendationRequestDto == null ) {
            return null;
        }

        RecommendationRequest.RecommendationRequestBuilder recommendationRequest = RecommendationRequest.builder();

        recommendationRequest.id( recommendationRequestDto.getId() );
        recommendationRequest.message( recommendationRequestDto.getMessage() );
        recommendationRequest.status( recommendationRequestDto.getStatus() );
        recommendationRequest.rejectionReason( recommendationRequestDto.getRejectionReason() );
        recommendationRequest.createdAt( recommendationRequestDto.getCreatedAt() );
        recommendationRequest.updatedAt( recommendationRequestDto.getUpdatedAt() );

        return recommendationRequest.build();
    }

    private Long recommendationRequestRequesterId(RecommendationRequest recommendationRequest) {
        if ( recommendationRequest == null ) {
            return null;
        }
        User requester = recommendationRequest.getRequester();
        if ( requester == null ) {
            return null;
        }
        long id = requester.getId();
        return id;
    }

    private Long recommendationRequestReceiverId(RecommendationRequest recommendationRequest) {
        if ( recommendationRequest == null ) {
            return null;
        }
        User receiver = recommendationRequest.getReceiver();
        if ( receiver == null ) {
            return null;
        }
        long id = receiver.getId();
        return id;
    }

    private Long recommendationRequestRecommendationId(RecommendationRequest recommendationRequest) {
        if ( recommendationRequest == null ) {
            return null;
        }
        Recommendation recommendation = recommendationRequest.getRecommendation();
        if ( recommendation == null ) {
            return null;
        }
        long id = recommendation.getId();
        return id;
    }
}
