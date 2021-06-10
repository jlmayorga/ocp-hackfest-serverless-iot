package functions;

import io.quarkus.funqy.Context;
import io.quarkus.funqy.Funq;
import io.quarkus.funqy.knative.events.CloudEvent;
import io.quarkus.funqy.knative.events.CloudEventBuilder;
import io.quarkus.funqy.knative.events.CloudEventMapping;

public class Function {

    @Funq
    @CloudEventMapping(responseType = "iot.input.processed")
    public CloudEvent<Output> function(CloudEvent<Input> input) {
        System.out.println(input);
        Output output = new Output(input.data());
        return CloudEventBuilder.create().build(output);
    }

}
