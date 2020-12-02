package ru.orangedata.example;


import ru.orangedata.orangelib.CorrectionRequest;
import ru.orangedata.orangelib.DocumentRequest;
import ru.orangedata.orangelib.GetDocumentCallback;
import ru.orangedata.orangelib.PostCallback;
import ru.orangedata.orangelib.constants.*;
import ru.orangedata.orangelib.models.correction.CorrectionDocument;
import ru.orangedata.orangelib.models.correction.CorrectionRequestBody;
import ru.orangedata.orangelib.models.document.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.util.Collections;

public class Main {

    private static String INN = "5001104058";
    private static String DOC_ID = "newId2";
    private static String DOC_ID2 = "newId3";
    private static String RSA_PRICATE_KEY_PATH = "..\\testKeys\\private_key.pem";

    public static void main(String[] args) {
        //«акоментированы методы отправки документов, чтобы на загружались лишние документы

        //postData();
        getData();

        // postCorrection();
        getCorrection();
    }

    private static void postData() {
        try {
            DocumentRequest orangeRequest = new DocumentRequest();
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

        DocumentRequest orangeRequest = new DocumentRequest();
        orangeRequest.getDocument(DOC_ID, INN, new GetDocumentCallback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Success! " + result);
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
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
            CorrectionRequest orangeRequest = new CorrectionRequest();
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

    private static void getCorrection(){
        CorrectionRequest orangeRequest = new CorrectionRequest();
        orangeRequest.getCorrection(DOC_ID2, INN, new GetDocumentCallback() {
            @Override
            public void onSuccess(String result) {
                System.out.println("Success! " + result);
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });
    }

    private static CorrectionRequestBody getDummyCorrection(){
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
