package com.ssafy.cookscape.data.db.repository;

import com.ssafy.cookscape.data.db.entity.UserAvatarEntity;
import com.ssafy.cookscape.information.db.entity.AvatarEntity;
import com.ssafy.cookscape.user.db.entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface UserAvatarRepository extends JpaRepository<UserAvatarEntity, Long> {

    List<UserAvatarEntity> findByUser(UserEntity user);

    Optional<UserAvatarEntity> findByUserAndAvatar(UserEntity user, AvatarEntity avatar);
}
