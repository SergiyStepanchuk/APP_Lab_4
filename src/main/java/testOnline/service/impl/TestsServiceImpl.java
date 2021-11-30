package testOnline.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import testOnline.dto.TestDTO;
import testOnline.mappers.TestToTestDTOMapper;
import testOnline.repositories.TestsRepository;
import testOnline.service.TestsService;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class TestsServiceImpl implements TestsService {
    @Autowired private TestsRepository repo;
    @Autowired private TestToTestDTOMapper testToTestDTOMapper;

    public List<TestDTO> getAllTests() {
        return repo.findAll().stream().map(testToTestDTOMapper::toDTO).collect(Collectors.toList());
    }
}
