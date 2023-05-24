package com.ssafy.cookscape.data.model.response;

import com.ssafy.cookscape.data.db.entity.UserAvatarEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Builder
public class UsageAvatarResponse {

    private Long userAvatarId;
    private Long avatarId;
    private String name;
    private String detail;
    private int useCount;

    public static UsageAvatarResponse toDto(UserAvatarEntity userAvatar){

        return UsageAvatarResponse.builder()
                .userAvatarId(userAvatar.getId())
                .avatarId(userAvatar.getAvatar().getId())
                .name(userAvatar.getAvatar().getName())
                .detail(userAvatar.getAvatar().getDetail())
                .useCount(userAvatar.getUseCount())
                .build();

    }
}
