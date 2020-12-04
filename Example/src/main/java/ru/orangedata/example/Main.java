package ru.orangedata.example;


import ru.orangedata.orangelib.CorrectionRequest;
import ru.orangedata.orangelib.DocumentRequest;
import ru.orangedata.orangelib.GetDocumentCallback;
import ru.orangedata.orangelib.PostCallback;
import ru.orangedata.orangelib.models.constants.*;
import ru.orangedata.orangelib.models.correction.CorrectionDocument;
import ru.orangedata.orangelib.models.correction.CorrectionRequestBody;
import ru.orangedata.orangelib.models.document.*;
import ru.orangedata.orangelib.network.exception.OrangeException;

import javax.annotation.Nullable;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Collections;

public class Main {

    private static final String INN = "5001104058";
    private static final String DOC_ID = "newId2";
    private static final String DOC_ID2 = "newId6";
    private static final String RSA_PRICATE_KEY_PATH = Paths.get(".").toAbsolutePath() + "\\testKeys\\private_key.pem";

    private static final String TEST_ENDPOINT = "https://apip.orangedata.ru:2443";

    public static void main(String[] args) {
        //Закоментированы методы отправки документов, чтобы на загружались лишние документы

        //  postData();
        getData();

        //  postCorrection();
        getCorrection();
    }

    private static void postData() {
        try {
            DocumentRequest orangeRequest = new DocumentRequest(TEST_ENDPOINT);
            orangeRequest.postDocument(getDummyDocument(), RSA_PRICATE_KEY_PATH, new PostCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("onSuccess");
                }

                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("postResponse is null");
                    }
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("onRequestFailure " + throwable.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getData() {

        DocumentRequest orangeRequest = new DocumentRequest(TEST_ENDPOINT);
        orangeRequest.getDocument(DOC_ID, INN, new GetDocumentCallback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Success! " + result);
            }

            @Override
            public void onRequestFailure(OrangeException orangeException) {
                System.out.println(orangeException.getMessage());
            }
        });

    }

    private static DocumentRequestBody getDummyDocument() {

        Bill dummyBill = new Bill(
                1.000,
                1.00,
                Tax.NONE,
                "Dummy text");
        Payment dummyPayment = new Payment(
                PaymentType.CARD_VISA,
                1.00
        );
        CheckClose dummyCheckClose = new CheckClose(
                Collections.singletonList(dummyPayment),
                TaxationSystem.USN_INCOME
        );
        Document dummyDocument = new Document(
                DocumentType.INCOME,
                Collections.singletonList(dummyBill),
                dummyCheckClose,
                "Dummy customer contact"
        );

        return new DocumentRequestBody(
                DOC_ID,
                INN,
                null,
                dummyDocument,
                INN,
                null
        );
    }

    private static void postCorrection() {
        try {
            CorrectionRequest orangeRequest = new CorrectionRequest(TEST_ENDPOINT);
            orangeRequest.postCorrection(getDummyCorrection(), RSA_PRICATE_KEY_PATH, new PostCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("onSuccess");
                }

                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("postResponse is null");
                    }
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("onRequestFailure " + throwable.getMessage());
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void getCorrection() {
        CorrectionRequest orangeRequest = new CorrectionRequest(TEST_ENDPOINT);
        orangeRequest.getCorrection(DOC_ID2, INN, new GetDocumentCallback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Success! " + result);
            }

            @Override
            public void onRequestFailure(OrangeException orangeException) {
                System.out.println(orangeException.getMessage());
            }
        });
    }

    private static CorrectionRequestBody getDummyCorrection() {
        CorrectionDocument dummyDocument = new CorrectionDocument(
                CorrectionType.INDEPENDENT,
                DocumentType.INCOME,
                "2020-12-02 00:00:00",
                "1",
                10.00,
                10.00,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null,
                null
        );

        return new CorrectionRequestBody(
                DOC_ID2,
                INN,
                null,
                dummyDocument,
                INN,
                null
        );
    }

}
