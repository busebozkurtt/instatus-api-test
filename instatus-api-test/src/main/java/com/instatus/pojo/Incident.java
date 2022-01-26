package com.instatus.pojo;

import java.util.List;

public class Incident {

	private String name;
	private String message;
	private List<String> components;
	private String started;
	private String status;
	private boolean notify;
	private List<Statuses> statuses;

	public Incident(String name, String message, List<String> components, String started, String status, boolean notify,
			List<Statuses> statuses) {
		super();
		this.name = name;
		this.message = message;
		this.components = components;
		this.started = started;
		this.status = status;
		this.notify = notify;
		this.statuses = statuses;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public List<String> getComponents() {
		return components;
	}

	public void setComponents(List<String> components) {
		this.components = components;
	}

	public String getStarted() {
		return started;
	}

	public void setStarted(String started) {
		this.started = started;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public boolean isNotify() {
		return notify;
	}

	public void setNotify(boolean notify) {
		this.notify = notify;
	}

	public List<Statuses> getStatuses() {
		return statuses;
	}

	public void setStatuses(List<Statuses> statues) {
		this.statuses = statues;
	}

}
