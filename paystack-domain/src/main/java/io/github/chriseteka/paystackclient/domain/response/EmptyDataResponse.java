package io.github.chriseteka.paystackclient.domain.response;

/**
 * This is a representation for deserializing all jsons of the following form: <br/>
 * {@code  { "status": true, "message": "message" } }
 * @param status This is the status of the response
 * @param message This is the message attached to the response
 *
 * <br/>This response contains no typed data. Hence, the data() field is always null.
 */
public record EmptyDataResponse(boolean status, String message) implements PaystackSingleResponse<Object> {
    @Override
    public Object data() {
        return null;
    }
}
