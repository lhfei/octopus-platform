/*
 * Copyright 2010-2011 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.ifeng.octopus.bpm2.web.controller;

import java.util.Map;

import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.octopus.bpm2.commons.util.TDateUtils;
import com.ifeng.octopus.bpm2.web.model.UserSession;
import com.ifeng.octopus.bpm2.web.util.ExtJSReturn;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Aug 31, 2014
 */
@Controller
@RequestMapping("/")
public class HomeController {

	private static final Logger log = LoggerFactory.getLogger(HomeController.class);
	
	@RequestMapping("/index")
	public String index() {
		log.info("forward to home page.");
		return "system/Main";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.POST, 
			consumes = "application/json", produces = "application/json")
	public @ResponseBody Map<String, Object> login(@RequestBody UserSession userSession,HttpSession session) {
		ModelAndView view = new ModelAndView("system/Main");
		view.addObject(UserSession.USER_SESSION, userSession);
		
		userSession.setLoginDate(TDateUtils.getTime(null));
		
		session.setAttribute(UserSession.USER_SESSION, userSession);
		session.setAttribute(UserSession.USER_ID, userSession.getUserId());
		
		return ExtJSReturn.mapOK("0");
		
	}
	
	@RequestMapping("/workStation")
	public ModelAndView workStation(){
		ModelAndView view = new ModelAndView("system/workstation");
		
		return view;
	}
}
