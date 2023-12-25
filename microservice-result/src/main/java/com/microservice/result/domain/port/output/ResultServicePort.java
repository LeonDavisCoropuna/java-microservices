package com.microservice.result.domain.port.output;


import com.microservice.result.application.mapper.ResultDto;

import java.util.ArrayList;

public interface ResultServicePort {
    ArrayList<ResultDto> getResult();

}
