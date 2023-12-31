# Paystack Java Client

> A typed Java Rest client interface for [Paystack APIs](https://paystack.com/docs/api/)

[![Paystack Java Client Maven CI](https://github.com/chriseteka/PaystackJavaClient/actions/workflows/maven-action.yml/badge.svg)](https://github.com/chriseteka/PaystackJavaClient/actions/workflows/maven-action.yml)


The Client comes in 3 flavors:
1. Synchronous - Responses in POJO
2. Asynchronous - Responses in CompletableFuture
3. Reactive - Responses in Mono and Flux

## Setup

1. Add GitHub Maven Package Repository to your POM
```xml
<repositories>
    <repository>
        <id>github</id>
        <url>https://maven.pkg.github.com/chriseteka/paystackjavaclient</url>
    </repository>
</repositories>
```

### 1. When Using SpringBoot
- Add the dependency to your spring boot project:
```xml 
<dependency>
    <groupId>com.chrisworks.paystackclient</groupId>
    <artifactId>paystack-clients-spring-boot-starter</artifactId>
    <version>${VERSION}</version>
</dependency>
```

- Add the following property to you `applications.properties` file
```properties
paystack-client.secret-key=INPUT_YOUR_PAYSTACK_SECRET_KEY_HERE
paystack-client.definition-type=(REACTIVE|NON_REACTIVE) #This property is optional, it defaults to 'NON_REACTIVE' if not specified
```

- Usage
```java
// Imports here

import com.chrisworks.paystackclient.definitions.simple.PlanClient; //When using the non-reactive type
import com.chrisworks.paystackclient.definitions.reactive.PlanClient; //When using the reactive type

@Service
class Example {
    
    private final PlanClient planClient;
    
    public Example(PlanClient planClient) {
        this.planClient = planClient;
    }
    
    public void yourMethodThatDoesAndReturnsSomething() {
        
        //A.
        PlanResponse.Single nonReactiveRes = planClient
                .createPlan(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)));
        
        //Or B.
        Mono<PlanResponse.Single> reactiveRes = planClient
                .createPlan(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)));
    }
}
```
NB: During injection of the client, you can only inject either the REACTIVE type or the NON_REACTIVE type and never both.
The implementation here is powered by the popular Spring WebClient which is part of the Spring Framework Project Reactor.

### 2. Java/Maven Project without SpringBoot
- Add the dependency to your project
```xml
<dependency>
  <groupId>com.chrisworks.paystackclient</groupId>
  <artifactId>paystack-clients</artifactId>
  <version>${VERSION}</version>
</dependency>
```

- usage
```java
// Imports here

import java.util.concurrent.CompletableFuture;

class Example {

    public static void main(String[] args) {
        final PaystackClient client = PaystackClientConfiguration
                .buildPaystackClientFrom("<Your secret key here>");

        //Synchronous
        RichResponse<PlanResponse.Single> syncRes = client
                .plan()
                .createPlan(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)))
                .execute(); //sync call is made at this point

        //fetch plans with query param
        RichResponse<PlanResponse.Multiple> res = client
                .plan()
                .listPlans(new PlanListQueryParam(BigInteger.TEN, BigInteger.ONE)
                        .amount(Amount.actualValue(BigDecimal.valueOf(100_000)).ofCurrency(Currency.NGN))
                        .interval(Interval.BIANNUALLY)
                        .status("approved"))
                .execute();
        
        //fetch plans without query param
        RichResponse<PlanResponse.Multiple> res = client
                .plan()
                .listPlans(null)
                .execute();

        //fetch single plan
        RichResponse<PlanResponse.Single> res = client
                .plan()
                .fetchPlan("id001")
                .execute();
        
        String json = res.raw();
        PlanResponse.Multiple result = res.result();
        Map<String, Object> objectMap = res.rawJsonAsMap();

        //Asynchronous
        CompletableFuture<RichResponse<PlanResponse.Single>> asyncRes = client
                .plan()
                .createPlan(new CreatePlanRequest("Sample Plan 9", Interval.ANNUALLY,
                        Amount.actualValue(BigDecimal.valueOf(1_000_000)).ofCurrency(Currency.NGN)))
                .executeAsync();
    }
}
```
NB: The implementation here is powered by the popular OkHttp library.