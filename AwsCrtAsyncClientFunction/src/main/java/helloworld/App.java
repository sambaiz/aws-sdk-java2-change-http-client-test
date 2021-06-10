package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3AsyncClient;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;
import software.amazon.awssdk.services.s3.model.ListObjectsResponse;

public class App implements RequestHandler<Object, String> {

    public String handleRequest(final Object input, final Context context) {
        S3AsyncClient s3Async = S3AsyncClient
                .builder()
                .region(Region.US_EAST_1)
                .build();
        ListObjectsRequest listObjects = ListObjectsRequest
                .builder()
                .bucket("hogefuga")
                .build();
        s3Async.listObjects(listObjects);
        return "ok";
    }
}