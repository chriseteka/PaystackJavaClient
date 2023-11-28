import com.chrisworks.paystackclient.PaystackClient;
import com.chrisworks.paystackclient.PaystackClientConfiguration;
import com.chrisworks.paystackclient.definitions.CustomerClient;
import com.chrisworks.paystackclient.domain.Amount;
import com.chrisworks.paystackclient.domain.Currency;
import com.chrisworks.paystackclient.domain.Email;
import com.chrisworks.paystackclient.domain.Interval;
import com.chrisworks.paystackclient.domain.customer.CreateCustomerRequest;
import com.chrisworks.paystackclient.domain.customer.DetailedCustomerResponse;
import com.chrisworks.paystackclient.domain.customer.UpdateCustomerRequest;
import com.chrisworks.paystackclient.domain.plan.PlanResponse;
import com.chrisworks.paystackclient.domain.plan.UpdatePlanRequest;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import com.chrisworks.paystackclient.domain.transaction.TransactionResponse;
import com.chrisworks.paystackclient.domain.transaction.TransactionTotalResponse;

import java.math.BigDecimal;
import java.math.BigInteger;

public class Playground {

    public static void main(String[] args) {
        //Usage sample
        final PaystackClient client = PaystackClientConfiguration.buildPaystackClientFrom("<Your secret key here>");
//        RichResponse<PlanResponse.Single> res1 = client
//                .plan()
//                .createPlan(new CreatePlanRequest("Sample Plan 9", Interval.DAILY,
//                        Amount.actualValue(BigDecimal.valueOf(10_000)).ofCurrency(Currency.NGN)))
//                .execute();
//        System.out.println(res1);

//        Void res = client
//                .plan()
//                .fetchPlan("PLN_16x08vyy3bu2h7x")
//                .executeAsync()
//                .thenAccept(re -> System.out.println(re.result()))
//                .join();

//        RichResponse<TransactionResponse.Single> transactions = client
//                .transaction()
//                .fetchTransaction(BigInteger.valueOf(3200117924L))
//                .execute();

        RichResponse<DetailedCustomerResponse.Single> total = client.transaction().transactionTotals(null)
                .executeAsync()
                .thenComposeAsync(a -> client.customer().fetchCustomer("CUS_7x1zrws6go48eiw").executeAsync())
                .join();

//        final CustomerClient customerClient = client.customer();
//        RichResponse<DetailedCustomerResponse.Single> customer = customerClient
//                .fetchCustomer("CUS_7x1zrws6go48eiw").execute();


//        RichResponse<DetailedCustomerResponse.Single> customer = customerClient
//                .updateCustomer("CUS_6mptpy70qdednea", new UpdateCustomerRequest(
//                        "Godswill", "Akpabio", "08077796848"))
//                .execute();

//        RichResponse<PlanResponse.Single> planUpdate = client.plan().updatePlan("PLN_16x08vyy3bu2h7x",
//                        new UpdatePlanRequest("Maldives Plan", Interval.BIANNUALLY,
//                                Amount.actualValue(new BigDecimal("9500000")).ofCurrency(Currency.NGN))
//                                .description("Balling money for december in Maldives"))
//                .execute();

//        RichResponse<PlanResponse.Single> res2 = client
//                .plan()
//                .fetchPlan("PLN_16x08vyy3bu2h7x")
//                .execute();
//        System.out.println(transactions);
        System.out.println(total);
//        System.out.println(customer);
//        System.out.println(planUpdate);

//        String json = res.raw();
//        PlanResponse.Multiple result = res.result();
//        Map<String, Object> objectMap = res.rawJsonAsMap();
    }
}
