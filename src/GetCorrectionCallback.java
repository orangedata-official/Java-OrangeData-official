import models.CorrectionState;
import models.DocumentState;

public interface GetCorrectionCallback {
    void onSuccess(CorrectionState documentState);
    void onRequestFailure(Throwable throwable);
}
