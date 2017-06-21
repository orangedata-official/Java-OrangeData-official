import models.DocumentState;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public interface GetDocumentCallback {

    void onSuccess(DocumentState documentState);
    void onRequestFailure(Throwable throwable);

}
