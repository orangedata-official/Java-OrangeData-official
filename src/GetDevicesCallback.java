import models.DocumentState;
import models.RespKKTDevicesStatus;

public interface GetDevicesCallback {
    void onSuccess(RespKKTDevicesStatus documentState);
    void onRequestFailure(Throwable throwable);
}
