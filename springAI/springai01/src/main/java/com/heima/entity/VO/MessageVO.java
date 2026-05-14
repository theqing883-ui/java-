package com.heima.entity.VO;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.ai.chat.messages.Message;
import org.springframework.stereotype.Component;

@Data
@NoArgsConstructor
@Component
public class MessageVO {
    private String role;
    private String content;

    public MessageVO(Message message) {
        switch (message.getMessageType()) {
            case USER:
                role = "user";
                content = message.getText();
                break;
            case ASSISTANT:
                role = "assistant";
                content = message.getText();
                break;
            default:
                role = "";
                content = "";
                break;
        }
    }
}
