package MandelBrot.model;

import java.util.ArrayList;
import java.util.List;

public class ResponseData
{
    private List<Double> response;

    public ResponseData ()
    {
        response = new ArrayList<>();
    }

    public List<Double> getResponse()
    {
        return response;
    }

    public void setResponse(List<Double> response)
    {
        this.response = response;
    }
}
