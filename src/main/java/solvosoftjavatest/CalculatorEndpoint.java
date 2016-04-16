package solvosoftjavatest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;

/**
 * Created by amayorga on 16/04/16.
 */

@Endpoint
public class CalculatorEndpoint {

    private static final String NAMESPACE_URI = "http://solvosoftjavatest";

    @Autowired
    private CalculatorService calculatorService;

    @PayloadRoot(namespace = NAMESPACE_URI, localPart = "calculateRequest")
    @ResponsePayload
    public CalculateResponse calculate(@RequestPayload CalculateRequest request) {
        CalculateResponse response = new CalculateResponse();
        response.setResult(calculatorService.calculate(request.getInputs()));

        return response;
    }
}
