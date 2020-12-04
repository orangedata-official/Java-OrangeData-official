package ru.orangedata.orangelib;

import ru.orangedata.orangelib.network.exception.OrangeException;

public interface GetDocumentCallback {

    void onSuccess(String documentState);

    void onRequestFailure(OrangeException exception);

}
