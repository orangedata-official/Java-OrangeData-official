package ru.orangedata.orangelib;

import javax.annotation.Nullable;

public interface PostCallback {

    void onValidationErrors(@Nullable String[] errors);

    void onSuccess();

    void onRequestFailure(Throwable throwable);

}
