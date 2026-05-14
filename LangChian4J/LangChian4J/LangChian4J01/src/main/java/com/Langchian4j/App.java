package com.Langchian4j;

import dev.langchain4j.model.openai.OpenAiChatModel;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) {
        OpenAiChatModel chatModel = OpenAiChatModel.builder()
                .baseUrl("https://dashscope.aliyuncs.com/compatible-mode/v1")
                .apiKey(System.getenv("API-KEY"))
                .modelName("qwen3.6-plus")
                .logRequests(true)
                .logResponses(true)
                .build();
        String chat = chatModel.chat("你是谁？");
        System.out.println(chat);
    }
}
