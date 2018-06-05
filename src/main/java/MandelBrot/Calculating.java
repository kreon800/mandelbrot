package MandelBrot;

import MandelBrot.model.*;
import MandelBrot.number.Complex;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Service("calcService")
public class Calculating {
    private BigDecimal realFrom;
    private BigDecimal realTo;
    private BigDecimal imaginaryFrom;
    private BigDecimal imaginaryTo;
    private BigDecimal interval;
    private BigDecimal iteration;
    private List<Double> calculationList = new ArrayList<>();
    private RequestData requestData;
    private ResponseData responseData = new ResponseData();

    Calculating request(RequestData requestData) {
        this.requestData = requestData;
        return this;
    }

    Calculating resolve() {
        if (requestData == null) {
            throw new NullPointerException("The request data must be set.");
        }
        this.realFrom = BigDecimal.valueOf(requestData.getRealFrom());
        this.realTo = BigDecimal.valueOf(requestData.getRealTo());
        this.imaginaryFrom = BigDecimal.valueOf(requestData.getImaginaryFrom());
        this.imaginaryTo = BigDecimal.valueOf(requestData.getImaginaryTo());
        this.interval = BigDecimal.valueOf(requestData.getIntervall());
        this.iteration = BigDecimal.valueOf(requestData.getMaxIteration());

        calculationList.clear();
        return this;
    }

    Calculating calc() {
        for (BigDecimal real = realFrom; real.compareTo(realTo) == -1 || real.compareTo(realTo) == 0; real = real.add(interval)) {
            for (BigDecimal imaginary = imaginaryFrom; imaginary.compareTo(imaginaryTo) == -1 || imaginary.compareTo(imaginaryTo) == 0; imaginary = imaginary.add(interval)) {
                getCalculationList().add(mandelbrot(real, imaginary, iteration).doubleValue());
            }
        }
        return this;
    }

    ResponseData response() {
        responseData.setResponse(getCalculationList());
        return responseData;
    }

    private List<Double> getCalculationList() {
        return calculationList;
    }

    public RequestData getRequestData() {
        return requestData;
    }

    public ResponseData getResponseData() {
        return responseData;
    }

    private BigDecimal mandelbrot(BigDecimal real, BigDecimal imag, BigDecimal iteration) {
        Complex c = new Complex(real.doubleValue(), imag.doubleValue());
        Complex z = new Complex(0.0, 0.0);

        for (BigDecimal i = BigDecimal.ZERO; i.compareTo(iteration) == -1 || i.compareTo(iteration) == 0; i = i.add(BigDecimal.ONE)) {
            z = z.times(z).plus(c);
            if ((z.real() * z.real()) + (z.imag() * z.imag()) >= 4) {
                return i;
            }
        }

        return iteration;
    }
}