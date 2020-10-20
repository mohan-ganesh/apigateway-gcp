```
gcloud config set project <your-project-id>
export PROJECT_ID=<your-project-id>
```

Build  function

```
mvn compile
```

Test the Function
```
mvn function:run
```

Deploy the function

```
gcloud functions deploy cf-http-function --entry-point com.apigateway.cloudfunctions.CFHttpFunction --runtime java11 --trigger-http --memory 512MB --allow-unauthenticated
```

Access the Cloud Function

```
https://GCP_REGION-PROJECT_ID.cloudfunctions.net/cf-http-function

```
