package com.hmdp.utils;

import com.hmdp.dto.UserDTO;
import com.hmdp.entity.User;

public class UserToUserDTO {
    public static UserDTO userToUserDTO(User user) {
        String nickName = user.getNickName();
        String icon = user.getIcon();
        Long id = user.getId();
        UserDTO userDTO = new UserDTO();
        userDTO.setId(id);
        userDTO.setNickName(nickName);
        userDTO.setIcon(icon);
        return userDTO;
    }
}
