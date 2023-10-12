# GOALS

We have one major goal, and that is to port all [Paystack APIs](https://paystack.com/docs/api/) into a typed interface.

We hope to achieve the following along the line:

- [ ] Set up a simple pipeline to build and publish the artifact in GitHub, using GitHub Actions
- [ ] Set up DepandaBot to monitor and suggest dependency updates
- [ ] Model all Paystack Request, Response Objects
  - [ ] Transactions
  - [ ] Transactions Split
  - [ ] Terminal
  - [ ] Customers
  - [ ] Dedicated Virtual Accounts
  - [ ] Apple Pay
  - [ ] Subaccounts
  - [ ] Plans
  - [ ] Subscriptions
  - [ ] Products
  - [ ] Payment Pages
  - [ ] Payment Requests
  - [ ] Settlements
  - [ ] Transfer Recipients
  - [ ] Transfers
  - [ ] Transfer Control
  - [ ] Bulk Charges
  - [ ] Integration
  - [ ] Charge
  - [ ] Dispute
  - [ ] Refunds
  - [ ] Verification
  - [ ] Miscellaneous
- [ ] Define and implement interfaces making rest calls to Paystack for the above-mentioned APIs
- [ ] Rest Clients defined above should be represented in the following flavors:
  - [ ] Synchronous - Regular POJO return types
  - [ ] Asynchronous - CompletableFuture/Stage
  - [ ] Reactive - JavaFlow and/or Reactor
- [ ] Spring Boot Starter for the client built above
- [ ] Unit tests ?? Not Sure What Approach Yet
- [ ] Integration tests ?? Not Sure What Approach Yet
- [ ] Functional tests with Cucumber or something else ?? Maybe