# Paystack Java Client

> A typed Java Rest client interface for [Paystack APIs](https://paystack.com/docs/api/)

The Client comes in 3 flavors:
1. Synchronous - Responses in POJO
2. Asynchronous - Responses in CompletableFuture
3. Reactive - Responses in Mono and Flux

Example:

```java
// Imports here

class Example {

    public static void main(String[] args) {
        final PaystackClient client = PaystackClientConfiguration
                .buildPaystackClientFrom("<Your secret key here>");

        //Synchronous
        ApplePayResponse.Multiple syncRes = client
                .synchronous()
                .applePayClient()
                .findMultiple();

        //Asynchronous
        CompletableFuture<ApplePayResponse.Multiple> asyncRes = client
                .asynchronous()
                .applePayClient()
                .findMultiple();
    }
}
```