package MandelBrot.model;


public class RequestData
{
    private Double realFrom;
    private Double realTo;
    private Double imaginaryFrom;
    private Double imaginaryTo;
    private Double interval;
    private Integer maxIteration;

    public void setRealFrom(Double realFrom)
    {
        this.realFrom = realFrom;
    }

    public Double getRealFrom() {
        return realFrom;
    }

    public void setRealTo(Double realTo)
    {
        this.realTo = realTo;
    }

    public Double getRealTo() {
        return realTo;
    }

    public void setImaginaryFrom(Double imaginaryFrom)
    {
        this.imaginaryFrom = imaginaryFrom;
    }

    public Double getImaginaryFrom() {
        return imaginaryFrom;
    }

    public void setImaginaryTo(Double imaginaryTo)
    {
        this.imaginaryTo = imaginaryTo;
    }

    public Double getImaginaryTo() {
        return imaginaryTo;
    }

    public void setInterval(Double interval)
    {
        this.interval = interval;
    }

    public Double getInterval() {
        return interval;
    }

    public void setMaxIteration(Integer maxIteration)
    {
        this.maxIteration = maxIteration;
    }

    public Integer getMaxIteration() {
        return maxIteration;
    }
}
