import org.jetbrains.annotations.Nullable;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public interface PostBillCallback {

    void onValidationErrors(@Nullable String[] errors);
    void onSuccess();
    void onRequestFailure(Throwable throwable);

}
