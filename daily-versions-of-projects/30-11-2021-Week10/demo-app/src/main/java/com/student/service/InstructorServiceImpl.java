package com.student.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.student.model.Course;
import com.student.model.Instructor;
import com.student.model.dto.InstructorDTO;
import com.student.repository.CourseRepository;
import com.student.repository.InstructorRepository;

@Service
public class InstructorServiceImpl implements InstructorService {
	@Autowired
	InstructorRepository instructorRepository;

	@Autowired
	CourseRepository courseRepository;

	@Override
	public Instructor save(Instructor ins) {
		for (Course course : ins.getCourses()) {
			courseRepository.save(course);

		}

		return instructorRepository.save(ins);
	}

	@Override
	public List<InstructorDTO> getAll(String orderBy) {
		List<InstructorDTO> list = new ArrayList<>();
		List<Instructor> insList = new ArrayList<Instructor>();
		if (orderBy != null) {
			Sort sort = Sort.by(Direction.ASC, orderBy);
			insList = instructorRepository.findAll(sort);
		} else {
			insList = instructorRepository.findAll();
		}

		for (Instructor instructor : insList) {
			InstructorDTO dto = new InstructorDTO();
			dto.setId(instructor.getId());
			dto.setName(instructor.getName());
			list.add(dto);

		}
		return list;
	}

	@Override
	public Instructor getById(int id) {
		return instructorRepository.findById(id).get();
	}

	@Override
	@Transactional
	public void deleteById(int instructorId) {
		courseRepository.unassignInstructor(instructorId);
		instructorRepository.deleteById(instructorId);
	}

}
