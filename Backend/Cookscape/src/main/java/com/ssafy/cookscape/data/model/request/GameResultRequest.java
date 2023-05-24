package com.ssafy.cookscape.data.model.request;

import com.ssafy.cookscape.data.db.entity.DataEntity;
import com.ssafy.cookscape.data.db.entity.UserAvatarEntity;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class GameResultRequest {

    private Long userId;
    private Long avatarId;
    private int exp;
    private int level;
    private int money;
    private boolean winFlag;
    private int saveCount;
    private int catchCount;
    private int catchedCount;
    private int valveOpenCount;
    private int valveCloseCount;
    private int potDestroyCount;

    public DataEntity toDataEntity(DataEntity data){

        return DataEntity.builder()
                .id(data.getId())
                .user(data.getUser())
                .exp(data.getExp() + this.getExp())
                .level(this.getLevel())
                .money(data.getMoney() + this.getMoney())
                .winCount(winFlag ? data.getWinCount() + 1 : data.getWinCount())
                .loseCount(winFlag ? data.getLoseCount() : data.getLoseCount() + 1)
                .saveCount(data.getSaveCount() + this.getSaveCount())
                .catchCount(data.getCatchCount() + this.getCatchCount())
                .catchedCount(data.getCatchedCount() + this.getCatchedCount())
                .valveOpenCount(data.getValveOpenCount() + this.getValveOpenCount())
                .valveCloseCount(data.getValveCloseCount() + this.getValveCloseCount())
                .potDestroyCount(data.getPotDestroyCount() + this.getPotDestroyCount())
                .expired(data.getExpired())
                .build();

    }

    public UserAvatarEntity toUserAvatarEntity(UserAvatarEntity userAvatar){

        return UserAvatarEntity.builder()
                .id(userAvatar.getId())
                .user(userAvatar.getUser())
                .avatar(userAvatar.getAvatar())
                .useCount(userAvatar.getUseCount() + 1)
                .expired(userAvatar.getExpired())
                .build();
    }
}
