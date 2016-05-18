package it.uniroma3.action;

import javax.servlet.http.HttpServletRequest;

public interface Action {

	public String perform(HttpServletRequest request);

}
