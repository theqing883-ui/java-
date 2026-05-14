package com.kaer.model.dto;

import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.Getter;

import java.time.LocalDateTime;
import java.util.List;

/**
 * 智能代理(Agent)数据传输对象
 * <p>用于封装智能代理的配置信息，包括模型类型、工具权限、知识库权限等</p>
 */
@Data
@Builder/*是 Lombok 库提供的一个注解，用于自动生成构建器模式（Builder Pattern）的代码。*/
public class AgentDTO {

    /**
     * 代理唯一标识
     */
    private String id;

    /**
     * 代理名称
     */
    private String name;

    /**
     * 代理描述信息
     */
    private String description;

    /**
     * 系统提示词，用于引导代理行为
     */
    private String systemPrompt;

    /**
     * 模型类型
     */
    private ModelType model;

    /**
     * 允许使用的工具列表
     */
    private List<String> allowedTools;

    /**
     * 允许访问的知识库列表
     */
    private List<String> allowedKbs;

    /**
     * 聊天配置选项
     */
    private ChatOptions chatOptions;

    /**
     * 创建时间
     */
    private LocalDateTime createdAt;

    /**
     * 更新时间
     */
    private LocalDateTime updatedAt;

    /**
     * 模型类型枚举
     * <p>定义支持的AI模型类型</p>
     */
    @Getter
    @AllArgsConstructor
    public enum ModelType {

        /**
         * DeepSeek聊天模型
         */
        DEEPSEEK_CHAT("deepseek-chat"),

        /**
         * GLM-4.6模型
         */
        GLM_4_6("glm-4.6");

        /**
         * 模型名称标识
         */
        @JsonValue
        private final String modelName;

        /**
         * 根据模型名称获取对应的枚举值
         *
         * @param modelName 模型名称
         * @return ModelType 对应的枚举值
         * @throws IllegalArgumentException 当模型名称未知时抛出
         */
        public static ModelType fromModelName(String modelName) {
            for (ModelType type : ModelType.values()) {
                if (type.modelName.equals(modelName)) {
                    return type;
                }
            }
            throw new IllegalArgumentException("Unknown model type: " + modelName);
        }
    }

    /**
     * 聊天配置选项内部类
     * <p>用于配置AI聊天的参数，如温度、topP等</p>
     */
    @Data
    @AllArgsConstructor
    @Builder
    public static class ChatOptions {

        /**
         * 默认温度值
         */
        private static final Double DEFAULT_TEMPERATURE = 0.7;

        /**
         * 默认topP值
         */
        private static final Double DEFAULT_TOP_P = 1.0;

        /**
         * 默认消息窗口长度
         */
        private static final Integer DEFAULT_MESSAGE_LENGTH = 10;

        /**
         * 温度参数，控制输出的随机性，范围0-1，越高越随机
         */
        private Double temperature;

        /**
         * topP参数，控制核采样概率，范围0-1
         */
        private Double topP;

        /**
         * 聊天消息窗口长度，即保留的历史消息数量
         */
        private Integer messageLength;

        /**
         * 获取默认聊天配置选项
         *
         * @return ChatOptions 默认配置
         */
        public static ChatOptions defaultOptions() {
            return ChatOptions.builder()
                    .temperature(DEFAULT_TEMPERATURE)
                    .topP(DEFAULT_TOP_P)
                    .messageLength(DEFAULT_MESSAGE_LENGTH)
                    .build();
        }
    }
}