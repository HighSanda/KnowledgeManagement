package com.wemanity.KnowledgeManagement.test.services;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IProjectRepository;
import com.wemanity.KnowledgeManagement.services.impl.ProjectServiceImpl;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ProjectServiceImplTest {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(ProjectServiceImplTest.class);
	private ProjectServiceImpl projectService;
	@Mock
	IProjectRepository projectRepository;
	
	@Before
	public void init() {
		MockitoAnnotations.initMocks(this);
		projectService = new ProjectServiceImpl(projectRepository);
	}
	
	@Test
	public void should_store_when_save_is_called() {
		LOGGER.info("--------------- Executing should_store_when_save_is_called test Of ProjectServiceImplTest ---------------");
		Project myProject = new Project();
		projectService.save(myProject);
		Mockito.verify(projectRepository).save(myProject);
	}
	
	@Test
	public void should_update_when_update_is_called() {
		LOGGER.info("--------------- Executing should_update_when_update_is_called test Of ProjectServiceImplTest ---------------");
		Project myProject = new Project();
		projectService.update(myProject);
		Mockito.verify(projectRepository).save(myProject);
	}

}