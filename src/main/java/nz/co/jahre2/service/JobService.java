package nz.co.jahre2.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import nz.co.jahre.dto.JobDto;

import org.springframework.stereotype.Service;

@Service
public class JobService {

	public JobDto getJob(Long id) {
		JobDto j = new JobDto();
		j.setId(id);
		j.setType("Default");
		j.setCreationDate(new Date());
		return j;
	}
	
	public List<JobDto> listJobs() {
		List<JobDto> jobs = new ArrayList<JobDto>();
		jobs.add(getJob(1L));
		jobs.add(getJob(2L));
		
		return jobs;
	}
}
