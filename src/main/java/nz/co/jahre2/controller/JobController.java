package nz.co.jahre2.controller;

import java.util.List;

import nz.co.jahre.dto.JobDto;
import nz.co.jahre2.service.JobService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping
public class JobController {

	@Autowired
	private JobService js;
	
	@RequestMapping(value="/job/{jobId}", method = RequestMethod.GET)
	public String getJob(@PathVariable Long jobId, ModelMap map) {
		JobDto job = js.getJob(jobId);
		map.addAttribute(job);
		return "job";
	}
	
	@RequestMapping(value="/jobs", method = RequestMethod.GET)
	public String getJobs(ModelMap map) {
		List<JobDto> jobs = js.listJobs();
		map.addAllAttributes(jobs);
		return "jobList";
	}
}
