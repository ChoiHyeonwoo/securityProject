package com.spring.security.core.voter;

import com.spring.security.service.SecurityResourceService;
import org.springframework.security.access.AccessDecisionVoter;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.WebAuthenticationDetails;

import java.util.Collection;
import java.util.List;
// ip 체크를 통해 access를 체크
public class IpAddressVoter implements AccessDecisionVoter<Object> {

    private SecurityResourceService securityResourceService;

    public IpAddressVoter(SecurityResourceService securityResourceService) {

        this.securityResourceService = securityResourceService;
    }

    @Override
    public boolean supports(ConfigAttribute attribute) {
        return true;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return true;
    }
    // 실질적으로 ip를 체크후 처리하는 함수
    @Override
    public int vote(Authentication authentication, Object object, Collection<ConfigAttribute> attributes) {

        WebAuthenticationDetails details = (WebAuthenticationDetails)authentication.getDetails();
        String remoteAddress = details.getRemoteAddress();

        List<String> accessIpList = securityResourceService.getAccessIpList();

        /*int ACCESS_GRANTED = 1;
        int ACCESS_ABSTAIN = 0;
        int ACCESS_DENIED = -1;*/
        int result = ACCESS_DENIED;

        for(String ipAddress : accessIpList){
            if(remoteAddress.equals(ipAddress)){
                return ACCESS_ABSTAIN;  // GRANTED로 부여 시 다른 필터는 체크 안하고 바로 넘어간다. ABSTAIN의 경우 다음 필터로!
            }
        }

        if(result == ACCESS_DENIED){
            throw new AccessDeniedException("Invalid IpAddress");
        }

        return result;
    }
}
