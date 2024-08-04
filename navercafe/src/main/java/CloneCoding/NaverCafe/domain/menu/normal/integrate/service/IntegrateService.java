package CloneCoding.NaverCafe.domain.menu.normal.integrate.service;

import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestCreateIntegrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.RequestUpdateIntegrate;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.ResponseCreateForm;
import CloneCoding.NaverCafe.domain.menu.normal.integrate.dto.ResponseUpdateForm;

public interface IntegrateService {

    ResponseCreateForm createIntegrateForm(String token);

    String createIntegrate(RequestCreateIntegrate request, String url, String token);

    ResponseUpdateForm createIntegrateUpdateForm(Long id, String token);

    String updateIntegrate(RequestUpdateIntegrate request, Long id, String token);

}
