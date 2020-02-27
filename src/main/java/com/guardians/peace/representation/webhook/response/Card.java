package com.guardians.peace.representation.webhook.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import org.apache.commons.lang3.builder.ReflectionToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class Card {

    private String title;

    private String subtitle;

    private String imageUri;

    private Buttons[] buttons;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSubtitle() {
        return subtitle;
    }

    public void setSubtitle(String subtitle) {
        this.subtitle = subtitle;
    }

    public String getImageUri() {
        return imageUri;
    }

    public void setImageUri(String imageUri) {
        this.imageUri = imageUri;
    }

    public Buttons[] getButtons() {
        return buttons;
    }

    public void setButtons(Buttons[] buttons) {
        this.buttons = buttons;
    }

    @Override
    public String toString() {
        return ReflectionToStringBuilder.toString(this);
    }

    public static final class CardBuilder {
        private String title;
        private String subtitle;
        private String imageUri;
        private Buttons[] buttons;

        private CardBuilder() {
        }

        public static CardBuilder aCard() {
            return new CardBuilder();
        }

        public CardBuilder withTitle(String title) {
            this.title = title;
            return this;
        }

        public CardBuilder withSubtitle(String subtitle) {
            this.subtitle = subtitle;
            return this;
        }

        public CardBuilder withImageUri(String imageUri) {
            this.imageUri = imageUri;
            return this;
        }

        public CardBuilder withButtons(Buttons[] buttons) {
            this.buttons = buttons;
            return this;
        }

        public Card build() {
            Card card = new Card();
            card.setTitle(title);
            card.setSubtitle(subtitle);
            card.setImageUri(imageUri);
            card.setButtons(buttons);
            return card;
        }
    }
}
