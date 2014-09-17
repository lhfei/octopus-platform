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

package com.ifeng.octopus.bpm2.services.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.ifeng.octopus.bpm2.services.ILogService;

/**
 * @version 0.1
 *
 * @author Hefei Li
 *
 * @since Sep 3, 2014
 */
@Service("logService")
public class LogService implements ILogService {

	private static final Logger log = LoggerFactory.getLogger(LogService.class);
	
	public void doLog() {
		log.info(LogService.class +": doLog() executed ."); 
	}
}
