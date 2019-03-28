package com.wemanity.KnowledgeManagement.services.impl;

import org.springframework.beans.factory.annotation.Autowired;

import com.wemanity.KnowledgeManagement.entities.Project;
import com.wemanity.KnowledgeManagement.repositories.IProjectRepository;
import com.wemanity.KnowledgeManagement.services.IProjectService;

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

}
