package ru.orangedata.orangelib;

import javax.annotation.Nullable;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public interface PostCallback {

    void onValidationErrors(@Nullable String[] errors);
    void onSuccess();
    void onRequestFailure(Throwable throwable);

}
