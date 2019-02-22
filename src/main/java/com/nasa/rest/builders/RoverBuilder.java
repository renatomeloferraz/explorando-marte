package com.nasa.rest.builders;

import com.nasa.rest.requests.RoverRequest;
import org.springframework.stereotype.Component;

@Component
public class RoverBuilder {
    public RoverRequest create(RoverRequest request) {
        return request;
    }
}
