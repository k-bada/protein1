package protein.proteinspring.service;

import protein.proteinspring.dto.PostingDto;
import protein.proteinspring.dto.PostingLogDto;
import protein.proteinspring.dto.PostingRequestDto;
import protein.proteinspring.entity.Posting;
import protein.proteinspring.entity.User;
import protein.proteinspring.exception.BadRequestExcpetion;
import protein.proteinspring.repository.PostingRepository;
import protein.proteinspring.repository.UserRepository;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class PostingService {
    private final PostingRepository postingRepository;
    private final UserRepository userRepository;

    public PostingDto addPost(PostingRequestDto requestDto) {
        User user = userRepository.findById(requestDto.getUserId())
                .orElseThrow(() -> new BadRequestExcpetion("등록되지 않은 유저입니다."));

        Posting posting = postingRepository.save(
                new Posting().setUser(user)
                        .setContent(requestDto.getContent())
        );
        return PostingDto.fromEntity(posting);
    }

    public List<PostingLogDto> findPost() {
        List<Posting> postings = postingRepository.findAll(Sort.by(Sort.Direction.DESC, "createDate"));
        return postings.stream()
                .map(PostingLogDto::fromEntity)
                .collect(Collectors.toList());
    }
}
