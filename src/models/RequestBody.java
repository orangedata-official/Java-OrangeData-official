package models;

import com.google.gson.annotations.SerializedName;
import com.sun.istack.internal.Nullable;
import constants.DocumentType;
import constants.PaymentType;
import constants.Tax;
import constants.TaxationSystem;
import retrofit2.Call;
import retrofit2.http.*;

import java.util.ArrayList;

/**
 * Created by Alexey Padyukov on 19.06.2017.
 */
public class RequestBody {

    //Строка от 1 до 32 символов
    @SerializedName("Id")
    private String id;
    //Строка 12 символов
    @SerializedName("INN")
    private String inn;
    //Строка от 1 до 32 символов или null
    @SerializedName("Group")
    @Nullable private String group;
    //Структура Document
    @SerializedName("Content")
    private Document content;

    public RequestBody(String id, String inn) {
        this.id = id;
        this.inn = inn;
    }

    public RequestBody(String id, String inn, String group, Document content) {
        this.id = id;
        this.inn = inn;
        this.group = group;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public String getInn() {
        return inn;
    }

    public String getGroup() {
        return group;
    }

    public Document getContent() {
        return content;
    }

    public interface RequestService {
        @Headers("Content-Type: application/json; charset=utf-8")
        @POST("/api/v2/documents/")
        Call<PostResponse> postDocument(@Header("X-Signature") String signature, @Body RequestBody requestBody);
        @GET("/api/v2/documents/{inn}/status/{document_id}")
        Call<DocumentState> getDocumentState(@Path("inn") String inn, @Path("document_id") String documentId);
    }

    public static RequestBody getDummy() {
        Bill bill = new Bill(1.23, 23.3, Tax.NDS_0, "sample");
        ArrayList<Bill> billArrayList = new ArrayList<>();
        billArrayList.add(bill);
        Payment payment = new Payment(PaymentType.CARD_VISA, 1.0);
        ArrayList<Payment> paymentArrayList = new ArrayList<>();
        paymentArrayList.add(payment);
        return new RequestBody("newId", "5001104058", null, new Document(
                DocumentType.INCOME, billArrayList, new CheckClose(paymentArrayList, TaxationSystem.USN_INCOME), "+79152254895"
        ));
    }

//    public static RequestBody getDummy1() {
//        return new RequestBody("newId");
//    }

}