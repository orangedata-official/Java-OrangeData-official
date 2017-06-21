import com.sun.istack.internal.Nullable;
import constants.DocumentType;
import constants.PaymentType;
import constants.Tax;
import constants.TaxationSystem;
import models.*;

import java.io.IOException;
import java.util.Collections;

public class Main {


    public static void main(String[] args) {

//        postData();
        getData();
    }

    private static void getData() {

        OrangeRequest orangeRequest = new OrangeRequest();
        orangeRequest.getDocument("newId1", "5001104058", new GetDocumentCallback() {
            @Override
            public void onSuccess(DocumentState documentState) {
                System.out.println("Success! " + documentState.getCompanyName());
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println(throwable.getMessage());
            }
        });

    }

    private static void postData() {
        try {
            OrangeRequest orangeRequest = new OrangeRequest();
            orangeRequest.postDocument(getDummy(), "D:/Orange/API/private_key.der", new PostBillCallback() {
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

    private static RequestBody getDummy() {

        Bill dummyBill = new Bill(
                1.0,
                1.0,
                Tax.NONE,
                "Dummy text");
        Payment dummyPayment = new Payment(
                PaymentType.CARD_VISA,
                1.0
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

        return new RequestBody(
                "newId1",
                "5001104058",
                null,
                dummyDocument
        );
    }
}
