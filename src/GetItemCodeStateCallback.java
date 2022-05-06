import models.RespItemCodeStatus;
import models.RespKKTDevicesStatus;

public interface GetItemCodeStateCallback {
    void onSuccess(RespItemCodeStatus documentState);
    void onRequestFailure(Throwable throwable);
}
