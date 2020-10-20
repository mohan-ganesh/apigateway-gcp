Build the application


```
gcloud config set PROJECT_ID <your-project-id>
export PROJECT_ID=<your-gcp-projectid>
```
Build the application

```
gcloud builds submit --tag gcr.io/$PROJECT_ID/apigateway-cloudrun

```

Enable the cloud run service
```
gcloud services enable run.googleapis.com
```

Deploy the application 

```
gcloud run deploy --image gcr.io/$PROJECT_ID/apigateway-cloudrun --platform managed --region us-central1 --no-allow-unauthenticated
```

To list the service accounts

```
gcloud iam service-accounts list
```
Cloud Run product docs
```
https://cloud.google.com/sdk/gcloud/reference/run/deploy

```