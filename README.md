# guardians-of-peace

guardians-of-peace is a Spring Boot application to integrate Jira with the Google Voice.

## Softwares and Tools required are:
* Google console account
* Java 8
* Access to the internet to download the required spring boot and other required jars from maven repository
* IntelliJ Idea
* Terminal (or equivalent) console to run the application
* Google chrome or any browser to test the REST API
* Google mini or equivalent hardware to run the application end to end
* Ngrok (a web tunneling tool or equivalent application). This will not require if this microservice is deployed to a host
* URL of Jira to fetch the data
* User id and API Token for Jira access

## Setup Instructions
1. Start this microserviceto access the Custom API. This will start on internal tomcat port 8080. 
2. Run the command - "ngrok http 8080" on command line terminal to start the ngrok
3. Login to Google Dialogflow
4. Click Fulfilment on the left hand side
5. Update the URL prefix with the ngrok generated URL prefix and save the page
6. Click on the Integration to run the application on Google Mini Simulator

### Fulfillment
All intents for guardians of peace are located at https://dialogflow.cloud.google.com/#/agent/c2a08212-e30a-45f6-b52b-ae79144e715c/fulfillment
As of now this is going to support below listed intents:
1. create a story under Jira
2. Fetch number of outstanding defects for a release
3. Update a comment under a defect/story

### Action configuration
1. Use the Actions on Google Console to add a new project with a name of your choosing and click Create Project.
2. Click Home Control, then click hacker-app.
3. From the top menu under Develop, click on Invocation (left nav).
4. Add your App's name. Click Save.

Optio1nally, you can add directory information as well:

1. From the top menu under Deploy, click on Directory Information (left nav).
2. Add your App info, including images, a contact email and privacy policy. This information can all be edited before submitting for review.
3. Click Save.

### Credentials

To fully utilize the functionality you need to configure the Jira URL and credentials under the application.properties file

### Start testing

1. Run the Spring boot microservice guardians-of-peace
2. Run the ngrok on http port 8080
3. Copy the generated URL
4. Navigate back to the Actions on Google Console.
5. From the top menu under Develop, click on Actions (left nav). Click on Add your first action and choose your app's language(s).
6. Enter the URL for fulfillment, e.g. https://dialogflow.cloud.google.com/#/agent/c2a08212-e30a-45f6-b52b-ae79144e715c/fulfillment, click Done.
7. From the top menu under Develop, click on Account Linking (left nav).
8. Launch the dialogflow
9. Navigate to Fulfillment
10. Update the URL prefix to newly generated URL using ngrok
11. Click on save
12. Navigate to Integration and run the application

### Webhook
When a new project is created using the Actions Console, it also creates a Google Cloud project in the background.
Copy the name of this project from the Action Console project settings page.

### References & Issues
1. Ways to implement: https://tutorials.botsfloor.com/dialogflow-fulfillment-webhook-tutorial-7cf4ceba0e5e
2. Questions: https://stackoverflow.com/questions/tagged/actions-on-google
3. API Reference: https://cloud.google.com/dialogflow/docs/reference/rest/v2beta1-overview
4. Jira reference: https://developer.atlassian.com/cloud/jira/software/rest/