import models.DocumentState;

import javax.annotation.Nullable;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public interface GetDocumentCallback {

    void onSuccess(DocumentState documentState);
    void onRequestFailure(Throwable throwable);

}
