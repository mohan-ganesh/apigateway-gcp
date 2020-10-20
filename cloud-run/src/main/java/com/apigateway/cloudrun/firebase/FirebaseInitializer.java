package com.apigateway.cloudrun.firebase;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.cloud.firestore.Firestore;
import com.google.cloud.firestore.FirestoreOptions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

@Service
public class FirebaseInitializer {

    private static final Logger logger = LoggerFactory.getLogger(FirebaseInitializer.class);

    @Bean
    @PostConstruct
    public  Firestore initilize() throws IOException {
        //String projectId  = System.getenv("GOOGLE_CLOUD_PROJECT");

        String  projectId = getProjectId();

        // Use the application default credentials
        FirestoreOptions firestoreOptions =
                FirestoreOptions.getDefaultInstance().toBuilder()
                        .setProjectId(projectId)
                        .setCredentials(GoogleCredentials.getApplicationDefault())
                        .build();
        Firestore db = firestoreOptions.getService();

        return db;

    }

    /**
     * Get the Project Id from GCP metadata server
     *
     * @return GCP Project Id or null
     */
    private  String getProjectId() {
        OkHttpClient ok =
                new OkHttpClient.Builder()
                        .readTimeout(500, TimeUnit.MILLISECONDS)
                        .writeTimeout(500, TimeUnit.MILLISECONDS)
                        .build();

        String metadataUrl = "http://metadata.google.internal/computeMetadata/v1/project/project-id";
        Request request =
                new Request.Builder().url(metadataUrl).addHeader("Metadata-Flavor", "Google").get().build();

        String project = null;
        try {
            Response response = ok.newCall(request).execute();
            project = response.body().string();
        } catch (IOException e) {
            logger.error("Error retrieving Project Id");
        }
        return project;
    }
}