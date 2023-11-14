import com.chrisworks.paystackclient.PaystackClient;
import com.chrisworks.paystackclient.PaystackClientConfiguration;
import com.chrisworks.paystackclient.domain.response.RichResponse;
import com.chrisworks.paystackclient.domain.transaction.TransactionResponse;
import com.chrisworks.paystackclient.domain.transaction.TransactionTotalResponse;

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

        RichResponse<TransactionResponse.Single> transactions = client
                .transaction()
                .fetchTransaction(BigInteger.valueOf(3200117924L))
                .execute();

        RichResponse<TransactionTotalResponse.Single> total = client.transaction().transactionTotals(null).execute();


//        RichResponse<PlanResponse.Single> res2 = client
//                .plan()
//                .fetchPlan("PLN_16x08vyy3bu2h7x")
//                .execute();
        System.out.println(transactions);
        System.out.println(total);

//        String json = res.raw();
//        PlanResponse.Multiple result = res.result();
//        Map<String, Object> objectMap = res.rawJsonAsMap();
    }
}
