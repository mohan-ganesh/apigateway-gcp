Enable the required services

```
gcloud services enable apigateway.googleapis.com
gcloud services enable servicemanagemnet.googleapis.com
gcloud services enable servicecontrol.googleapis.com
```

Create API Config

```
gcloud beta api-gateway api-configs create open-api-config-v1 \
 --api=cloudrun-api --openapi-spec=openapi-spec.yaml \
 --project=$PROJECT_ID --backend-auth-service-account=570047578034-compute@developer.gserviceaccount.com
```

Create Gateway Config

```
gcloud beta api-gateway gateways create open-api-gateway-v1 \
 --api=cloudrun-api --api-config=open-api-config-v1 \
 --location=us-central1 --project=$PROJECT_ID
```

Update Gateway Config

```
gcloud beta api-gateway gateways update open-api-gateway-v1 \
 --api=cloudrun-api --api-config=open-api-config-v1 \
 --location=us-central1 --project=$PROJECT_ID
```
