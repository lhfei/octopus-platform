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

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.slf4j.Marker;
import org.slf4j.MarkerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.ModelAndView;

import com.ifeng.octopus.bpm2.web.model.UserSession;
import com.ifeng.octopus.bpm2.web.util.ExtJSReturn;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 10, 2014
 */
@Controller
@RequestMapping("ifeng")
@SessionAttributes(UserSession.USER_SESSION)
public class IfengProcessController {
	
	private static final Logger log = LoggerFactory.getLogger(IfengProcessController.class);
	private Marker marker = MarkerFactory.getMarker("Ifeng");
	
	@RequestMapping("videoList")
	public ModelAndView videoList() {
		ModelAndView view = new ModelAndView("ifeng/videoList");
		log.info("forward to vedio list page.",marker);
		return view;
	}
	
	@RequestMapping(value="getVideoList",consumes="application/json",
			produces="application/json", method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> getVideoList() {
		log.info("Method {} has be extcuted. ", "getVedioList()");
		
		return ExtJSReturn.mapOK("");
	}
}
