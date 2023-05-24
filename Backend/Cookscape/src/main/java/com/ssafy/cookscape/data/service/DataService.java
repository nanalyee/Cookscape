package com.ssafy.cookscape.data.service;

import com.ssafy.cookscape.data.model.request.GameResultRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ssafy.cookscape.data.db.entity.DataEntity;
import com.ssafy.cookscape.data.db.entity.UserAvatarEntity;
import com.ssafy.cookscape.data.model.response.UsageAvatarResponse;
import com.ssafy.cookscape.information.db.entity.AvatarEntity;
import com.ssafy.cookscape.information.db.repository.AvatarRepository;
import com.ssafy.cookscape.user.db.entity.UserEntity;
import com.ssafy.cookscape.data.db.repository.DataRepository;
import com.ssafy.cookscape.data.db.repository.UserAvatarRepository;
import com.ssafy.cookscape.user.db.repository.UserRepository;
import com.ssafy.cookscape.global.error.exception.ApiErrorException;
import com.ssafy.cookscape.global.common.model.response.ResponseSuccessDto;
import com.ssafy.cookscape.global.util.ResponseUtil;
import com.ssafy.cookscape.global.util.enums.ApiStatus;
import com.ssafy.cookscape.data.model.response.DataResponse;
import com.ssafy.cookscape.user.model.response.UserResponse;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // 기본적으로 트랜잭션 안에서만 데이터 변경하게 설정(성능 향상)
@RequiredArgsConstructor // Lombok을 사용해 @Autowired 없이 의존성 주입. final 객제만 주입됨을 주의
public class DataService {

    private final ResponseUtil responseUtil;

    private final DataRepository dataRepository;
    private final UserRepository userRepository;
    private final AvatarRepository avatarRepository;
    private final UserAvatarRepository userAvatarRepository;

    // 회원가입 시 유저에 대한 모든 기본데이터에 대한 정보 생성
    @Transactional
    public Long addUserData(){

        DataEntity saveUserData = DataEntity.builder().level(1).build();

        return dataRepository.save(saveUserData).getId();
    }

    // 회원가입 시 유저에 대한 모든 아바타에 대한 정보 생성
    @Transactional
    public ResponseSuccessDto<?> addUserAvatarData(Long userId){

        UserEntity findUser = userRepository.findById(userId)
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));

        List<AvatarEntity> findAvatarList = avatarRepository.findAll();

        List<UserAvatarEntity> saveUserAvatarList = new ArrayList<>();

        for(AvatarEntity avatar : findAvatarList){
            saveUserAvatarList.add(UserAvatarEntity.builder()
                    .avatar(avatar)
                    .user(findUser)
                    .build());
        }

        userAvatarRepository.saveAll(saveUserAvatarList);

        return responseUtil.buildSuccessResponse(null);

    }

    // 유저가 사용한 아바타 조회
    @Transactional
    public ResponseSuccessDto<?> getUsageAvatarData(Long userId){

        UserEntity findUser = userRepository.findByIdAndExpiredLike(userId, "F")
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));

        List<UserAvatarEntity> findUserAvatar = userAvatarRepository.findByUser(findUser);

        List<UsageAvatarResponse> UsageAvatar = findUserAvatar.stream()
                .map(UsageAvatarResponse::toDto)
                .collect(Collectors.toList());

        return responseUtil.buildSuccessResponse(UsageAvatar);
    }

    // 유저 데이터 조회
    @Transactional
    public ResponseSuccessDto<?> getUserData(Long userId){

        UserEntity findUser = userRepository.findByIdAndExpiredLike(userId, "F")
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));

        DataResponse UserData = DataResponse.toDto(findUser.getData());

        return responseUtil.buildSuccessResponse(UserData);

    }

    // 게임 결과 데이터를 업데이트
    @Transactional
    public ResponseSuccessDto<?> updateResultData(GameResultRequest resultDto){

        UserEntity findUser = userRepository.findById(resultDto.getUserId())
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));

        DataEntity findData = dataRepository.findByUser(findUser)
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));

        AvatarEntity findAvatar = avatarRepository.findById(resultDto.getAvatarId())
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));

        UserAvatarEntity findUserAvatar = userAvatarRepository.findByUserAndAvatar(findUser, findAvatar)
                .orElseThrow(() -> new ApiErrorException(ApiStatus.RESOURCE_NOT_FOUND));


        UserAvatarEntity saveUserAvatar = resultDto.toUserAvatarEntity(findUserAvatar);

        DataEntity saveData = resultDto.toDataEntity(findData);

        dataRepository.save(saveData).getId();
        userAvatarRepository.save(saveUserAvatar);

        return responseUtil.buildSuccessResponse(null);
    }
}
