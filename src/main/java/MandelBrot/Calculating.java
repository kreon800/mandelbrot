package MandelBrot;

import MandelBrot.model.*;
import MandelBrot.number.Complex;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("calcService")
public class Calculating {
    private Double realFrom;
    private Double realTo;
    private Double imaginaryFrom;
    private Double imaginaryTo;
    private Double interval;
    private Integer iteration;
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
        this.realFrom = requestData.getRealFrom();
        this.realTo = requestData.getRealTo();
        this.imaginaryFrom = requestData.getImaginaryFrom();
        this.imaginaryTo = requestData.getImaginaryTo();
        this.interval = requestData.getIntervall();
        this.iteration = requestData.getMaxIteration();
        return this;
    }

    Calculating calc() {
        for (double real = realFrom; real <= realTo; real = real + interval) {
            for (double imaginary = imaginaryFrom; imaginary <= imaginaryTo; imaginary = imaginary + interval) {
                getCalculationList().add(mandelbrot(real, imaginary, iteration));
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

    private Double mandelbrot(Double real, Double imag, Integer iteration) {
        Complex c = new Complex(real, imag);
        Complex z = new Complex(0.0, 0.0);

        for (int i = 0; i <= iteration; ++i) {
            z = z.times(z).plus(c);
            if ((z.real() * z.real()) + (z.imag() * z.imag()) >= 4) {
                return (double) i;
            }
        }

        return (double) iteration;
    }

//    void Calculate(RequestData _requestData)
//    {
//
//        ArrayList<Double> response = new ArrayList<>();
//
//        //ToDo: Return values have to be the amount of iterations
//        do
//        {
//            Double convergent = isConvergent(realFrom, imaginaryFrom, iteration);
//            response.add(convergent);
//            if (realFrom <= realTo)
//            {
//                realFrom = realFrom + interval;
//            }
//            if (imaginaryFrom <= imaginaryTo)
//            {
//                imaginaryFrom = imaginaryFrom + interval;
//            }
//        } while(realFrom <= realTo && imaginaryFrom <= imaginaryTo);
//
//        responseData.setResponse(response);
//    }
//
//    private Double isConvergent(Double _realFrom, Double _imaginaryFrom, Integer _iteration)
//    {
//        double real = 0.0;
//        double imaginary = 0.0;
//        double iterations = 0.0;
//        while (real * real + imaginary * imaginary <= 2.0 && iterations < _iteration) {
//            double result = real * real - imaginary * imaginary + _realFrom;
//            imaginary = 2 * real * imaginary + _imaginaryFrom;
//            real = result;
//            iterations++;
//        }
//        return iterations;
//
////        Integer iterations = 0;
////        double z = 0, z2, c = 0;
////
////        for (int n = 0; n < _iteration; n++)
////        {
//////            iterations = n;
////            if (z * z + c * c > 2)
////            {
////                return iterations; //false
////            }
////            z2 = z * z - c * c + _realFrom; //_X
////            c = 2 * z * c + _imaginaryFrom; //_Y
////            z = z2;
////            iterations = n;
////        }
////        return iterations;//true
//    }
}