package helloworld;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import software.amazon.awssdk.regions.Region;
import software.amazon.awssdk.services.s3.S3Client;
import software.amazon.awssdk.services.s3.model.ListObjectsRequest;

public class App implements RequestHandler<Object, String> {

    public String handleRequest(final Object input, final Context context) {
        S3Client s3 = S3Client
                .builder()
                .region(Region.US_EAST_1)
                .build();
        ListObjectsRequest listObjects = ListObjectsRequest
                .builder()
                .bucket("hogefuga")
                .build();
        s3.listObjects(listObjects);
        return "ok";
    }
}
