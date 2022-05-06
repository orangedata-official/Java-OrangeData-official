import constants.*;
import org.jetbrains.annotations.Nullable;
import models.*;

import javax.swing.text.Position;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.logging.Handler;


public class Main {

    public static void main(String[] args) {

        //postData();
        //getData();
        OrangeRequest orangeRequest = new OrangeRequest();

        try {
            System.out.println("Start get access check");
            orangeRequest.getAccessState(new ReqAccessStatus("7725327863", "Main_2", "7725327863"), "C:\\Development\\Aqsi\\OrangeData\\files\\files_for_test\\private_key_test.xml", new PostBillCallback() {
                        @Override
                        public void onSuccess() {
                            System.out.println("Access check onSuccess");
                            createCheck(orangeRequest);
                        }

                        @Override
                        public void onValidationErrors(@Nullable String[] errors) {
                            if (errors != null) {
                                for (String error : errors) {
                                    System.out.println("Access check onValidationErrors: " + error);
                                }
                            } else {
                                System.out.println("Access check postResponse is null");
                            }
                            createCheck(orangeRequest);
                        }

                        @Override
                        public void onRequestFailure(Throwable throwable) {
                            System.out.println("Access check onRequestFailure: " + throwable.getMessage());
                            createCheck(orangeRequest);
                        }
                    });


        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

    public static void createCheck(OrangeRequest orangeRequest)  {
        try {
            System.out.println("FFD 1.05 start creating document");
            orangeRequest.postDocument(getDummy(), "C:\\Development\\Aqsi\\OrangeData\\files\\files_for_test\\private_key_test.xml", new PostBillCallback() {
                @Override
                public void onSuccess() {
                    System.out.println("FFD 1.05 create document onSuccess");
                    getCheck(orangeRequest);
                }

                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("FFD 1.05 create document onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("FFD 1.05 create document postResponse is null");
                    }
                    getCheck(orangeRequest);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("FFD 1.05 create document onRequestFailure: " + throwable.getMessage());
                    getCheck(orangeRequest);
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
            getCheck(orangeRequest);
        }
    }

    private static void getCheck(OrangeRequest orangeRequest){
        System.out.println("FFD 1.05 start getting document status");
        orangeRequest.getDocument("11223346", "7725327863", new GetDocumentCallback() {
            @Override
            public void onSuccess(DocumentState documentState) {
                System.out.println("FFD 1.05 document status Success! Company INN: " + documentState.getCompanyINN());
                creteCorrection(orangeRequest);
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println("FFD 1.05 document status onRequestFailure: " + throwable.getMessage());
                creteCorrection(orangeRequest);
            }
        });
    }

    private static void creteCorrection(OrangeRequest orangeRequest){
        try{
            System.out.println("FFD 1.05 start creating correction");
            orangeRequest.postCorrection(getCorrection(), "C:\\Development\\Aqsi\\OrangeData\\files\\files_for_test\\private_key_test.xml", new PostBillCallback() {
                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("FFD 1.05 create correction onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("FFD 1.05 create correction postResponse is null");
                    }
                    getCorrectionState(orangeRequest);
                }

                @Override
                public void onSuccess() {
                    System.out.println("FFD 1.05 create correction onSuccess");
                    getCorrectionState(orangeRequest);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("FFD 1.05 create correction onRequestFailure: " + throwable.getMessage());
                    getCorrectionState(orangeRequest);
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
            getCorrectionState(orangeRequest);
        }
    }

    private static void getCorrectionState(OrangeRequest orangeRequest){
        System.out.println("FFD 1.05 start getting correction status");
        orangeRequest.getCorrectionState("1122334415","7725327863", new GetCorrectionCallback() {
            @Override
            public void onSuccess(CorrectionState documentState) {
                System.out.println("FFD 1.05 correction status Success! Id: " +  documentState.id);
                createCheck12(orangeRequest);
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println("FFD 1.05 correction status onRequestFailure: " +throwable.getMessage());
                createCheck12(orangeRequest);
            }
        });
    }

    private static void createCheck12(OrangeRequest orangeRequest){
        try{
            System.out.println("FFD 1.2 start creating document");
            orangeRequest.postDocument(getDummy12(), "C:\\Development\\Aqsi\\OrangeData\\files\\files_for_test\\private_key_test.xml", new PostBillCallback() {
                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("FFD 1.2 create document onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("FFD 1.2 create document postResponse is null");
                    }
                    getCheck12(orangeRequest);
                }

                @Override
                public void onSuccess() {
                    System.out.println("FFD 1.2 create document onSuccess");
                    getCheck12(orangeRequest);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("FFD 1.2 create document onRequestFailure: " + throwable.getMessage());
                    getCheck12(orangeRequest);
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
            getCheck12(orangeRequest);
        }
    }

    private static void getCheck12(OrangeRequest orangeRequest){
        System.out.println("FFD 1.2 start getting document status");
        orangeRequest.getDocument("1122334512", "7725327863", new GetDocumentCallback() {
            @Override
            public void onSuccess(DocumentState documentState) {
                System.out.println("FFD 1.2 document status Success! Company Name: " + documentState.getCompanyName());
                createCorrection12(orangeRequest);
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println("FFD 1.2 document status onRequestFailure: " +throwable.getMessage());
                createCorrection12(orangeRequest);
            }
        });
    }

    private static void createCorrection12(OrangeRequest orangeRequest){
        try{
            System.out.println("FFD 1.2 start creating correction");
            orangeRequest.postCorrection12(getCorrection12(), "C:\\Development\\Aqsi\\OrangeData\\files\\files_for_test\\private_key_test.xml", new PostBillCallback() {
                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("FFD 1.2 create correction onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("FFD 1.2 create correction postResponse is null");
                    }
                    getCorrectionState12(orangeRequest);
                }

                @Override
                public void onSuccess() {
                    System.out.println("FFD 1.2 create correction onSuccess");
                    getCorrectionState12(orangeRequest);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("FFD 1.2 create correction onRequestFailure: " + throwable.getMessage());
                    getCorrectionState12(orangeRequest);
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
            getCorrectionState12(orangeRequest);
        }
    }

    private static void getCorrectionState12(OrangeRequest orangeRequest){
        System.out.println("FFD 1.2 start getting correction status");
        orangeRequest.getCorrectionState12("11223345121","7725327863", new GetCorrectionCallback12() {
            @Override
            public void onSuccess(CorrectionState12 documentState) {
                System.out.println("FFD 1.2 correction status Success! Id: " +  documentState.id);
                getKKTDeviceState(orangeRequest);
            }

            @Override
            public void onRequestFailure(Throwable throwable) {
                System.out.println("FFD 1.2 correction status onRequestFailure: " +throwable.getMessage());
                getKKTDeviceState(orangeRequest);
            }
        });
    }

    private static void getKKTDeviceState(OrangeRequest orangeRequest){
        try{
            System.out.println("Start getting KKT Devices Status status");
            orangeRequest.getKKTDeviceState("7725327863", "Main_2", new GetDevicesCallback() {
                @Override
                public void onSuccess(RespKKTDevicesStatus documentState) {
                    System.out.println("KKTDevicesState status Success! ");
                    if(documentState.devices!=null && documentState.devices.length>0){
                        for(DeviceInfo deviceInfo: documentState.devices){
                            System.out.println("Device SN: "+deviceInfo.deviceSN);
                        }
                    }
                    createItemcodeCheck(orangeRequest);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("KKTDevicesState onRequestFailure: " + throwable.getMessage());
                    createItemcodeCheck(orangeRequest);
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
            createItemcodeCheck(orangeRequest);
        }
    }

    private static void createItemcodeCheck(OrangeRequest orangeRequest){
        try{
            System.out.println("Start creating ItemCode check");
            orangeRequest.postItemCodeCheck(new ReqItemCodeCheck("1122334526",
                    "7725327863",
                    "Main_2",
                    new ItemCodeContent((byte)1,
                            "00000046210654eK7fYtcAAModGVz",
                            null,
                            null,
                            null),
                    "7725327863",
                    null,
                    null),"C:\\Development\\Aqsi\\OrangeData\\files\\files_for_test\\private_key_test.xml", new PostBillCallback() {
                @Override
                public void onValidationErrors(@Nullable String[] errors) {
                    if (errors != null) {
                        for (String error : errors) {
                            System.out.println("Create Itemcode onValidationErrors: " + error);
                        }
                    } else {
                        System.out.println("Create Itemcode postResponse is null");
                    }
                    getItemCodeState(orangeRequest);
                }

                @Override
                public void onSuccess() {
                    System.out.println("Create Itemcode onSuccess");
                    getItemCodeState(orangeRequest);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("Create Itemcode onRequestFailure: " + throwable.getMessage());
                    getItemCodeState(orangeRequest);
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
            getItemCodeState(orangeRequest);
        }
    }

    private static void getItemCodeState(OrangeRequest orangeRequest){
        try{
            System.out.println("Start getting ItemCode status");
            orangeRequest.getItemCodeState("7725327863", "1122334526", new GetItemCodeStateCallback() {
                @Override
                public void onSuccess(RespItemCodeStatus documentState) {
                    System.out.println("Get Itemcode status onSuccess. Id: "+documentState.Id+
                            ", DeviceSN: "+documentState.DeviceSN);
                }

                @Override
                public void onRequestFailure(Throwable throwable) {
                    System.out.println("Get Itemcode status onRequestFailure: " + throwable.getMessage());
                }
            });
        }catch (Exception ee){
            ee.printStackTrace();
        }
    }

    private static RequestBody getDummy() {

        return new RequestBody(
                "11223347",
                "7725327863",
                null,
                new Document(FfdVersionType.Ffd105,
                        DocumentType.INCOME,
                        Arrays.asList(new Bill(1.0,123.45,Tax.NONE,"Булка",PaymentMethodType.Full,
                                PaymentSubjectType.Product,null,null,
                                null,null,null,null,null,null,
                                null,null,null,null,
                                null,null,null,
                                null,null,null),
                                new Bill(2.0,4.45,Tax.RASCH_10_110,"Спички",PaymentMethodType.Full,
                                        PaymentSubjectType.Product,null,null,
                                        null,null,null,null,null,null,
                                        null,null,null,null,
                                        null,null,null,
                                        null,null,null)),
                        new CheckClose(Collections.singletonList(new Payment(PaymentType.CASH,132.35)),
                                TaxationSystem.USN_INCOME),
                        "foo@example.com",
                        AgentType.PayingAgent,
                        null,null,
                        null,null,
                        null,null,null,null,
                        null,null,null,
                        null,null,null,
                        null,null,null,null,null,
                        132.35,
                        null,null,null,null,null,null,
                        null,null),
                null,null,null,null);
    }

    private static RequestBody getDummy12() {

        return new RequestBody(
                "1122334513",
                "7725327863",
                "Main_2",
                new Document(FfdVersionType.Ffd12,
                        DocumentType.INCOME,
                        Arrays.asList(new Bill(1.0,123.45,Tax.NONE,"Булка",PaymentMethodType.Full,
                                        PaymentSubjectType.Product,null,
                                        "010460406000600021N4N57RSCBUZTQ\u001d2403004002910161218\u001d1724010191ffd0\u001d92tIAF/YVoU4roQS3M/m4z78yFq0fc/WsSmLeX5QkF/YVWwy8IMYAeiQ91Xa2z/fFSJcOkb2N+uUUmfr4n0mOX0Q==",
                                        (byte)2,
                                        null,null,AgentType.Other,
                                        new AgentInfo(Arrays.asList("+79200000001", "+74997870001"),
                                                "Какая-то операция 1",
                                                Collections.singletonList("+79200000003"),
                                                Arrays.asList("+79200000002", "+74997870002"),
                                                "ООО\"Атлант\"",
                                                "Воронеж,ул.Недогонная,д.84",
                                                "7727257386"),
                                        null,
                                        null,
                                        "Доп.атрибут и все тут",
                                        "643",
                                        "АД 11/77 от 01.08.2018",
                                        23.45,null,0.23,
                                        new HashMap<String,Long>(){{put("numerator", 1L);put("denominator", 2L);}},
                                        new HashMap<String,String>(){{
                                            put("foivId", "012");
                                            put( "causeDocumentDate", "12.08.2021");
                                            put( "causeDocumentNumber", "666");
                                            put( "value", "position industry");
                                        }},
                                        new HashMap<String,String>(){{
                                            put("ean8", "46198532");
                                            put( "ean13", "4006670128002");
                                            put( "itf14", "14601234567890");
                                            put( "gs1", "010460043993125621JgXJ5.T");
                                            put("mi", "RU-401301-AAA0277031");
                                            put( "egais20", "NU5DBKYDOT17ID980726019");
                                            put( "egais30", "13622200005881");
                                            put( "f1", null);
                                            put("f2", null);
                                            put( "f3", null);
                                            put( "f4", null);
                                            put( "f5", null);
                                            put( "f6", null);
                                        }}),
                                new Bill(2.0,4.45,Tax.RASCH_10_110,"Спички",PaymentMethodType.Advance,
                                        PaymentSubjectType.Other,null,null,
                                        null,
                                        new SupplierInfo(Arrays.asList("+79266660011", "+79266660022"),"ПАО \"Адамас\""),
                                        "9715225506",
                                        null,null,null,
                                        (byte)10,null,null,null,
                                        null,null,null,
                                        null,null,null)),
                        new CheckClose(Arrays.asList(
                                    new Payment(PaymentType.CASH,123.45),
                                    new Payment(PaymentType.Emoney,8.90000)),
                                TaxationSystem.USN_INCOME),
                        "foo@example.com",
                        null,
                        null,null,
                        null,null,
                        null,null,null,null,
                        new HashMap<String,String>(){{
                            put("name", "Любимая цитата");
                            put( "value", "В здоровом теле здоровый дух, этот лозунг еще не потух!");
                        }},
                        "Доп атрибут чека",
                        null,
                        null,null,null,
                        null,
                        new HashMap<String,String>(){{
                            put("name", "Кузнецов Иван Петрович");
                            put( "inn", "7725327863");
                            put("birthDate", "15.09.1988");
                            put( "citizenship", "643");
                            put("identityDocumentCode", "01");
                            put( "identityDocumentData", "multipassport");
                            put( "address", "Басеенная 36");
                        }},
                        "Кассир",
                        null,
                        "ru@example.mail",
                        132.35,
                        null,null,null,null,null,null,
                        new OperationalAttribute("2021-08-12T18:36:16",(byte)0,"operational"),
                        new HashMap<String,String>(){{
                            put("foivId", "010");
                            put( "causeDocumentDate", "11.08.2021");
                            put("causeDocumentNumber", "999");
                            put( "value", "industry");
                        }}),
                "7725327863",
                "http://call.back/?doc=2","some meta",false);
    }
    private static ReqCreateCorrectionBody getCorrection() {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'00:00:00'Z'");
        return new ReqCreateCorrectionBody(
                "1122334416",
                "7725327863",
                null,
                new CorrectionContent(null,
                    DocumentType.INCOME,
                    sdf.format(new Date()),
                    "11223344",
                    null,
                    2000d,
                    null,null,null,null,
                    null,null,null,2000d,null,null,TaxationSystem.OSN
                    ),
                null,null);
    }
    private static ReqCreateCorrectionBody12 getCorrection12() {
        return new ReqCreateCorrectionBody12(
                "11223345122",
                "7725327863",
                "Main_2",
                new CorrectionContent12(
                        FfdVersionType.Ffd12,
                        DocumentType.INCOME,
                        Collections.singletonList(
                                new Bill(1.000d,
                                        123.45,
                                        Tax.NONE,
                                        "Булка",
                                        PaymentMethodType.Full,
                                        PaymentSubjectType.Product,
                                        null,
                                        "010460406000600021N4N57RSCBUZTQ\u001d2403004002910161218\u001d1724010191ffd0\u001d92tIAF/YVoU4roQS3M/m4z78yFq0fc/WsSmLeX5QkF/YVWwy8IMYAeiQ91Xa2z/fFSJcOkb2N+uUUmfr4n0mOX0Q==",
                                        (byte)2,
                                        null,
                                        null,
                                        AgentType.Other,
                                        new AgentInfo(Arrays.asList("+79200000001", "+74997870001"),
                                                "Какая-то операция 1",
                                               Collections.singletonList("+79200000003"),
                                                Arrays.asList("+79200000002", "+74997870002"),
                                                "ООО \"Атлант\"",
                                                "Воронеж, ул. Недогонная, д. 84",
                                                "7727257386"),
                                        null,
                                        null,
                                        "Доп. атрибут и все тут",
                                        "643",
                                        "АД 11/77 от 01.08.2018",
                                        23.45,
                                        null,
                                        0.23,
                                        new HashMap<String,Long>(){{put("numerator", 1L);put("denominator", 2L);}},
                                        new HashMap<String,String>(){{
                                            put("foivId", "012");
                                            put( "causeDocumentDate", "12.08.2021");
                                            put( "causeDocumentNumber", "666");
                                            put( "value", "position industry");
                                        }},
                                        new HashMap<String,String>(){{
                                            put("ean8", "46198532");
                                            put( "ean13", "4006670128002");
                                            put( "itf14", "14601234567890");
                                            put( "gs1", "010460043993125621JgXJ5.T");
                                            put("mi", "RU-401301-AAA0277031");
                                            put( "egais20", "NU5DBKYDOT17ID980726019");
                                            put( "egais30", "13622200005881");
                                        }}
                                )),
                        new CheckClose(
                                Collections.singletonList(new Payment(PaymentType.CASH,123.45)),
                                TaxationSystem.USN_INCOME
                        ),
                        "foo@example.com",
                        CorrectionType.OnPrescription,
                        "2021-08-13T00:00:00",
                        "1122334513",
                        new HashMap<String,String>(){{
                            put("name", "Любимая цитата");
                            put( "value", "В здоровом теле здоровый дух, этот лозунг еще не потух!");
                        }},
                        "Доп атрибут чека",
                        null,
                        null,
                        null,
                        "Кассир",
                        null,
                        "ru@example.mail",
                        123.45,
                        null,null,null,
                        null,null,null,
                        new HashMap<String,String>(){{
                            put("name", "Кузнецов Иван Петрович");
                            put( "inn", "7725327863");
                            put("birthDate", "15.09.1988");
                            put( "citizenship", "643");
                            put("identityDocumentCode", "01");
                            put( "identityDocumentData", "multipassport");
                            put( "address", "Басеенная 36");
                        }},
                        new OperationalAttribute("2021-08-12T18:36:16",(byte)0,"operational"),
                        new HashMap<String,String>(){{
                            put("foivId", "010");
                            put( "causeDocumentDate", "11.08.2021");
                            put("causeDocumentNumber", "999");
                            put( "value", "industry");
                        }}
                ),
                "7725327863",
                null,
                null,
                null
        );
    }
}
