package com.guardians.peace.builder;

import com.guardians.peace.representation.webhook.response.Google;
import com.guardians.peace.representation.webhook.response.Items;
import com.guardians.peace.representation.webhook.response.Payload;
import com.guardians.peace.representation.webhook.response.RichResponse;
import com.guardians.peace.representation.webhook.response.SimpleResponse;
import com.guardians.peace.representation.webhook.response.WebhookResponse;

import javax.inject.Named;

@Named
public class WebhookResponseBuilder {

    public WebhookResponse buildWebhookResponse(String message) {
        SimpleResponse simpleResponse = SimpleResponse.SimpleResponseBuilder.aSimpleResponse().withTextToSpeech(message).build();
        Items[] items = new Items[] { Items.ItemsBuilder.anItems().withSimpleResponse(simpleResponse).build() };
        RichResponse richResponse = RichResponse.RichResponseBuilder.aRichResponse().withItems(items).build();
        Google google = Google.GoogleBuilder.aGoogle().withExpectUserResponse(true).withRichResponse(richResponse).build();
        Payload payload = Payload.PayloadBuilder.aPayload().withGoogle(google).build();

        return WebhookResponse.WebhookResponseBuilder.aWebhookResponse()
                        .withPayload(payload)
                        .build();
    }
}
