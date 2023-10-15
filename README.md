# Paystack Java Client

> A typed Java Rest client interface for [Paystack APIs](https://paystack.com/docs/api/)

[![Paystack Java Client Maven CI](https://github.com/chriseteka/PaystackJavaClient/actions/workflows/maven-action.yml/badge.svg)](https://github.com/chriseteka/PaystackJavaClient/actions/workflows/maven-action.yml)


The Client comes in 3 flavors:
1. Synchronous - Responses in POJO
2. Asynchronous - Responses in CompletableFuture
3. Reactive - Responses in Mono and Flux

Example:

```java
// Imports here

import java.util.concurrent.CompletableFuture;

class Example {

    public static void main(String[] args) {
        final PaystackClient client = PaystackClientConfiguration
                .buildPaystackClientFrom("<Your secret key here>");

        //Synchronous
        RichResponse<PlanResponse.Single> syncRes = client.synchronous()
                .plan()
                .create(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)));

        //fetch plans with query param
        RichResponse<PlanResponse.Multiple> res = client.synchronous()
                .plan()
                .fetchMultiple(new PlanListQueryParam(BigInteger.TEN, BigInteger.ONE)
                        .amount(Amount.actualValue(BigDecimal.valueOf(100_000)).ofCurrency(Currency.NGN))
                        .interval(Interval.BIANNUALLY)
                        .status("approved"));
        
        //fetch plans without query param
        RichResponse<PlanResponse.Multiple> res = client.synchronous()
                .plan()
                .fetchMultiple(null);

        //fetch single plan
        RichResponse<PlanResponse.Single> res = client.synchronous()
                .plan()
                .fetchByIdOrCode("id001");
        
        String json = res.raw();
        PlanResponse.Multiple result = res.result();
        Map<String, Object> objectMap = res.rawJsonAsMap();

        //Asynchronous
        CompletableFuture<RichResponse<PlanResponse.Single>> asyncRes = client.asynchronous()
                .plan()
                .create(new CreatePlanRequest("Sample Plan 9", Interval.ANNUALLY,
                        Amount.actualValue(BigDecimal.valueOf(1_000_000)).ofCurrency(Currency.NGN)));
    }
}
```