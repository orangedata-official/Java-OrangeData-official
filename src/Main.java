import constants.DocumentType;
import constants.PaymentType;
import constants.Tax;
import constants.TaxationSystem;
import models.*;

import javax.annotation.Nullable;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Collections;

public class Main {

    private static Bill dummyBill = new Bill(
            1.0,
            1.0,
            Tax.NONE,
            "Dummy text");
    private static Payment dummyPayment = new Payment(
            PaymentType.CARD_VISA,
            1.0
    );
    private static CheckClose dummyCheckClose = new CheckClose(
            Collections.singletonList(dummyPayment),
            TaxationSystem.USN_INCOME
    );
    private static Document dummyDocument = new Document(
            DocumentType.INCOME,
            Collections.singletonList(dummyBill),
            dummyCheckClose,
            "Dummy customer contact"
    );

    public static void main(String[] args) {
        RequestBody dummyRequestBody = new RequestBody(
                "newId",
                "5001104058",
                null,
                dummyDocument
        );
//        RequestBody requestBody = new RequestBody("45eg9uw23KLL", "5001104058");
        try {
            OrangeRequest orangeRequest = new OrangeRequest();
            orangeRequest.post(dummyRequestBody, new PostBillCallback() {
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
                    System.out.println("onRequestFailure");
                }
            });
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (SignatureException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        }
    }
}
