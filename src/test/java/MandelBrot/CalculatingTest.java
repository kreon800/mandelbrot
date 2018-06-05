package MandelBrot;

import MandelBrot.model.RequestData;
import org.junit.Test;

/**
 * @author p.schulz
 */
public class CalculatingTest {

    @Test
    public void calculatingTest() throws Exception {
        RequestData data = new RequestData();
        data.setRealFrom(-2.0D);
        data.setRealTo(1.0D);
        data.setImaginaryFrom(-1.0D);
        data.setImaginaryTo(1.0D);
        data.setIntervall(0.01D);
        data.setMaxIteration(100);

        new Calculating().request(data).resolve().calc().response();
    }
}