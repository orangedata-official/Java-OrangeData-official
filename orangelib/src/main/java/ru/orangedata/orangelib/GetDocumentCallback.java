package ru.orangedata.orangelib;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public interface GetDocumentCallback {

    void onSuccess(String documentState);

    void onRequestFailure(Throwable throwable);

}
