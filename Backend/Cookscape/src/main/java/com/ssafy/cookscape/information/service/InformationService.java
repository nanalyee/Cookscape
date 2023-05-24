package com.ssafy.cookscape.information.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import com.ssafy.cookscape.global.util.ResponseUtil;
import com.ssafy.cookscape.information.db.entity.AvatarEntity;
import com.ssafy.cookscape.information.db.entity.ItemEntity;
import com.ssafy.cookscape.information.db.repository.AvatarRepository;
import com.ssafy.cookscape.information.db.repository.ItemRepository;
import com.ssafy.cookscape.information.model.response.AvatarResponse;
import com.ssafy.cookscape.information.model.response.ItemResponse;
import com.ssafy.cookscape.global.common.model.response.ResponseSuccessDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional(readOnly = true) // 기본적으로 트랜잭션 안에서만 데이터 변경하게 설정(성능 향상)
@RequiredArgsConstructor // Lombok을 사용해 @Autowired 없이 의존성 주입. final 객제만 주입됨을 주의
public class InformationService {

    private final ResponseUtil responseUtil;

    private final AvatarRepository avatarRepository;
    private final ItemRepository itemRepository;

    // 게임 아이템 데이터 조회
    @Transactional
    public ResponseSuccessDto<?> getItemInformation(){

        List<ItemEntity> itemEntityList = itemRepository.findAll();
        List<ItemResponse> ItemInformation = itemEntityList.stream()
                .map(ItemResponse::toDto)
                .collect(Collectors.toList());

        return responseUtil.buildSuccessResponse(ItemInformation);

    }

    // 게임 아바타 데이터 조회
    @Transactional
    public ResponseSuccessDto<?> getAvatarInformation(){

        List<AvatarEntity> avatarEntityList = avatarRepository.findAll();
        List<AvatarResponse> AvatarInformation = avatarEntityList.stream()
                .map(AvatarResponse::toDto)
                .collect(Collectors.toList());

        return responseUtil.buildSuccessResponse(AvatarInformation);

    }
}
