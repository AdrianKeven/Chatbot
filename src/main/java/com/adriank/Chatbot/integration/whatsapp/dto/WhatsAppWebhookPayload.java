package com.adriank.Chatbot.integration.whatsapp.dto;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class WhatsAppWebhookPayload {

    private List<Entry> entry;

    @Getter
    @Setter
    public static class Entry {
        private List<Change> changes;
    }

    @Getter
    @Setter
    public static class Change {
        private Value value;
    }

    @Getter
    @Setter
    public static class Value {
        private List<Message> messages;
    }

    @Getter
    @Setter
    public static class Message {
        private String from;
        private Text text;
    }

    @Getter
    @Setter
    public static class Text {
        private String body;
    }
}
