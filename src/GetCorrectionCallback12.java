import models.CorrectionState;
import models.CorrectionState12;

public interface GetCorrectionCallback12 {
    void onSuccess(CorrectionState12 documentState);
    void onRequestFailure(Throwable throwable);
}
