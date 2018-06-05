package MandelBrot;

import MandelBrot.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "0.0.0.0", maxAge = 3600)
@RestController
public class Controller {
    @Autowired
    Calculating calculating;

    @RequestMapping(value = "/", method = RequestMethod.POST, consumes = {"application/JSON"}, produces = {"application/JSON"})
    @ResponseStatus(value = HttpStatus.OK)
    @ResponseBody
    public ResponseData Calculating(@RequestBody RequestData requestData) {
        return calculating.request(requestData)
                          .resolve()
                          .calc()
                          .response();
    }
}