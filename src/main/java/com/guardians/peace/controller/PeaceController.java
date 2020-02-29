package com.guardians.peace.controller;

import com.guardians.peace.builder.WebhookResponseBuilder;
import com.guardians.peace.representation.webhook.request.WebhookRequest;
import com.guardians.peace.representation.webhook.response.WebhookResponse;
import com.guardians.peace.service.PeaceService;
import org.slf4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Map;

import static org.slf4j.LoggerFactory.getLogger;

@RestController
@RequestMapping("/peace/")
public class PeaceController {

    private static final Logger LOGGER = getLogger(PeaceController.class);
    private static final String URL_GET_JIRA_REPORT = "/report/jira/opendefect";
    private static final String URL_CREATE_STORY_DETAILS = "/report/jira/createstory";

    @Inject
    private PeaceService peaceService;

    @Inject
    private WebhookResponseBuilder webhookResponseBuilder;

    @PostMapping(URL_GET_JIRA_REPORT)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<WebhookResponse> getOpenDefect(
                    @RequestBody WebhookRequest webhookRequest) {
        LOGGER.info("Server has received a request: {}", webhookRequest);

        Map<String, String> requestedInputParams = webhookRequest.getQueryResult().getOutputContexts()[0].getParameters();
        LOGGER.info("Requested input param is: {}", requestedInputParams);

        String outputMessage = peaceService.getOpenDefects(requestedInputParams);

        WebhookResponse response = webhookResponseBuilder.buildWebhookResponse(outputMessage);

        LOGGER.info("Sending response after processing the webhook request");
        return ResponseEntity.accepted().body(response);

    }

    @PostMapping(URL_CREATE_STORY_DETAILS)
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public ResponseEntity<WebhookResponse> getDefectDetails(
                    @RequestBody WebhookRequest webhookRequest) {
        LOGGER.info("Server has received a request: {}", webhookRequest);

        Map<String, String> requestedInputParams = webhookRequest.getQueryResult().getOutputContexts()[0].getParameters();
        LOGGER.info("Requested input param is: {}", requestedInputParams);

        String outputMessage = peaceService.createIssue(requestedInputParams);

        WebhookResponse response = webhookResponseBuilder.buildWebhookResponse(outputMessage);

        LOGGER.info("Sending response after processing the webhook request");
        return ResponseEntity.accepted().body(response);

    }
}
