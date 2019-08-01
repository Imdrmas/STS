package com.issamdrmas.service;

import java.util.List;
import com.issamdrmas.dto.ApplicationDto;

public interface ApplicationService {
  List<ApplicationDto> findAllApps();
}
