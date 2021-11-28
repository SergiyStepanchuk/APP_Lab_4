package testOnline.service.impl;

import org.springframework.stereotype.Component;
import testOnline.dto.TestDTO;
import testOnline.service.TestsService;

import java.util.List;

@Component
public class TestsServiceImpl implements TestsService {
    @Override
    public List<TestDTO> getAllTests() {
        return null;
    }
}
