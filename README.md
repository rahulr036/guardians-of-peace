# guardians-of-peace

guardians-of-peace is a Spring Boot application to integrate Jira with the Google Voice.

# Steps to run the project:
Softwares and Tools required are:
*Google console account
*Java 8
*Access to the internet to download the required spring boot and other required jars from maven repository
*IntelliJ Idea
*Terminal (or equivalent) console to run the application
*Google chrome or any browser to test the REST API
*Google mini or equivalent hardware to run the application end to end
*Ngrok (a web tunneling tool or equivalent application). This will not require if this microservice is deployed to a host
*URL of Jira to fetch the data
*User id and API Token for Jira access

1. Start this microserviceto access the Custom API. This will start on internal tomcat port 8080. 
2. Run the command - "ngrok http 8080" on command line terminal to start the ngrok
3. Login to Google Dialogflow
4. Click Fulfilment on the left hand side
5. Update the URL prefix with the ngrok generated URL prefix and save the page
6. Click on the Integration to run the application on Google Mini Simulator 


