# Spring Boot Application Google App Engine Standard with Java 11

This sample shows how to deploy a [Spring Boot](https://spring.io/projects/spring-boot)
application to Google App Engine stadndard (java 11) .


```
gcloud config set PROJECT_ID <your-project-id>
export PROJECT_ID=<your-gcp-projectid>
```

##PreReqisite


## Setup

enable IAM Service Account Credentials API
```
gcloud services enable iamcredentials.googleapis.com
```



## Deploying

```
gcloud app deploy
```

To view your app, use command:
```
gcloud app browse
```
Or navigate to `https://<your-project-id>.appspot.com`.

To list the service accounts 
```
gcloud iam service-accounts list
```
Add Role to an account
```
gcloud projects add-iam-policy-binding PROJECT_ID \
    --member="serviceAccount:SERVICE_ACCOUNT_ID@PROJECT_ID.iam.gserviceaccount.com" \
    --role="ROLE_NAME"

```

Add Token Creator to appspot service account

```
gcloud projects add-iam-policy-binding $PROJECT_ID \
    --member="serviceAccount:<account-name>@appspot.gserviceaccount.com" \
    --role="roles/iam.serviceAccountTokenCreator"

```



```
gcloud iam service-accounts enable sa-name@project-id.iam.gserviceaccount.com
```


```
gcloud projects add-iam-policy-binding my-project \
    --member=user:my-user@example.com --role=roles/viewer
```



https://firebase.google.com/docs/auth/admin/create-custom-tokens#troubleshooting

https://identitytoolkit.googleapis.com/v1/accounts:signInWithCustomToken?key=<web-api-key>