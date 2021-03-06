package com.wemanity.KnowledgeManagement.services.impl;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wemanity.KnowledgeManagement.dto.ProjectDto;
import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.entities.User;
import com.wemanity.KnowledgeManagement.repositories.IProjectRepository;
import com.wemanity.KnowledgeManagement.services.IProjectService;

@Service
public class ProjectServiceImpl implements IProjectService {

	@Autowired
	IProjectRepository projectRepository;
	
	public ProjectServiceImpl(IProjectRepository projectRepository) {
		this.projectRepository = projectRepository;
	}

	@Override
	public Project save(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public Project update(Project project) {
		return projectRepository.save(project);
	}

	@Override
	public void delete(Project project) {	
		projectRepository.delete(project);
	}

	@Override
	public Project findById(Integer id) {
		return projectRepository.findById(id).orElse(null);
	}

	@Override
	public List<Project> findAll() {
		return projectRepository.findAll();
	}

	@Override
	public Project getProjectFromProjectDto(ProjectDto project) {
		return new Project(project.getId(), project.getTitle(), project.getBusinessField(), project.getCustomer(), new User(), new Date());
	}

}
