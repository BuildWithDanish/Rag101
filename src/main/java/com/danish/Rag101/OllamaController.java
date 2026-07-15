package com.danish.Rag101;

import org.springframework.ai.chat.client.ChatClient;
import org.springframework.ai.chat.model.ChatModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()
public class OllamaController {

    ChatClient client;

    public OllamaController(ChatModel chatModel) {
        this.client = ChatClient.builder(chatModel).build();
    }

    @GetMapping("/chat")
    public String chat() {
        return client.prompt("How are you").call().content();
    }
}
