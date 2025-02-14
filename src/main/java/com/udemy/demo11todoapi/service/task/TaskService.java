package com.udemy.demo11todoapi.service.task;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.udemy.demo11todoapi.repository.task.TaskEntityNotFoundException;
import com.udemy.demo11todoapi.repository.task.TaskRecord;
import com.udemy.demo11todoapi.repository.task.TaskRepository;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TaskService {
	
	private final TaskRepository taskRepository;

	public TaskEntity find(long taskId) {
		return taskRepository.select(taskId)
				.map(record -> new TaskEntity(record.getId(), record.getTitle()))
				.orElseThrow(() -> new TaskEntityNotFoundException(taskId)); // TODO
	}
	
	public List<TaskEntity> find(int limit, long offset) {
		return taskRepository.selectList(limit, offset)
				.stream()
				.map(record -> new TaskEntity(record.getId(), record.getTitle()))
				.collect(Collectors.toList());
	}
	
	public TaskEntity create(String title) {
		var record = new TaskRecord(null, title);
		taskRepository.insert(record);
		
		return new TaskEntity(record.getId(), record.getTitle());
	}

	public TaskEntity update(Long taskId, String title) {
		taskRepository.select(taskId)
						.orElseThrow(() -> new TaskEntityNotFoundException(taskId));
		taskRepository.update(new TaskRecord(taskId, title));
		return find(taskId);
	}

	public void delete(Long taskId) {
		taskRepository.select(taskId)
						.orElseThrow(() -> new TaskEntityNotFoundException(taskId));
		taskRepository.delete(taskId);
	}
}
