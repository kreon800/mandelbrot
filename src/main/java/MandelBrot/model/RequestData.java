package MandelBrot.model;


public class RequestData
{
    private Double RealFrom;
    private Double RealTo;
    private Double ImaginaryFrom;
    private Double ImaginaryTo;
    private Double Intervall;
    private Integer MaxIteration;

    public void setRealFrom(Double realFrom)
    {
        this.RealFrom = realFrom;
    }

    public Double getRealFrom() {
        return RealFrom;
    }

    public void setRealTo(Double realTo)
    {
        this.RealTo = realTo;
    }

    public Double getRealTo() {
        return RealTo;
    }

    public void setImaginaryFrom(Double imaginaryFrom)
    {
        this.ImaginaryFrom = imaginaryFrom;
    }

    public Double getImaginaryFrom() {
        return ImaginaryFrom;
    }

    public void setImaginaryTo(Double imaginaryTo)
    {
        this.ImaginaryTo = imaginaryTo;
    }

    public Double getImaginaryTo() {
        return ImaginaryTo;
    }

    public void setIntervall(Double intervall)
    {
        this.Intervall = intervall;
    }

    public Double getIntervall() {
        return Intervall;
    }

    public void setMaxIteration(Integer maxIteration)
    {
        this.MaxIteration = maxIteration;
    }

    public Integer getMaxIteration() {
        return MaxIteration;
    }
}
